package com.example.isshkul;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TeacherDropCourseActivity extends ListActivity {

	public void onCreate(Bundle icicle) {
	    super.onCreate(icicle);
	    // create an array of Strings, that will be put to our ListActivity
	    ArrayAdapter<DropCourseModel> adapter = new InteractiveArrayAdapter(this,getModel());
	    setListAdapter(adapter);
	    setContentView(R.layout.activity_teacher_drop_course);
	    
	    final ListView listView = getListView();
	    listView.setBackgroundColor(getResources().getColor(R.color.GreenishBlack));
	  }

	  private List<DropCourseModel> getModel() {
	    List<DropCourseModel> list = new ArrayList<DropCourseModel>();
	    list.add(get("CSE 104"));
	    list.add(get("CSE 203"));
	    list.add(get("CSE 308"));
	    // Initially select one of the items
	    list.get(1).setSelected(true);
	    return list;
	  }

	  private DropCourseModel get(String s) {
	    return new DropCourseModel(s);
	  }

	} 