package com.example.ishkul.student;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isshkul.CourseModel;
import com.example.isshkul.R;

public class StudentEnrollActivity extends Activity {
	// Get a reference to the AutoCompleteTextView in the layout
	AutoCompleteTextView instituteTextView, courseTextView;
	ArrayList<CourseModel> courseItems;
	ArrayList<String> courseSuggestions;
	ArrayList<String> instituteSuggestions;
	
	Button advancedSearchButton;
	LinearLayout searchPane;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_enroll);
		
		instituteTextView = (AutoCompleteTextView) findViewById(R.id.institutionTextView);
		courseTextView = (AutoCompleteTextView) findViewById(R.id.courseTextView);
		
		// create an arraylist of institution suggestions
		instituteSuggestions = new ArrayList<String>();
		instituteSuggestions.add("BUET");
		instituteSuggestions.add("NSU");
		instituteSuggestions.add("CUET");
		instituteSuggestions.add("BMC");
		instituteSuggestions.add("Bangladesh University of Engineering and Technology");
		instituteSuggestions.add("Bangladesh Medical College");
		
		// create an arraylist of institution suggestions
		courseSuggestions = new ArrayList<String>();
		courseSuggestions.add("CSE 203");
		courseSuggestions.add("CSE 311");
		courseSuggestions.add("CSE 412");
		courseSuggestions.add("Database Sessional");
		courseSuggestions.add("Digital Electronic Pulse Technology");
		courseSuggestions.add("Chemistry Matters");
		
		//Create the adapter and set it to the institute AutoCompleteTextView 
		ArrayAdapter<String> instituteAdapter = 
		        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, instituteSuggestions);
		instituteTextView.setAdapter(instituteAdapter);
		
		//Create the adapter and set it to the course AutoCompleteTextView 
		ArrayAdapter<String> courseAdapter = 
		        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courseSuggestions);
		courseTextView.setAdapter(courseAdapter);
		
		//set up the list of courses for the results
		courseItems = new ArrayList<CourseModel>();
		courseItems.add(new CourseModel("Digital Electronic Pulse Technology", "CSE 234", "Shubhra Kanti", 2014, 03, 13, 6));
		courseItems.add(new CourseModel("International Business Protocols", "IN 234", "Sharmin Akhter", 2014, 04, 20, 8));
		courseItems.add(new CourseModel("ISD", "CSE 211", "Shubhra Kanti Shubhra Kanti Shubhra Kanti Shubhra Kanti", 2014, 02, 13, 6));
		courseItems.add(new CourseModel("Data Communications", "CSE 234", "Shubhra Kanti", 2015, 03, 13, 6));
		
		ListView resultsListview = (ListView) findViewById(R.id.result_list_view);
		ListAdapter adapter = new ListAdapter();
		resultsListview.setAdapter(adapter);
		resultsListview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Toast.makeText(StudentEnrollActivity.this, "Item " + position + " Clicked" , Toast.LENGTH_SHORT).show();
			}
		});
		
		advancedSearchButton = (Button) findViewById(R.id.advancedSearchButton);
		searchPane = (LinearLayout) findViewById(R.id.advancedSearchOptionsPane);
		searchPane.setVisibility(View.GONE);
		advancedSearchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (searchPane.isShown())
					searchPane.setVisibility(View.GONE);
				else searchPane.setVisibility(View.VISIBLE);
			}
		});

	}
	public class ListAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			
			return courseItems.size() ;
		}

		@Override
		public Object getItem(int arg0) {			
			return courseItems.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position , View view , ViewGroup parent) {
			
			LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.student_enroll_courses_listview, parent , false);
			
			CourseModel cm =courseItems.get(position);
			
			TextView courseName = (TextView) view.findViewById(R.id.student_enroll_courseName_textview);
			courseName.setText(cm.courseName);
			
			TextView courseNo = (TextView) view.findViewById(R.id.student_enroll_courseno_textview);
			courseNo.setText(cm.courseNumber);
			
			TextView length = (TextView) view.findViewById(R.id.student_enroll_lengthInWeeksTextView);
			length.setText(cm.length + " Weeks");
			
			TextView teacher = (TextView) view.findViewById(R.id.student_enroll_teacherTextView);
			teacher.setText("Course Teacher: " + cm.teacherName);
			
			TextView date = (TextView) view.findViewById(R.id.student_enroll_date_textview);
			date.setText(cm.getStartDate());
			
			TextView status = (TextView) view.findViewById(R.id.student_enroll_status_textview);
			status.setText(cm.status);
			if (cm.status == "Ended")
				status.setTextColor(getResources().getColor(R.color.blueShark));
			else if (cm.status == "Active")
				status.setTextColor(getResources().getColor(R.color.red));
			else 
				status.setTextColor(getResources().getColor(R.color.blueShark));
			return view;
		}
		
	} 

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_enroll, menu);
		return true;
	}
	
}