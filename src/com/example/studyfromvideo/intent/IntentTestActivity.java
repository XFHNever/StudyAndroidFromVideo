package com.example.studyfromvideo.intent;

import com.example.studyfromvideo.R;
import com.example.studyfromvideo.R.id;
import com.example.studyfromvideo.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class IntentTestActivity extends Activity{
	private TextView intent_textView = null;
	private Button send_mail_button = null;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.intent_test);
    	initView();
    }
      
      public void initView(){
    	  intent_textView = (TextView) findViewById(R.id.intent_textView);
    	  
    	  String passString = "";
    	  Intent intent = getIntent();
    	  passString += intent.getStringExtra("test");
    	  Bundle bundle = intent.getExtras();
    	  passString += bundle.getInt("BigFour");
    	  intent_textView.setText(passString);
    	  
    	  send_mail_button = (Button) findViewById(R.id.send_mail_button);
    	  send_mail_button.setOnClickListener(new SendMailListener());
      }
      
      class SendMailListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Uri uri = Uri.parse("mailto:443696948@qq.com");
			Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
			startActivity(intent);
		}
    	  
      }
}
