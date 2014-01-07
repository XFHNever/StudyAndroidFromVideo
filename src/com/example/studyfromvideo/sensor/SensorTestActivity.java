package com.example.studyfromvideo.sensor;

import java.util.List;

import com.example.studyfromvideo.R;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SensorTestActivity extends Activity{
	private Button sensor_all_button = null;
	private Button sensor_acc_button,sensor_pro_button;
	private TextView sensor_textView = null;
	private SensorManager sensorManager = null;
	
	private float gravity[] = new float[3];
	private float linear_acceleration[] = new float[3];
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.sensor_test);
    	initView();
    }

	private void initView() {
		// TODO Auto-generated method stub
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		
		sensor_textView = (TextView) findViewById(R.id.sensor_textView);
		
		sensor_all_button = (Button) findViewById(R.id.sensor_all_button);
		sensor_all_button.setOnClickListener(new SensorAllListener());
		
		sensor_acc_button = (Button) findViewById(R.id.sensor_acc_button);
		sensor_acc_button.setOnClickListener(new SensorAccListener());
		
		sensor_pro_button = (Button) findViewById(R.id.sensor_pro_button);
		sensor_pro_button.setOnClickListener(new SensorProListener());
	}
	
	class SensorAllListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			sensor_textView.append("Device has Sensors: ");
		    List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
		    for(Sensor s:sensors) {
		    	sensor_textView.append(s.getName() + "---" + s.getVendor() + "---" + s.getResolution() + "----" + s.getPower());
		    }
		}
		
	}
	
	class SensorAccListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			sensor_textView.append("ACCELEROMETER Sensors: ");
		    Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		    sensorManager.registerListener(new SensorEventListener() {
				
				@Override
				public void onSensorChanged(SensorEvent event) {
					// TODO Auto-generated method stub
					
					sensor_textView.append("x---" + event.values[0]);
					sensor_textView.append("y---" + event.values[1]);
					sensor_textView.append("z---" + event.values[2]);
					
					final float alpha = 0.8f;
					
					gravity[0] = alpha*gravity[0] + (1-alpha) * event.values[0];
					gravity[1] = alpha*gravity[1] + (1-alpha) * event.values[1];
					gravity[2] = alpha*gravity[2] + (1-alpha) * event.values[2];
					
					linear_acceleration[0] = event.values[0] - gravity[0];
					linear_acceleration[1] = event.values[1] - gravity[1];
					linear_acceleration[2] = event.values[2] - gravity[2];
				
					sensor_textView.append("linear_acceleration:" );
					sensor_textView.append("linear_acceleration[0]" + linear_acceleration[0]);
					sensor_textView.append("linear_acceleration[1]" + linear_acceleration[1]);
					sensor_textView.append("linear_acceleration[2]" + linear_acceleration[2]);
				}
				
				@Override
				public void onAccuracyChanged(Sensor sensor, int accuracy) {
					// TODO Auto-generated method stub
					
				}
			}, sensor, SensorManager.SENSOR_DELAY_NORMAL);
		}
		
	}
	
	class SensorProListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			sensor_textView.append("PROXIMITY Sensors: ");
		    Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		    sensorManager.registerListener(new SensorEventListener() {
				
				@Override
				public void onSensorChanged(SensorEvent event) {
					// TODO Auto-generated method stub
					sensor_textView.append("event.values[0]" + event.values[0]);
				}
				
				@Override
				public void onAccuracyChanged(Sensor sensor, int accuracy) {
					// TODO Auto-generated method stub
					
				}
			}, sensor, SensorManager.SENSOR_DELAY_NORMAL);
		}
		
	}
}
