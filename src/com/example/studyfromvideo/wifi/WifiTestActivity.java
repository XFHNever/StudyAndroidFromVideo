package com.example.studyfromvideo.wifi;

import com.example.studyfromvideo.MainActivity;
import com.example.studyfromvideo.R;
import com.example.studyfromvideo.handler.HandlerTestActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WifiTestActivity extends Activity{
	private Button start_wifi_button,stop_wifi_button,check_wifi_button;
	private TextView wifi_textView;
	private WifiManager wifiManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.wifi_test);
    	initView();
    }
    
    private void initView() {
		start_wifi_button = (Button) findViewById(R.id.start_wifi_button);
		start_wifi_button.setOnClickListener(new StartWifiListener());
		
		stop_wifi_button = (Button) findViewById(R.id.stop_wifi_button);
		stop_wifi_button.setOnClickListener(new StopWifiListener());
		
		check_wifi_button = (Button) findViewById(R.id.check_wifi_button);
		check_wifi_button.setOnClickListener(new CheckWifiListener());
		
		wifi_textView = (TextView) findViewById(R.id.wifi_textView);
        
	}
    
	class StartWifiListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
            wifi_textView.append("startWifi");
            wifiManager = (WifiManager) WifiTestActivity.this.getSystemService(Context.WIFI_SERVICE);
            wifiManager.setWifiEnabled(true);
            wifi_textView.append("wifi state------->" + wifiManager.getWifiState());
            System.out.println("wifi state------->" + wifiManager.getWifiState());
		}
		
	}
	
	class StopWifiListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			wifi_textView.append("stopWifi");
            wifiManager = (WifiManager) WifiTestActivity.this.getSystemService(Context.WIFI_SERVICE);
            wifiManager.setWifiEnabled(false);
            wifi_textView.append("wifi state------->" + wifiManager.getWifiState());
            System.out.println("wifi state------->" + wifiManager.getWifiState());
		}
		
	}
	
	class CheckWifiListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			wifi_textView.append("checkWifi");
            wifiManager = (WifiManager) WifiTestActivity.this.getSystemService(Context.WIFI_SERVICE);
            wifi_textView.append("wifi state------->" + wifiManager.getWifiState());
            System.out.println("wifi state------->" + wifiManager.getWifiState());
		}
		
	}
}
