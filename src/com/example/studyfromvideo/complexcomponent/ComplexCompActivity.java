package com.example.studyfromvideo.complexcomponent;

import java.util.Calendar;

import com.example.studyfromvideo.R;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class ComplexCompActivity extends FragmentActivity {
	private Spinner spinner = null;
	private TextView comp_textView = null;
	private Button datepicker_buttonButton = null;
	private AutoCompleteTextView autoCompleteTextView = null;
	private SeekBar seekBar = null;
	private RatingBar ratingBar = null;
	
	private static final String[] COUNTRIES = new String[] {
        "Belgium", "France", "Italy", "Germany", "Spain"
    };
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.complexcomp_test);
    	initView();
    }
    
    private void initView() {
    	comp_textView = (TextView) findViewById(R.id.comp_textview);
    	
    	spinner = (Spinner) findViewById(R.id.planets_spinner);
    	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner.setAdapter(adapter);
    	spinner.setOnItemSelectedListener(new SpinnerItemClickListener());
    	
    	datepicker_buttonButton = (Button) findViewById(R.id.datepick_button);
    	datepicker_buttonButton.setOnClickListener(new DatePickerListener());
    	
    	autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);
    	ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,COUNTRIES);
    	autoCompleteTextView.setAdapter(adapter2);
    	autoCompleteTextView.setOnItemSelectedListener(new ACItemClickListener());
    	
    	seekBar = (SeekBar) findViewById(R.id.comp_seekbar);
    	seekBar.setOnSeekBarChangeListener(new SeekbarListener());
    	
    	ratingBar = (RatingBar) findViewById(R.id.comp_ratingbar);
    	ratingBar.setOnRatingBarChangeListener(new RatingBarListener());
    }
    



	class SpinnerItemClickListener implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			comp_textView.append("onItemSelected:" + arg0.getItemIdAtPosition(arg2) + "\n");
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			comp_textView.append("onNothingSelected" + "\n");
		}
    	
    }
	
	
    
	
	class DatePickerListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			DialogFragment fragment = new DatePickerFragment();
			fragment.show(getSupportFragmentManager(), "datePicker");
		}
		
	}
	
    class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

		@Override
		public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			comp_textView.append("onDateSet:" + arg1 +"-" + arg2 + "-" + arg3 + "\n");
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			final Calendar c = Calendar.getInstance();
	        int year = c.get(Calendar.YEAR);
	        int month = c.get(Calendar.MONTH);
	        int day = c.get(Calendar.DAY_OF_MONTH);

	        // Create a new instance of DatePickerDialog and return it
	        return new DatePickerDialog(getActivity(), this, year, month, day);
		}
		
		
    	
    }
    
    class ACItemClickListener implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			comp_textView.append("onItemSelected:" + arg0.getItemIdAtPosition(arg2) + "\n");
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			comp_textView.append("onNothingSelected" + "\n");
		}
    	
    }
    
    class SeekbarListener implements OnSeekBarChangeListener {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub
			comp_textView.append("onProgressChanged:" + progress + "\n");
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			comp_textView.append("onStartTrackingTouch:"  + "\n");
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			comp_textView.append("onStopTrackingTouch:" + "\n");
		}
    	
    }
    
    class RatingBarListener implements OnRatingBarChangeListener {

		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) {
			// TODO Auto-generated method stub
			comp_textView.append("onRatingChanged:" + rating + "\n");
		}
    	
    }
}
