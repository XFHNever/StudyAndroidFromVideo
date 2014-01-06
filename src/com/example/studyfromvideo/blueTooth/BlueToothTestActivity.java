package com.example.studyfromvideo.blueTooth;

import java.util.Iterator;
import java.util.Set;

import com.example.studyfromvideo.R;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class BlueToothTestActivity extends Activity{
	private Button bt_open_button = null;
	private Button bt_enable_button, bt_discover_button;
	private TextView bt_textView = null;
	private BluetoothAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.bluetooth_test);
    	initView();
    }
    
    private void initView() {
    	bt_textView = (TextView) findViewById(R.id.bluetooth_textView);
    	
    	bt_open_button = (Button) findViewById(R.id.BT_open_button);
    	bt_open_button.setOnClickListener(new BTOpenListener());
    	
    	bt_enable_button = (Button) findViewById(R.id.BT_enable_button);
    	bt_enable_button.setOnClickListener(new BTEnableListener());
    	
    	IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
    	registerReceiver(mReceiver, intentFilter);
    	
    	bt_discover_button = (Button) findViewById(R.id.BT_discover_button);
    	bt_discover_button.setOnClickListener(new BTDiscoverListener());
    }
    
    class BTOpenListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
		    adapter = BluetoothAdapter.getDefaultAdapter();
		    
		    if(adapter == null) {
		    	bt_textView.append("this Device does not support Bluetooth;");
		    } else {
		    	if(!adapter.isEnabled()) {
		    		Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		    		startActivity(enableBtIntent);
		    	}
		    	
		    	Set<BluetoothDevice> pairedDevices = adapter.getBondedDevices();
		    	
		    	if(pairedDevices.size() > 0) {
		    		for(Iterator iterator = pairedDevices.iterator();iterator.hasNext();) {
		    			BluetoothDevice bluetoothDevice = (BluetoothDevice) iterator.next();
		    		    bt_textView.append("address:" + bluetoothDevice.getAddress());
		    		}
		    	} else {
		    		bt_textView.append("no pairedDevices");
		    	}
		    }
		}
		
	}
    
    class BTEnableListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			  Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
			   discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
			   startActivity(discoverableIntent);
			   bt_textView.append("enable discoverability");
		}
		
	}
    
    class BTDiscoverListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			bt_textView.append("discover");
		    adapter.startDiscovery();
		     
		}
		
	}
    
    private final BroadcastReceiver mReceiver = new BroadcastReceiver(){

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String action = intent.getAction();
			
			if(BluetoothDevice.ACTION_FOUND.equals(action)) {
				BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				bt_textView.append(device.getName() + "----" + device.getAddress());
			} else {
				bt_textView.append("not find Devices");
			}
		}
    	
    };
}
