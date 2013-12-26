package com.example.studyfromvideo.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

import android.os.Environment;
import android.util.Log;

public class FileUtil {
    private String SDPATH;
    
    public String getSDPATH() {
    	return SDPATH;
    }
    
    public FileUtil() {
    	SDPATH = Environment.getExternalStorageDirectory() + "/";
    }
    
    public File createSDFile(String fileName) throws IOException {
    	File file = new File(SDPATH + fileName);
    	file.createNewFile();
    	return file;
    }
    
    public File createSDDir(String path) {
    	File dir = new File(SDPATH + path);
    	dir.mkdir();
    	return dir;
    }
    
    public boolean isFileExist(String fileName) {
    	File file = new File(SDPATH + fileName);
    	return file.exists();
    }
    /**
	 * 判断SD卡上的文件夹是否存在
	 */
	public boolean isFileExist(String fileName, String path) {
		File file = new File(SDPATH + path + File.separator + fileName);
		return file.exists();
	}
    
    public File write2SDFromInput(String path,String fileName,InputStream input) {
    	File file = null;
    	OutputStream outputStream = null;
    	createSDDir(path);
    	try {
			file = createSDFile(path+fileName);
			outputStream = new FileOutputStream(file);
			byte[] buffer = new byte[4*1024];
			
			System.out.println("input=" + input);
			
			while(input.read(buffer) != -1) {
				outputStream.write(buffer);
			}
			outputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    	
    	
    	return file;
    }
}
