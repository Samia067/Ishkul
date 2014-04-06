package com.example.ishkul.student;

import java.util.ArrayList;

import com.example.ishkul.student.StudentTaskDiscussionFragment.ListAdapter;
import com.example.isshkul.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class StudentTaskSyllabusFragment extends Fragment{

	Context context ;
	ArrayList<String> topicItems;

	public StudentTaskSyllabusFragment() {
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		context = getActivity();
		topicItems = new ArrayList<String>() ;
		
		topicItems.add("Chapter 5 - Primary Usecase");
		topicItems.add("Chapter 6 - Secondary Usecase");
		topicItems.add("Chapter 7.4 - Tertiary Usecase");

		View view = inflater.inflate(R.layout.fragment_student_task_syllabus, container , false);
		
		ListView listview = (ListView) view.findViewById(R.id.student_task_syllabus_listview);
		ListAdapter adapter = new ListAdapter();
		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				Toast.makeText(getActivity(), "Item " + position + " Clicked" , Toast.LENGTH_SHORT).show();
				
				CheckBox checkBox = (CheckBox) view.findViewById(R.id.student_task_syllabus_topic_checkBox);
				if (checkBox.isChecked() == false)
				{
					checkBox.setChecked(true);
					checkBox.setTextColor(getResources().getColor(R.color.cream));
				}
				else 
				{
					checkBox.setChecked(false);
					checkBox.setTextColor(getResources().getColor(R.color.lightSkyBlue));
				}
			}
		});

		
		return view ;
	}
	
	public class ListAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			
			return topicItems.size() ;
		}

		@Override
		public Object getItem(int arg0) {			
			return topicItems.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		
		
		@Override
		public View getView(int position , View view , ViewGroup parent) {
			
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.student_task_syllabus_list_row, parent , false);
			 
			CheckBox checkBox = (CheckBox) view.findViewById(R.id.student_task_syllabus_topic_checkBox);
			checkBox.setText(topicItems.get(position));
			return view;
		}
	}
}
