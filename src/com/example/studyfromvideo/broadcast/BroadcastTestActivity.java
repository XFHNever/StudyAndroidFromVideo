package com.example.studyfromvideo.broadcast;

import com.example.studyfromvideo.R;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BroadcastTestActivity extends Activity{
	private Button send_message_button,register_button,unregister_buttonButton;
	private TextView receiver_textView;
	private MyReceiver2 myReceiver2 = null;
	
	private static final String SMS = "android.provider.Telephony.SMS_RECEIVED";
      @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.broadcast);
    	initView();
    }
      
    private void initView(){
    	send_message_button = (Button) findViewById(R.id.send_message_button);
    	send_message_button.setOnClickListener(new SendMessageListener());
    	
    	register_button = (Button) findViewById(R.id.register_button);
    	register_button.setOnClickListener(new RegisterListener());
    	
    	unregister_buttonButton = (Button) findViewById(R.id.unregister_button);
    	unregister_buttonButton.setOnClickListener(new UnregisterListener());
    	
    	receiver_textView = (TextView) findViewById(R.id.receiver_textView);
    }
    
    class SendMessageListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_MEDIA_BUTTON);
			BroadcastTestActivity.this.sendBroadcast(intent);
			receiver_textView.append("send message...to receiver");
		}
    	
    }
    
    class RegisterListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			myReceiver2 = new MyReceiver2();
			IntentFilter filter = new IntentFilter();
			filter.addAction(SMS);
			BroadcastTestActivity.this.registerReceiver(myReceiver2, filter);
			receiver_textView.append("register receiver");
		}
    	
    }
    
    class UnregisterListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			BroadcastTestActivity.this.unregisterReceiver(myReceiver2);
			receiver_textView.append("unregister receiver");
		}
    	
    }
}
