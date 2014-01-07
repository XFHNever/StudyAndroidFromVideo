package com.example.studyfromvideo.nfc;

import java.io.IOException;

import com.example.studyfromvideo.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.MifareClassic;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.GINGERBREAD_MR1)
public class NFCTestActivity extends Activity{
	private NfcAdapter nfcAdapter = null;
	private TextView nfc_textView = null;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.nfc_test);
    	initView();
    }

	private void initView() {
		// TODO Auto-generated method stub
		nfc_textView = (TextView) findViewById(R.id.nfc_textView);
		
		nfcAdapter = NfcAdapter.getDefaultAdapter(this);
		if(nfcAdapter == null) {
			nfc_textView.setText("this device does not support NFC!!");
			finish();
			return;
		}
		
		if(!nfcAdapter.isEnabled()) {
			nfc_textView.setText("Please open NFC in the system first!!");
			finish();
			return;
		}
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(NfcAdapter.ACTION_TECH_DISCOVERED.equals(getIntent().getAction())) {
			processIntent(getIntent());
		}
	}
	
	private void processIntent(Intent intent) {
		Tag tagFromIntentTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
		for(String tech:tagFromIntentTag.getTechList()) {
			System.out.println(tech);
		}
		
		boolean auth = false;
		
		MifareClassic mfc = MifareClassic.get(tagFromIntentTag);
	
		String metaInfo = "";
		try {
			mfc.connect();
			int type = mfc.getType();
			int sectorCount = mfc.getSectorCount();
			String types = "";
			switch (type) {
			case MifareClassic.TYPE_CLASSIC:
				types = "TYPE_CLASSIC";
				break;
			case MifareClassic.TYPE_PRO:
				types = "TYPE_PRO";
				break;
			case MifareClassic.TYPE_PLUS:
				types = "TYPE_PLUS";
				break;
			case MifareClassic.TYPE_UNKNOWN:
				types = "TYPE_UNKNOWN";
				break;
			
			}
			
			metaInfo += "卡片类型：" + types + "\n共" + sectorCount + "个扇区\n共"  
                    + mfc.getBlockCount() + "个块\n存储空间: " + mfc.getSize() + "B\n";  
			
			for (int j=0; j<sectorCount; j++) {
				auth = mfc.authenticateSectorWithKeyA(j, MifareClassic.KEY_DEFAULT);
				int bCount;
				int bIndex;
				if(auth) {
				 metaInfo += "Sector " + j + ":验证成功\n";  
                    // 读取扇区中的块  
                    bCount = mfc.getBlockCountInSector(j);  
                    bIndex = mfc.sectorToBlock(j);  
                    for (int i = 0; i < bCount; i++) {  
                        byte[] data = mfc.readBlock(bIndex);  
                        metaInfo += "Block " + bIndex + " : "  
                                + bytesToHexString(data) + "\n";  
                        bIndex++;  
                    }  
                } else {  
                    metaInfo += "Sector " + j + ":验证失败\n";  
                }  
				
				nfc_textView.setText(metaInfo);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    //字符序列转换为16进制字符串  
    private String bytesToHexString(byte[] src) {  
        StringBuilder stringBuilder = new StringBuilder("0x");  
        if (src == null || src.length <= 0) {  
            return null;  
        }  
        char[] buffer = new char[2];  
        for (int i = 0; i < src.length; i++) {  
            buffer[0] = Character.forDigit((src[i] >>> 4) & 0x0F, 16);  
            buffer[1] = Character.forDigit(src[i] & 0x0F, 16);  
            System.out.println(buffer);  
            stringBuilder.append(buffer);  
        }  
        return stringBuilder.toString();  
    }  
}
