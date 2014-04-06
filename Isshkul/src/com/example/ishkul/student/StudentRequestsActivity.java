package com.example.ishkul.student;

import java.util.ArrayList;

import com.example.ishkul.student.StudentCourseFragment.ListAdapter;
import com.example.isshkul.R;
import com.example.isshkul.R.layout;
import com.example.isshkul.R.menu;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class StudentRequestsActivity extends Activity {
	
	ArrayList<RequestModel> requestItems;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_requests);
		
		requestItems = new ArrayList<RequestModel>();
		requestItems.add(new RequestModel("CSE 303", "Ayon Sen", "Accepted"));
		requestItems.add(new RequestModel("CSE 305", "Tanzima Hashem", "Pending"));
		
		ListView listview = (ListView)findViewById(R.id.student_requests_listview);
		ListAdapter adapter = new ListAdapter();
		listview.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_requests, menu);
		return true;
	}
	
	public class ListAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return requestItems.size() ;
		}

		@Override
		public Object getItem(int index) {
			return requestItems.get(index);
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position , View view , ViewGroup parent) {

			LayoutInflater inflater = (LayoutInflater)StudentRequestsActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.student_requests_list_row, parent , false);

			TextView course_name = (TextView) view.findViewById(R.id.student_request_course_textview);
			course_name.setText((CharSequence) ("Request for joining "+requestItems.get(position).course));
			
			TextView teacher_name = (TextView) view.findViewById(R.id.student_request_teacher_textview);
			teacher_name.setText((CharSequence) ("Teacher: "+requestItems.get(position).teacher));

			TextView status = (TextView) view.findViewById(R.id.student_request_status_textview);
			status.setText((CharSequence) (requestItems.get(position).status));
			
			if (requestItems.get(position).status.equals("Accepted"))
			{
				status.setTextColor(getResources().getColor(R.color.blueShark));
			}
			else status.setTextColor(getResources().getColor(R.color.red));


			return view;
		}

	}

}
