package com.example.studyfromvideo.expandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.studyfromvideo.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

public class EXListViewActivity extends Activity{
	private ExpandableListView expandableListView = null;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.exlistview_test);
    	initView();
    }
     
     private void initView() {
    	 expandableListView = (ExpandableListView) findViewById(R.id.expandablelistview);
    	 
    	 List<Map<String, String>> groups = new ArrayList<Map<String,String>>();
    	 Map<String, String> group1 = new HashMap<String, String>();
    	 group1.put("group", "group1");
    	 Map<String, String> group2 = new HashMap<String, String>();
    	 group2.put("group", "group2");
    	 groups.add(group1);
    	 groups.add(group2);
    	 
    	 List<Map<String, String>> child1 = new ArrayList<Map<String,String>>();
    	 Map<String, String> child1Data1 = new HashMap<String, String>();
    	 child1Data1.put("child", "child1Data1");
    	 Map<String, String> child1Data2 = new HashMap<String, String>();
    	 child1Data2.put("child", "child1Data2");
    	 child1.add(child1Data1);
    	 child1.add(child1Data2);
    	 
    	 List<Map<String, String>> child2 = new ArrayList<Map<String,String>>();
    	 Map<String, String> child2Data1 = new HashMap<String, String>();
    	 child2Data1.put("child", "child2Data1");
    	 Map<String, String> child2Data2 = new HashMap<String, String>();
    	 child2Data2.put("child", "child2Data2");
    	 child2.add(child2Data1);
    	 child2.add(child2Data2);
    	 
    	 List<List<Map<String, String>>> childs = new ArrayList<List<Map<String,String>>>();
    	 childs.add(child1);
    	 childs.add(child2);
    	 
    	 SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(this, groups, R.layout.group,
    			 new String[]{"group"}, new int[]{R.id.groupTo}, childs, R.layout.child, new String[]{"child"}, new int[]{R.id.childTo});
    	 
    	 expandableListView.setAdapter(adapter);
     }
}
