package com.example.isshkul;

import java.util.ArrayList;

import android.os.Bundle;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class TeacherCourseStudentsFragment extends Fragment {

	Context context ;

	ArrayList<String> studentItems;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		context = getActivity();

		studentItems = new ArrayList<String>() ;

		studentItems.add("Farzia Afroze");
		studentItems.add("Samia Shafique");
		studentItems.add("Farzana Ahmed");
		
		View view = inflater.inflate(R.layout.fragment_teacher_course_students, container , false);

		ListView listview = (ListView) view.findViewById(R.id.teacher_course_students_listview);
		ListAdapter adapter = new ListAdapter();
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
				
				Toast.makeText(getActivity(), "Item " + position + " Clicked" , Toast.LENGTH_SHORT).show();
				//start TeacherCourseDaetailActivity
			}
		});


		return view ;
	}
	public class ListAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return studentItems.size() ;
		}

		@Override
		public Object getItem(int index) {
			return studentItems.get(index);
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position , View view , ViewGroup parent) {

			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.teacher_course_students_list_row, parent , false);

			TextView student_name = (TextView) view.findViewById(R.id.teacher_course_students_textview);
			student_name.setText(studentItems.get(position));
			
		
			return view;
		}

	}
	

}
