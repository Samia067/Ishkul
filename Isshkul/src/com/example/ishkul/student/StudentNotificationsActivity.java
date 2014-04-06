package com.example.ishkul.student;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.isshkul.R;
import com.example.isshkul.model.TeacherNotificationModel;

public class StudentNotificationsActivity extends Activity {
	
	ArrayList<TeacherNotificationModel> notificationItems;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_notifications);
		
		notificationItems = new ArrayList<TeacherNotificationModel>();
		notificationItems.add(new TeacherNotificationModel("Sajjadur Rahman added a new task in CSE 308","today"));
		notificationItems.add(new TeacherNotificationModel("Ayon Sen accepted your request to join CSE 300","yesterday"));
		notificationItems.add(new TeacherNotificationModel(
				"Tanzima Hashem deleted a task in CSE 305","yesterday"));
		
		ListView listview = (ListView)findViewById(R.id.student_notification_listview);
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

			return notificationItems.size() ;
		}

		@Override
		public Object getItem(int index) {
			return notificationItems.get(index);
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position , View view , ViewGroup parent) {

			LayoutInflater inflater = (LayoutInflater)StudentNotificationsActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.student_notifications_list_row, parent , false);

			TextView content = (TextView) view.findViewById(R.id.teacher_notification_content);
			content.setText((CharSequence) (notificationItems.get(position).content));
			
			TextView date = (TextView) view.findViewById(R.id.teacher_notification_date);
			date.setText((CharSequence) (notificationItems.get(position).date));

			return view;
		}

	}

}
