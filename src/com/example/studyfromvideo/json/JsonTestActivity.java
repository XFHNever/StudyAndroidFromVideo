package com.example.studyfromvideo.json;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import com.example.studyfromvideo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class JsonTestActivity extends Activity{
	private Button json_common_button,json_object_button ;
	private TextView json_textView = null;
	private JsonUtils jsonUtils = null;
	
	private static final String JSON = "[{\"name\":\"Michael\",\"age\":20},{\"name\":\"Mike\",\"age\":21}]";
			
	
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.json_test);
    	initView();
    }
	private void initView() {
		json_common_button = (Button) findViewById(R.id.json_common_button);
		json_common_button.setOnClickListener(new JsonCommonListener());
		
		json_object_button = (Button) findViewById(R.id.json_object_button);
		json_object_button.setOnClickListener(new JsonObjectListener());
		
		json_textView = (TextView) findViewById(R.id.json_textView);
		
		jsonUtils = new JsonUtils();
	}
     
	class JsonCommonListener implements OnClickListener{

		public void onClick(View arg0) {
			json_textView.append("parseJson");
		    List<User> users = new ArrayList<User>();
		    try {
				users = jsonUtils.parseJson(JSON);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("listener");
		    if(users.size() == 0) {
		    	json_textView.append("no user");
		    } else {
		    	for(User u: users) {
		    		json_textView.append(u.getName() + "----" + u.getAge());
		    	}
		    }
		} 
		
	}
	
	class JsonObjectListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			json_textView.append("parseJsonToObject");
			 List<User> users = new ArrayList<User>();
			    try {
					users = jsonUtils.parseuserFromJson(JSON);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println("listener");
			    if(users.size() == 0) {
			    	json_textView.append("no user");
			    } else {
			    	for(User u: users) {
			    		json_textView.append(u.getName() + "----" + u.getAge());
			    	}
			    }
		}
		
	}
}
