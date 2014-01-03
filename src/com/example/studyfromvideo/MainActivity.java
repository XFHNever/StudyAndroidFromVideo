package com.example.studyfromvideo;

import com.example.studyfromvideo.animation.AnimationTestActivity;
import com.example.studyfromvideo.appwidget.WidgetTestActivity;
import com.example.studyfromvideo.broadcast.BroadcastTestActivity;
import com.example.studyfromvideo.complexcomponent.ComplexCompActivity;
import com.example.studyfromvideo.contentprovider.CPTestActivity;
import com.example.studyfromvideo.download.DownloadTestActivity;
import com.example.studyfromvideo.expandableListView.EXListViewActivity;
import com.example.studyfromvideo.handler.HandlerTestActivity;
import com.example.studyfromvideo.intent.IntentTestActivity;
import com.example.studyfromvideo.sqlite.SQLiteTestActivity;
import com.example.studyfromvideo.wifi.WifiTestActivity;
import com.example.studyfromvideo.xml.SAXTestActivity;

import android.os.Bundle;
import android.app.Activity;
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
    private Button broadcast_test_button = null;
    private Button sax_test_button = null;
    private Button cp_test_button = null;
    private Button wifi_test_button = null;
    private Button complexComp_test_button = null;
    private Button exlistView_test_button = null;
    private Button widget_test_button = null;
    private Button animation_test_button = null;
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
		
		broadcast_test_button = (Button) findViewById(R.id.broadcast_button);
		broadcast_test_button.setOnClickListener(new BroadcastTestListener());
	
		sax_test_button = (Button) findViewById(R.id.sax_button);
		sax_test_button.setOnClickListener(new SAXTestListener());
		
		cp_test_button = (Button) findViewById(R.id.cp_button);
		cp_test_button.setOnClickListener(new CPTestListener());
		
		wifi_test_button = (Button) findViewById(R.id.wifi_button);
		wifi_test_button.setOnClickListener(new WifiTestListener());
		
		complexComp_test_button = (Button) findViewById(R.id.complexcomp_button);
		complexComp_test_button.setOnClickListener(new ComplexCompTestListener());
		
		exlistView_test_button = (Button) findViewById(R.id.exlistView_button);
		exlistView_test_button.setOnClickListener(new EXListViewTestListener());
		
		widget_test_button = (Button) findViewById(R.id.widget_button);
		widget_test_button.setOnClickListener(new WidgetTestListener());
		
		animation_test_button = (Button) findViewById(R.id.animation_button);
		animation_test_button.setOnClickListener(new AnimationTestListener());
	}
	
	class IntentTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
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
	
	class BroadcastTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, BroadcastTestActivity.class);
			startActivity(intent);
		}
		
	}
	
	class SAXTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, SAXTestActivity.class);
			startActivity(intent);
		}
		
	}
	
	class CPTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, CPTestActivity.class);
			startActivity(intent);
		}
		
	}
	
	class WifiTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, WifiTestActivity.class);
			startActivity(intent);
		}
		
	}
	
	class ComplexCompTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, ComplexCompActivity.class);
			startActivity(intent);
		}
		
	}
	
	class EXListViewTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, EXListViewActivity.class);
			startActivity(intent);
		}
		
	}
	
	class WidgetTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, WidgetTestActivity.class);
			startActivity(intent);
		}
		
	}
	class AnimationTestListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, AnimationTestActivity.class);
			startActivity(intent);
		}
		
	}
}
