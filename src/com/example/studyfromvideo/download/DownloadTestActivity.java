package com.example.studyfromvideo.download;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

import org.apache.http.conn.util.InetAddressUtils;

import com.example.studyfromvideo.R;
import com.example.studyfromvideo.R.id;
import com.example.studyfromvideo.R.layout;

import android.R.string;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class DownloadTestActivity extends Activity{
	private Button download_text_button = null;
	private Button download_file_button = null;
	private TextView download_textView = null;
	DownloadHelper downloadHelper = null;
	String result = null;
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
//				String ip_str = "192.168.45.18";
				result = downloadHelper.download("http://10.0.2.2:8080/mp3/test.lrd");
//				new MyAncyncTask().execute();
				System.out.println("result=" + result);
				download_textView.append("result=" + result);
			}
		});
		
		download_file_button = (Button) findViewById(R.id.download_file_button);
		download_file_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int result = downloadHelper.downFile("http://10.0.2.2:8080/Grails.pdf", "never/", "test1");
			    System.out.println(result);
			    download_textView.append("downfile result" + result);
			}
		});
		
		download_textView = (TextView) findViewById(R.id.download_textView);
	}
	
	
	class MyAncyncTask extends AsyncTask {

		@Override
		public String doInBackground(Object... params) {
			// TODO Auto-generated method stub
			System.out.println("dobackground");
			String ip_str = "127.0.0.1";
			result = downloadHelper.download("http://mrtwo.org/Android/mrtwo.txt");
			System.out.println("end");
			return result;
		}
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			System.out.println("OnPreExcute");
		}
		
		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			System.out.println("onPostExecute");
			System.out.println("result" + DownloadTestActivity.this.result);
		}
	}

      
}
