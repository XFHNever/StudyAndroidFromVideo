package com.example.studyfromvideo.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	private static final int VERSION = 1;
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public DatabaseHelper(Context context, String databaseName) {
		// TODO Auto-generated constructor stub
		super(context, databaseName, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		System.out.println("create a Database");
		db.execSQL("create table " + FirstProviderMetaData.USERS_TABLE_NAME 
				+ "(" + FirstProviderMetaData.UserTableMetaData._ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ FirstProviderMetaData.UserTableMetaData.USER_NAME
				+ " varchar(20));");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		System.out.println("update a Database");
	}

}
