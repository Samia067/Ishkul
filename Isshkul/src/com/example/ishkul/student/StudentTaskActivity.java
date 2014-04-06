package com.example.ishkul.student;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.isshkul.R;

public class StudentTaskActivity extends FragmentActivity {

    //variables for the swipe tabs
	SectionsPagerAdapter mSectionsPagerAdapter;

	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_task);
		
		//to navigate back to studentHomeActivity
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
		
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_task, menu);
		return true;
	}

	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        // Handle action bar actions click
        switch (item.getItemId()) {
        case R.id.action_settings:
            return true;
        case R.id.action_search:
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
	
	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		// Show 3 total pages.
		final int PAGE_COUNT = 3;
		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
        	Fragment fragment = null;
        	switch(position)
        	{
        	case 0:
        		fragment =  new StudentTaskDiscussionFragment();
        		break;
        	case 1:
        		fragment = new StudentTaskSyllabusFragment();
        		break;
        	case 2:
        		fragment = new StudentTaskFilesFragment();
        		break;
        		
        	};
            
        	//way to send data to fragments
//        	Bundle args = new Bundle();
//			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
//			fragment.setArguments(args);
			
        	return fragment;
		}

		@Override
		public int getCount() {
			return PAGE_COUNT;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
            case 0:
                return "Discussion";
            case 1:
                return "Syllabus";
            case 2:
                return "Files";
        	}
        	return null;
		}
	}

}
