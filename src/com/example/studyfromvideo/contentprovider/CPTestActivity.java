package com.example.studyfromvideo.contentprovider;


import com.example.studyfromvideo.R;
import com.example.studyfromvideo.contentprovider.FirstProviderMetaData.UserTableMetaData;


import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CPTestActivity extends Activity{
	private Button insert_button,query_button;
	private TextView cp_textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.cp_test);
    	initView();
    }
    
    public void initView(){
    	insert_button = (Button) findViewById(R.id.insert_button);
    	insert_button.setOnClickListener(new InsertListener());
    	
    	query_button = (Button) findViewById(R.id.query_button);
    	query_button.setOnClickListener(new QueryListener());
    	
    	cp_textView = (TextView) findViewById(R.id.cp_textView);
    }
    
    class InsertListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			cp_textView.append("insert。。。。。");
			ContentValues values = new ContentValues();
			values.put(FirstProviderMetaData.UserTableMetaData.USER_NAME, "zhangshan");
			Uri uri = getContentResolver().insert(FirstProviderMetaData.UserTableMetaData.CONTENT_URI, values);
			System.out.println("uri--->" + uri);
			cp_textView.append("uri--->" + uri);
		}
		
	}
    
    class QueryListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			cp_textView.append("query");
			Cursor cursor = getContentResolver().query(FirstProviderMetaData.UserTableMetaData.CONTENT_URI, null, null, null, null);
			while(cursor.moveToNext()) {
				System.out.println(cursor.getString(cursor.getColumnIndex(UserTableMetaData.USER_NAME)));
				cp_textView.append(cursor.getString(cursor.getColumnIndex(UserTableMetaData.USER_NAME)));
			}
		}
		
	}
}
