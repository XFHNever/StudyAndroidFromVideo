package com.example.studyfromvideo.download;

import com.example.studyfromvideo.R;
import com.example.studyfromvideo.R.id;
import com.example.studyfromvideo.R.layout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class DownloadTestActivity extends Activity{
	private Button download_text_button = null;
	private Button download_file_button = null;
	DownloadHelper downloadHelper = null;
      @TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.download);
        // to solve the exception "android.os.NetworkOnMainThreadException"
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());
    	downloadHelper = new DownloadHelper();
    	initView();
    }
      
	private void initView() {
		// TODO Auto-generated method stub
		download_text_button = (Button) findViewById(R.id.download_text_button);
		download_text_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String result = downloadHelper.download("http://127.0.0.1:8080/test.txt");
				System.out.println("result=" + result);
			}
		});
		
		download_file_button = (Button) findViewById(R.id.download_file_button);
		download_file_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int result = downloadHelper.downloadFile("http://127.0.0.1:8080/Grails.pdf", "never/", "test2");
			    System.out.println(result);
			}
		});
	}
      
}
