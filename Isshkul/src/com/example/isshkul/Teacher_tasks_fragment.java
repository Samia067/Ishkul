package com.example.isshkul;

import java.util.ArrayList;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Teacher_tasks_fragment extends Fragment {

	Context context ;

	ArrayList<TaskModel> taskItems;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		context = getActivity();

		taskItems = new ArrayList<TaskModel>() ;

		taskItems.add(new TaskModel("Assignment", "Fishbone diagram", "CSE 311", "Due in 2 days"));
		taskItems.add(new TaskModel("Test", "ER Diagram", "CSE 311", "Due in 2 days"));
		taskItems.add(new TaskModel("Assignment", "Stack overflow", "CSE 311", "Due in 2 days"));
		taskItems.add(new TaskModel("Assignment", "Feasibility Study", "CSE 311", "Due today"));

		View view = inflater.inflate(R.layout.fragment_teacher_task, container , false);

		ListView listview = (ListView) view.findViewById(R.id.teacher_task_listview);
		ListAdapter adapter = new ListAdapter();
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				//Toast.makeText(getActivity(), "Item " + position + " Clicked" , Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(context,TeacherTaskDetailsActivity.class);
				startActivity(intent);
			}
		});


		return view ;
	}

	public class ListAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return taskItems.size() ;
		}

		@Override
		public Object getItem(int index) {
			return taskItems.get(index);
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position , View view , ViewGroup parent) {

			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.teacher_task_list_row, parent , false);

			TextView type_name = (TextView) view.findViewById(R.id.teacher_task_type_name_textview);
			type_name.setText(taskItems.get(position).getTypeName());

			TextView cNo = (TextView) view.findViewById(R.id.teacher_task_course_textview);
			cNo.setText(taskItems.get(position).courseNumber);

			TextView due = (TextView) view.findViewById(R.id.teacher_task_due_textview);
			due.setText(taskItems.get(position).due);
			return view;
		}

	}
}
