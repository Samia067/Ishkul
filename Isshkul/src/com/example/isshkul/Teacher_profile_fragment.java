package com.example.isshkul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.isshkul.adapter.ExpandableListAdapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class Teacher_profile_fragment extends Fragment {

	
	ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_teacher_profile, container , false);
		
		// get the listview
        expListView = (ExpandableListView)view.findViewById(R.id.university_list);
        
        // preparing list data
        prepareListData();
 
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);//new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
		
		return view ;
	}

	private void prepareListData() {
		// TODO Auto-generated method stub
		
	        listDataHeader = new ArrayList<String>();
	        listDataChild = new HashMap<String, List<String>>();
	 
	        // Adding child data
	        listDataHeader.add("BUET");
	        listDataHeader.add("AUST");
	        
	 
	        // Adding child data
	        List<String> buet = new ArrayList<String>();
	        buet.add("CSE 105");
	        buet.add("CSE 203");
	        buet.add("CSE 308");
	        
	 
	        List<String> aust = new ArrayList<String>();
	        aust.add("CSE 201");
	 
	 
	        listDataChild.put(listDataHeader.get(0),buet); // Header, Child data
	        listDataChild.put(listDataHeader.get(1),aust);
	        
	    
	}
}
