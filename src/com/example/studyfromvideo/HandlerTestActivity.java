package com.example.studyfromvideo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class HandlerTestActivity extends Activity{
	private ProgressBar progressBar = null;
	private Button start_handler_button = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handler_test);
		initView();
	}

	private void initView() {
		progressBar = (ProgressBar) findViewById(R.id.handler_progressBar);
		start_handler_button = (Button) findViewById(R.id.start_handler_button);
		start_handler_button.setOnClickListener(new StartHandlerListener());
	}
	
	class StartHandlerListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			progressBar.setVisibility(View.VISIBLE);
		    handler.post(runnable);
		}
    	  
     }
	
	Handler handler = new Handler();
	int i = 0;
	Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			progressBar.setProgress(i);
			if(i<200){
				i += 10;
				handler.postDelayed(runnable, 1000);
			} else {
				handler.removeCallbacks(runnable);
			}
			
			
		}
	};
}
