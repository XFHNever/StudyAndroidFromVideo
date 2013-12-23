package com.example.studyfromvideo.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.example.studyfromvideo.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SAXTestActivity extends Activity{
	private Button sax_read_button,sax_write_button,dom_read_button,dom_write_button,pull_read_button,pull_write_button;
    private TextView sax_textView = null;
    
    private BookParser saxParser;
    private BookParser domParser;
    private BookParser pullParser;
    private List<Book> books;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.sax_test);
    	initView();
    }
     
     public void initView(){
    	 sax_read_button = (Button) findViewById(R.id.sax_read_button);
    	 sax_read_button.setOnClickListener(new SAXReadListener());
    	 
    	 sax_write_button = (Button) findViewById(R.id.sax_write_button);
    	 sax_write_button.setOnClickListener(new SAXWriteListener());
    	 
    	 dom_read_button = (Button) findViewById(R.id.dom_read_button);
    	 dom_read_button.setOnClickListener(new DomReadListener());
    	 
    	 dom_write_button = (Button) findViewById(R.id.dom_write_button);
    	 dom_write_button.setOnClickListener(new DomWriteListener());
    	 
    	 pull_read_button = (Button) findViewById(R.id.pull_read_button);
    	 pull_read_button.setOnClickListener(new PullReadListener());
    	 
    	 pull_write_button = (Button) findViewById(R.id.pull_write_button);
    	 pull_write_button.setOnClickListener(new PullWriteListener());
    	 
    	 
    	 sax_textView = (TextView) findViewById(R.id.sax_textView);
     }
     
     public class SAXReadListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			sax_textView.append("使用SAX解析XML结果为:");
			try {
				InputStream is= getAssets().open("books.xml");
			    saxParser = new SAXBookParser();
			    books = saxParser.parse(is);
			    for(Book book : books){
			    	sax_textView.append(book.toString());
			    	System.out.println(book.toString());
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    	 
     }
     public class SAXWriteListener implements OnClickListener{

 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			
 			
			try {
				sax_textView.append("使用SAX序列化XML的结果是：");
				String xml = saxParser.serialize(books);
				FileOutputStream fos = openFileOutput("books.xml", Context.MODE_PRIVATE);
				fos.write(xml.getBytes("UTF-8"));
				System.out.println(xml);
				sax_textView.append(xml);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			
 		}
     	 
      }
     
     public class DomReadListener implements OnClickListener{

 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			sax_textView.append("使用Dom解析XML结果为:");
			try {
				InputStream is= getAssets().open("books.xml");
			    domParser = new DomBookParser();
			    books = domParser.parse(is);
			    System.out.println("books" + books.size());
			    for(Book book : books){
			    	sax_textView.append(book.toString());
			    	System.out.println(book.toString());
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
     	 
      }
      public class DomWriteListener implements OnClickListener{

  		@Override
  		public void onClick(View v) {
  			// TODO Auto-generated method stub
  			try {
				sax_textView.append("使用Dom序列化XML的结果是：");
				String xml = domParser.serialize(books);
				FileOutputStream fos = openFileOutput("books.xml", Context.MODE_PRIVATE);
				fos.write(xml.getBytes("UTF-8"));
				System.out.println(xml);
				sax_textView.append(xml);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		}
      	 
       }
      
      public class PullReadListener implements OnClickListener{

  		@Override
  		public void onClick(View v) {
  			// TODO Auto-generated method stub
  			sax_textView.append("使用Pull解析XML结果为:");
			try {
				InputStream is= getAssets().open("books.xml");
			    pullParser = new PullBookParser();
			    books = pullParser.parse(is);
			    System.out.println("books" + books.size());
			    for(Book book : books){
			    	sax_textView.append(book.toString());
			    	System.out.println(book.toString());
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		}
      	 
       }
       public class PullWriteListener implements OnClickListener{

   		@Override
   		public void onClick(View v) {
   			// TODO Auto-generated method stub
   			try {
				sax_textView.append("使用Pull序列化XML的结果是：");
				String xml = pullParser.serialize(books);
				FileOutputStream fos = openFileOutput("books.xml", Context.MODE_PRIVATE);
				fos.write(xml.getBytes("UTF-8"));
				System.out.println(xml);
				sax_textView.append(xml);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   		}
       	 
        }
}
