package com.example.isshkul;

import java.util.ArrayList;

import com.example.isshkul.Teacher_tasks_fragment.ListAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Teacher_course_fragment extends Fragment {
	Context context ;

	ArrayList<String> courseItems;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		context = getActivity();

		courseItems = new ArrayList<String>() ;

		courseItems.add("CSE 104");
		courseItems.add("CSE 203");
		courseItems.add("CSE 308");
		
		View view = inflater.inflate(R.layout.fragment_teacher_course, container , false);

		ListView listview = (ListView) view.findViewById(R.id.teacher_course_listview);
		ListAdapter adapter = new ListAdapter();
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
				
				//Toast.makeText(getActivity(), "Item " + position + " Clicked" , Toast.LENGTH_SHORT).show();
				//start TeacherCourseDaetailActivity
				Intent intent = new Intent(context,TeacherCourseDetailActivity.class);
				startActivity(intent);
			}
		});


		return view ;
	}

	public class ListAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return courseItems.size() ;
		}

		@Override
		public Object getItem(int index) {
			return courseItems.get(index);
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position , View view , ViewGroup parent) {

			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.teacher_course_list_row, parent , false);

			TextView type_name = (TextView) view.findViewById(R.id.teacher_course_textview);
			type_name.setText(courseItems.get(position));

		
			return view;
		}

	}
}
