package com.example.studyfromvideo;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button intent_test_button = null;
    private Button handler_test_button = null;
    private Button sqlite_test_button = null;
    private Button download_test_button = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add(0, 1, 1, R.string.exit);
		menu.add(0, 2, 2, R.string.about);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() == 1){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	

	public void initView(){
		intent_test_button = (Button) findViewById(R.id.myButton1);
		intent_test_button.setOnClickListener( new IntentTestListener());
		
		handler_test_button = (Button) findViewById(R.id.handler_button);
		handler_test_button.setOnClickListener(new HandlerTestListener());
		
		sqlite_test_button = (Button) findViewById(R.id.sqlite_button);
		sqlite_test_button.setOnClickListener(new SqLiteTestListener());
		
		download_test_button = (Button) findViewById(R.id.download_button);
		download_test_button.setOnClickListener(new DownloadTestListener());
	}
	
	class IntentTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.putExtra("test", "test success");
			Bundle bundle = new Bundle();
			bundle.putInt("BigFour", 4);
			intent.putExtras(bundle);
			intent.setClass(MainActivity.this, IntentTestActivity.class);
			startActivity(intent);
		}
		
	}
	
	class HandlerTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, HandlerTestActivity.class);
			startActivity(intent);
		}
		
	}
	
	class SqLiteTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, SQLiteTestActivity.class);
			startActivity(intent);
		}
		
	}
	
	class DownloadTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, DownloadTestActivity.class);
			startActivity(intent);
		}
		
	}
}
