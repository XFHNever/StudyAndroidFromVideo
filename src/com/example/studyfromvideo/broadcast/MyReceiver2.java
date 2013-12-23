package com.example.studyfromvideo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class MyReceiver2 extends BroadcastReceiver {

	public MyReceiver2(){
		System.out.println("Myreceiver2 is created");
	}
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("MyReceiver2 onReceive is called");
		Bundle bundle = intent.getExtras();
		Object[] myOBJpdus = (Object[]) bundle.get("pdus");
		SmsMessage[] messages = new SmsMessage[myOBJpdus.length];
		for(int i=0;i<myOBJpdus.length;i++){
			messages[i] = SmsMessage.createFromPdu((byte[]) myOBJpdus[i]);
			System.out.println(messages[i].getDisplayMessageBody());
		}
		
	}

}
