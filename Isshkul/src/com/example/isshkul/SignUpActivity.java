package com.example.isshkul;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUpActivity extends Activity {
	    
	final String TAG = "SignUpActivity";
	RadioButton teacherRadioButton, studentRadioButton;
	EditText studentId;
	//Button signup;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "after super");

		setContentView(R.layout.activity_sign_up);
		
		//to navigate back to studentHomeActivity
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
		
		teacherRadioButton = (RadioButton) findViewById(R.id.teacherRadioButton);
		studentRadioButton = (RadioButton) findViewById(R.id.studentRadioButton);
		studentId = (EditText) findViewById(R.id.studentID);
		
		teacherRadioButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				studentId.setVisibility(View.GONE);
			
			}
		});
		
		studentRadioButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				studentId.setVisibility(View.VISIBLE);
			
			}
		});
		
		
		
		
	}

}