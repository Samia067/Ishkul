package com.example.isshkul;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TeacherSettingsActivity extends Activity {

	Spinner reminderSpinner;
	ArrayList <String> reminderOptions;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_settings);
		
		reminderSpinner = (Spinner) findViewById(R.id.reminderSpinner);
		reminderOptions = new ArrayList<String>();
		for (int i = 1; i<=7; i++)
		{
			if (i == 1)
				reminderOptions.add(i + " day");
			else reminderOptions.add(i + " days");
		}
		
		ArrayAdapter<String> spinnerArrayAdapter = 
				new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, reminderOptions);
		spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		reminderSpinner.setAdapter(spinnerArrayAdapter);
		
		reminderSpinner.setSelection(6);

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.teacher_settings, menu);
		return true;
	}

}
