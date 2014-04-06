package com.example.ishkul.student;

import com.example.isshkul.R;
import com.example.isshkul.adapter.FileAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class StudentTaskFilesFragment extends Fragment{
	public StudentTaskFilesFragment() {
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_student_task_files, container , false);
		
		GridView gridView = (GridView) view.findViewById(R.id.grid_view);
		 
        // Instance of ImageAdapter Class
        gridView.setAdapter(new FileAdapter(getActivity()));
		return view ;
		
		
	}
}
