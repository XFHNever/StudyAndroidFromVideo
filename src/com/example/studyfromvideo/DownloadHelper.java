package com.example.studyfromvideo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class DownloadHelper {
    private URL url = null;
    
    public String download(String urlStr){
    	StringBuffer sb = new StringBuffer();
    	String line = null;
    	BufferedReader reader = null;
    	try {

			URL url = new URL(urlStr);   
            // 打开连接   
HttpURLConnection con = (HttpURLConnection) url.openConnection();

				
		System.out.println("con=" + con);
		System.out.println(1);
		System.out.println("con.getInputStream" +con.getInputStream());
		System.out.println(2);
		con.connect();
		System.out.println(3);
    	    try {
    	    	System.out.println(4);
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    
    	    System.out.println("reader" + reader);
    	    
			while((line=reader.readLine())!=null){
				sb.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			try {
//				reader.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
    	
    	return sb.toString();
    }
    
    public int downloadFile(String urlStr,String path,String fileName) {
    	InputStream inputStream = null;
    	FileUtil fileUtil = new FileUtil();
    	
    	if(fileUtil.isFileExist(path + fileName)){
    		return 1;
    	} else {
    		try {
				inputStream = getInputStreamFromUrl(urlStr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		File resultFile = fileUtil.write2SDFromInput(path, fileName, inputStream);
    		if(resultFile == null) {
    			return -1;
    		}
    	}
    	
    	try {
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return 0;
    }
    
    public InputStream getInputStreamFromUrl(String urlStr) throws Exception{
    	InputStream inputStream = null;   	
		url = new URL(urlStr);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		inputStream = urlConnection.getInputStream();

    	return inputStream;
    }
}
