package com.example.isshkul;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.isshkul.adapter.ExpandableListAdapter;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class TeacherTaskDetailsActivity extends Activity {

	ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_task_details);
		
		//to navigate back to studentHomeActivity
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
			    
		
				/////////////////////
				// get the listview
				expListView = (ExpandableListView) findViewById(R.id.expandible_task_info_list);

				// preparing list data
				prepareListData();

				listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

				// setting list adapter
				expListView.setAdapter(listAdapter);

				// Listview Group click listener
				expListView.setOnGroupClickListener(new OnGroupClickListener() {

					@Override
					public boolean onGroupClick(ExpandableListView parent, View v,
							int groupPosition, long id) {
						// Toast.makeText(getApplicationContext(),
						// "Group Clicked " + listDataHeader.get(groupPosition),
						// Toast.LENGTH_SHORT).show();
						return false;
					}
				});

				// Listview Group expanded listener
				expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

					@Override
					public void onGroupExpand(int groupPosition) {
						Toast.makeText(getApplicationContext(),
								listDataHeader.get(groupPosition) + " Expanded",
								Toast.LENGTH_SHORT).show();
					}
				});

				// Listview Group collasped listener
				expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

					@Override
					public void onGroupCollapse(int groupPosition) {
						Toast.makeText(getApplicationContext(),
								listDataHeader.get(groupPosition) + " Collapsed",
								Toast.LENGTH_SHORT).show();

					}
				});

				// Listview on child click listener
				expListView.setOnChildClickListener(new OnChildClickListener() {

					@Override
					public boolean onChildClick(ExpandableListView parent, View v,
							int groupPosition, int childPosition, long id) {
						// TODO Auto-generated method stub
						Toast.makeText(
								getApplicationContext(),
								listDataHeader.get(groupPosition)
										+ " : "
										+ listDataChild.get(
												listDataHeader.get(groupPosition)).get(
												childPosition), Toast.LENGTH_SHORT)
								.show();
						return false;
					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.teacher_task_details, menu);
		return true;
	}
	
	
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		
		listDataHeader.add("Description");
		listDataHeader.add("Topics");

		// Adding child data
		
		List<String> description = new ArrayList<String>();
		description.add("blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah ");

		List<String> topics = new ArrayList<String>();
		topics.add("slide 1");
		topics.add("slide 2");
		topics.add("slide 3");
		
		
		listDataChild.put(listDataHeader.get(0), description);
		listDataChild.put(listDataHeader.get(1), topics);
	}

}
