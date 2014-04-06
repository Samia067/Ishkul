package com.example.ishkul.student;

import java.util.ArrayList;
import java.util.List;

import com.example.isshkul.DropCourseModel;
import com.example.isshkul.InteractiveArrayAdapter;
import com.example.isshkul.R;
import com.example.isshkul.R.color;
import com.example.isshkul.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StudentDropCourseActivity extends ListActivity {

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		// create an array of Strings, that will be put to our ListActivity
		ArrayAdapter<DropCourseModel> adapter = new InteractiveArrayAdapter(this,getModel());
		setListAdapter(adapter);
		setContentView(R.layout.activity_student_drop_course);

		final ListView listView = getListView();
		listView.setBackgroundColor(getResources().getColor(R.color.GreenishBlack));
	}

	private List<DropCourseModel> getModel() {
		List<DropCourseModel> list = new ArrayList<DropCourseModel>();
		list.add(get("CSE 300"));
		list.add(get("CSE 304"));
		list.add(get("CSE 305"));
		list.add(get("CSE 307"));
		list.add(get("CSE 308"));
		list.add(get("CSE 309"));
		list.add(get("CSE 310"));
		list.add(get("CSE 311"));
		
		// Initially select one of the items
		//list.get(1).setSelected(true);
		return list;
	}

	private DropCourseModel get(String s) {
		return new DropCourseModel(s);
	}

} 