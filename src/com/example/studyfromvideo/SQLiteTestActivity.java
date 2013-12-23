package com.example.studyfromvideo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SQLiteTestActivity extends Activity{
	private DBManager mgr;  
    private ListView listView;  
    private Button add_buttonButton = null;
      
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.sqlite_test);  
        listView = (ListView) findViewById(R.id.listView);  
        //初始化DBManager  
        mgr = new DBManager(this);  
        
        add_buttonButton = (Button) findViewById(R.id.add_button);
        add_buttonButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("1");
				add();
				System.out.println(2);
			}
		});
    }  
      
    @Override  
    protected void onDestroy() {  
        super.onDestroy();  
        //应用的最后一个Activity关闭时应释放DB  
        mgr.closeDB();  
    }  
      
    public void add() {  
        ArrayList<Person> persons = new ArrayList<Person>();  
          
        Person person1 = new Person("Ella", 22, "lively girl");  
        Person person2 = new Person("Jenny", 22, "beautiful girl");  
        Person person3 = new Person("Jessica", 23, "sexy girl");  
        Person person4 = new Person("Kelly", 23, "hot baby");  
        Person person5 = new Person("Jane", 25, "a pretty woman");  
          
        persons.add(person1);  
        persons.add(person2);  
        persons.add(person3);  
        persons.add(person4);  
        persons.add(person5);  
          
        mgr.add(persons);  
        System.out.println("add");
    }  
      
    public void update(View view) {  
        Person person = new Person();  
        person.name = "Jane";  
        person.age = 30;  
        mgr.updateAge(person);  
        System.out.println("update");
    }  
      
    public void delete(View view) {  
        Person person = new Person();  
        person.age = 30;  
        mgr.deleteOldPerson(person);  
        System.out.println("delete");
    }  
      
    public void query(View view) {  
        List<Person> persons = mgr.query();  
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();  
        for (Person person : persons) {  
            HashMap<String, String> map = new HashMap<String, String>();  
            map.put("name", person.name);  
            map.put("info", person.age + " years old, " + person.info);  
            list.add(map);  
        }  
        SimpleAdapter adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,  
                    new String[]{"name", "info"}, new int[]{android.R.id.text1, android.R.id.text2});  
        listView.setAdapter(adapter);  
        
        System.out.println("query");
    }  
      
    public void queryTheCursor(View view) {  
        Cursor c = mgr.queryTheCursor();  
        startManagingCursor(c); //托付给activity根据自己的生命周期去管理Cursor的生命周期  
        CursorWrapper cursorWrapper = new CursorWrapper(c) {  
            @Override  
            public String getString(int columnIndex) {  
                //将简介前加上年龄  
                if (getColumnName(columnIndex).equals("info")) {  
                    int age = getInt(getColumnIndex("age"));  
                    return age + " years old, " + super.getString(columnIndex);  
                }  
                return super.getString(columnIndex);  
            }  
        };  
        //确保查询结果中有"_id"列  
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,   
                cursorWrapper, new String[]{"name", "info"}, new int[]{android.R.id.text1, android.R.id.text2});  
        ListView listView = (ListView) findViewById(R.id.listView);  
        listView.setAdapter(adapter);  
        System.out.println("queryCursor");
    }  
    
   
}
