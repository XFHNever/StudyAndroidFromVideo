package com.example.studyfromvideo.location;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.studyfromvideo.R;
import com.google.gson.Gson;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LocationTestActivity extends Activity {
    private Button location_start_button = null;
    private Button geo_button,reverseGeo_button;
    private TextView location_textView = null;
	private LocationManager locationManager = null;
	
	private static final String REVEERSE_URL = "http://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&sensor=true";
	private static final String URL = "http://maps.googleapis.com/maps/api/geocode/xml?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&sensor=true";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location_test);
		initView();
	}
	private void initView() {
		// TODO Auto-generated method stub
		location_textView = (TextView) findViewById(R.id.location_textview);
		
		location_start_button = (Button) findViewById(R.id.location_start_button);
		location_start_button.setOnClickListener(new LocationStartListener());
		
		geo_button = (Button) findViewById(R.id.geo__button);
		geo_button.setOnClickListener(new GeoListener());
		
		reverseGeo_button = (Button) findViewById(R.id.reverseGeo_button);
		reverseGeo_button.setOnClickListener(new ReverseGeoListener());
	}
	
	class LocationStartListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			
			List<String> providers = locationManager.getAllProviders();
			location_textView.append("this device has Providers:");
			for (Iterator iterator = providers.iterator();iterator.hasNext();) {
				String providerName = (String) iterator.next();
				location_textView.append("provider:" + providerName);
			}
			
			Criteria criteria = new Criteria();
			criteria.setAccuracy(Criteria.ACCURACY_FINE);
			criteria.setAltitudeRequired(false);
			criteria.setBearingRequired(false);
			criteria.setCostAllowed(false);
			criteria.setPowerRequirement(Criteria.POWER_LOW);
			
			String provider = locationManager.getBestProvider(criteria, false);
			location_textView.append("the best provider is" + provider);
			
		    locationManager.requestLocationUpdates(provider, 0, 0, locationListener);
		}
		
	}
	
	LocationListener locationListener = new LocationListener() {
		
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onLocationChanged(Location location) {
			location_textView.append("onLocationChanged");
			location_textView.append(location.getAltitude() + "," + location.getLongitude());
		}
	};

	
	class GeoListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		   new GeocodingTask().execute();	
		}
		
	}
	
	class ReverseGeoListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			new ReverseGeocodingTask().execute();
			
		
		
		}
		
	}
	
	private class GeocodingTask extends AsyncTask<Integer, Integer, Integer> {

		@Override
		protected Integer doInBackground(Integer... params) {
			// TODO Auto-generated method stub
//			Geocoder geocoder = new Geocoder(LocationTestActivity.this,Locale.US);
//			try {
//				List<Address> addresses = geocoder.getFromLocation(40.714224, -73.961452, 1);
//			    for(Iterator iterator = addresses.iterator();iterator.hasNext();) {
//			    	Address address = (Address) iterator.next();
//			//    	location_textView.append("address:" + address);
//			    	System.out.println("address:" + address);
//			    }
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			HttpClient httpClient = new DefaultHttpClient();
			String responseDataString = "";

		    try {
				HttpResponse response = httpClient.execute(new HttpGet(URL));
			    HttpEntity entity = response.getEntity();
			    
			    InputStream stream = entity.getContent();
			   
			    int line;
			    while((line = stream.read()) != -1) {
			    	responseDataString = responseDataString + ((char)line);
			    }
			    
			    System.out.println("geo:" + responseDataString);
		    } catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		  
			return null;
		}
		
	}
	
	private class ReverseGeocodingTask extends AsyncTask<Integer, Integer, Integer> {

		@Override
		protected Integer doInBackground(Integer... params) {
			// TODO Auto-generated method stub
//			Geocoder geocoder = new Geocoder(LocationTestActivity.this,Locale.US);
//			try {
//				List<Address> addresses = geocoder.getFromLocationName("SFO", 1);
//				System.out.println("size" + addresses.size());
//			//	location_textView.append("size" + addresses.size());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			HttpClient httpClient = new DefaultHttpClient();
			String responseDataString = "";

		    try {
				HttpResponse response = httpClient.execute(new HttpGet(REVEERSE_URL));
			    HttpEntity entity = response.getEntity();
			    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
			    String line = "";
			    while((line = bufferedReader.readLine()) != null) {
			    	responseDataString = responseDataString + line;
			    }
		    } catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    Gson gson = new Gson();
		    TestResult testResult = gson.fromJson(responseDataString, TestResult.class);
		    System.out.println("testResult:" + testResult);
			return null;
		}
		
	}
}
