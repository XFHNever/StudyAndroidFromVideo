package com.example.studyfromvideo.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class JsonUtils {
     @SuppressWarnings("resource")
	public List parseJson(String jsonData) throws IOException {
    	 System.out.println("parseJson");
    	 List<User> users = new ArrayList<User>();
    	 JsonReader reader = new JsonReader(new StringReader(jsonData));
    	 reader.beginArray();
    	 while(reader.hasNext()) {
    		 users.add(readUser(reader));
    	 }
    	 reader.endArray();
    	 return users;
     }
     
     private User readUser(JsonReader reader) throws IOException {
    	 String name = null;
    	 int age = -1;
    	 
    	 System.out.println("StartreadUser");
    	 
    	 reader.beginObject();
    	 while(reader.hasNext()) {
    		 String result = reader.nextName();
    		 if (result.equals("name")) {
    			 name = reader.nextString();
    		 } else if (result.equals("age")) {
    			 age = reader.nextInt();
    		 } else {
    			 reader.skipValue();
    		 }
    	 } 
    	 
    	 reader.endObject();
    	 
    	 System.out.println("EndreadUser");
    	 
    	 return new User(name, age);
     }
     
     public List<User> parseuserFromJson(String jsonData) throws IOException, JSONException {
    	 System.out.println("parseuserFromJson");
    	 List<User> users = new ArrayList<User>();
    	 Gson gson = new Gson();
    	 List<User> retList = gson.fromJson(jsonData,  
                 new TypeToken<List<User>>() {  
                 }.getType());
    	 
    	 
    	 return retList;
     }
}
