package com.example.isshkul;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddTaskActivity extends Activity {

	Spinner institutionSpinner, courseSpinner, typeSpinner;
	EditText taskName, description;
	DatePicker date;
	Button createTask;
	ArrayList<String> ins = new ArrayList<String>();
	ArrayList<String> courses = new ArrayList<String>();
	String[] types = {"Test" ,"Quiz","Assignment","Other"}; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_task);
		
		//to navigate back to studentHomeActivity
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
		institutionSpinner = (Spinner) findViewById(R.id.instituteSpinner);
		courseSpinner = (Spinner) findViewById(R.id.courseSpinner);
		typeSpinner = (Spinner) findViewById(R.id.taskSpinner);
		
		taskName = (EditText) findViewById(R.id.taskName);
		description = (EditText) findViewById(R.id.descriptionLabel);
		
		date = (DatePicker) findViewById(R.id.datePicker1);
		createTask = (Button) findViewById(R.id.addTaskButton);
		
		
		///////////////////////db integration of institution
		
		
//		//db code to get institution list
//		DataBaseHelper helper1 = new DataBaseHelper(AddTaskActivity.this);
//		helper1.openDataBase();
//		Cursor c = (Cursor)helper1.getInstitution();
//				
//		//Store institutions into array
//
//		if(c.getCount() > 0){
//			c.moveToFirst();
//
//			while(!c.isAfterLast()){
//				// extract data from cursor
//				
//				ins.add(c.getString(c.getColumnIndex("name")));
//
//				c.moveToNext();
//
//			}
//		}
//		c.close();

		ins.add("BUET");
		ins.add("AUST");
		ins.add("MIST");
		
		ArrayAdapter<String> spinnerArrayAdapter = 
				new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, ins);
		spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		institutionSpinner.setAdapter(spinnerArrayAdapter);

//		helper1.close();
//		
		/////////////////////////////////
		
		//////////////////integration course
//		DataBaseHelper helper2 = new DataBaseHelper(AddTaskActivity.this);
//		helper2.openDataBase();
//		Cursor c1 = (Cursor)helper2.getCourse();
//				
//		//Store institutions into array
//
//		if(c1.getCount() > 0){
//			c1.moveToFirst();
//
//			while(!c1.isAfterLast()){
//				// extract data from cursor
//				
//				courses.add(c1.getString(c1.getColumnIndex("courseNumber")));
//
//				c1.moveToNext();
//
//			}
//		}
//		c1.close();

		courses.add("CSE 308");
		courses.add("CSE 201");
		courses.add("CSE 105");
		ArrayAdapter<String> spinnerArrayAdapter2 = 
				new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, courses);
		spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		courseSpinner.setAdapter(spinnerArrayAdapter2);

		//helper2.close();
		////////////////////////////////////
		
		//////typesinner
		
		ArrayAdapter<String> typespinnerArrayAdapter = 
				new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, types);
		typespinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		typeSpinner.setAdapter(typespinnerArrayAdapter);
		
		/////////////////
		
		createTask.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//implement add task method
				Context context = getApplicationContext();
		    	CharSequence text = "Task has been added";
		    	int duration = Toast.LENGTH_SHORT;

		    	Toast toast = Toast.makeText(context, text, duration);
		    	toast.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_task, menu);
		return true;
	}

}
