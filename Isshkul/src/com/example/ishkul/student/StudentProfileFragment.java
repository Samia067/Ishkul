package com.example.ishkul.student;

import com.example.isshkul.R;
import com.example.isshkul.R.layout;
import com.example.isshkul.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class StudentProfileFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_student_profile, container , false);
		return view ;
	}
}
