package com.example.studyfromvideo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver1 extends BroadcastReceiver {

	public MyReceiver1(){
		System.out.println("Myreceiver1 is created");
	}
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("OnReceive is called");
	}

}
