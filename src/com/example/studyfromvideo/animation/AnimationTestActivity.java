package com.example.studyfromvideo.animation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.studyfromvideo.MainActivity;
import com.example.studyfromvideo.R;
import com.example.studyfromvideo.download.DownloadTestActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class AnimationTestActivity extends Activity{
	private Button alpha_button,translate_button,rotate_button,scale_button,frame_change_button,anim_list_button;
	private ImageView anim_imageView = null;
	private ImageView frame_change_imageView = null;
	private ListView anim_listView = null;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.animation_test);
    	initView();
    }
     
	 private void initView() {
		 anim_imageView = (ImageView) findViewById(R.id.anim_imageView);
		 
		 frame_change_imageView = (ImageView) findViewById(R.id.frame_change_imageView);
		 
		 alpha_button = (Button) findViewById(R.id.alpha_button);
		 alpha_button.setOnClickListener(new AlphaListener());
		 
		 translate_button = (Button) findViewById(R.id.translate_button);
		 translate_button .setOnClickListener(new TranslateListener());
		 
		 rotate_button = (Button) findViewById(R.id.rotate_button);
		 rotate_button.setOnClickListener(new RotateListener());
		 
		 scale_button = (Button) findViewById(R.id.scale_button);
		 scale_button.setOnClickListener(new ScaleListener());
		 
		 frame_change_button = (Button) findViewById(R.id.frame_change_button);
		 frame_change_button.setOnClickListener(new FrameChangeListener());
		 
		 anim_list_button = (Button) findViewById(R.id.anim_list_button);
		 anim_list_button.setOnClickListener(new AnimListListener());
		 
		 anim_listView = (ListView) findViewById(R.id.anim_listView);
	 }
	 
	 class AlphaListener implements OnClickListener{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AnimationSet animationSet = new AnimationSet(true);
				AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
				alphaAnimation.setDuration(500);
				animationSet.addAnimation(alphaAnimation);
				anim_imageView.startAnimation(animationSet);
			}
			
	}
	 
	 class RotateListener implements OnClickListener{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Animation animation = AnimationUtils.loadAnimation(AnimationTestActivity.this, R.anim.rotate);
				anim_imageView.startAnimation(animation);
			}
			
	}
	 
	 class TranslateListener implements OnClickListener{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Animation animation = AnimationUtils.loadAnimation(AnimationTestActivity.this, R.anim.translate);
				anim_imageView.startAnimation(animation);
			}
			
	}
	 class ScaleListener implements OnClickListener{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AnimationSet set = new AnimationSet(true);
				ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 0.1f, 0.0f, 0.1f,0.5f,0.5f);
				AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
				set.addAnimation(alphaAnimation);
				set.addAnimation(scaleAnimation);
				set.setDuration(1000);
				set.setFillAfter(true);
				set.setFillBefore(false);
				anim_imageView.startAnimation(set);
			}
			
	}
	 
	 class FrameChangeListener implements OnClickListener{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				frame_change_imageView.setBackgroundResource(R.drawable.anim_nv);
				AnimationDrawable drawable = (AnimationDrawable) frame_change_imageView.getBackground();
				drawable.start();
			}
			
	}
	 
	 class AnimListListener implements OnClickListener{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				anim_listView.setAdapter(buildListAdapter());
			}
			
	}
	 
	 private ListAdapter buildListAdapter() {
		 List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		 HashMap<String, String> m1 = new HashMap<String, String>();
		 m1.put("user_name", "张三");
		 m1.put("user_gender", "女");
		 
		 HashMap<String, String> m2 = new HashMap<String, String>();
		 m2.put("user_name", "李四");
		 m2.put("user_gender", "女");
		 
		 HashMap<String, String> m3 = new HashMap<String, String>();
		 m3.put("user_name", "王五");
		 m3.put("user_gender", "男");
		 
		 list.add(m1);
		 list.add(m2);
		 list.add(m3);
		 
		 SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,
				 R.layout.item,new String[]{"user_name","user_gender"},
				 new int[]{R.id.anim_item_name,R.id.anim_item_gender});
		 
		 return simpleAdapter;
	 }
	 
}
