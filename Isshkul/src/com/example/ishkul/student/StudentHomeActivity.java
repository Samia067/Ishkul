package com.example.ishkul.student;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.isshkul.LogInActivity;
import com.example.isshkul.R;
import com.example.isshkul.adapter.NavDrawerListAdapter;
import com.example.isshkul.model.NavDrawerItem;


public class StudentHomeActivity extends FragmentActivity {
	//drawer
	private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
 
    // nav drawer title
    private CharSequence mDrawerTitle;
 
    // used to store app title
    private CharSequence mTitle;
 
    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
 
    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
 
        mTitle = mDrawerTitle = getTitle();
 
        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.std_nav_drawer_items);
 
        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.std_nav_drawer_icons);
 
        mDrawerLayout = (DrawerLayout) findViewById(R.id.std_drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.std_list_slidermenu);
 
        navDrawerItems = new ArrayList<NavDrawerItem>();
 
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        // Find People
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        // Photos
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        // Communities, Will add a counter here
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "22"));
        // Pages
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        
 
        // Recycle the typed array
        navMenuIcons.recycle();
 
        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
        
        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);
 
        // enabling action bar app icon and behaving it as toggle button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
 
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ){
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }
 
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
         
        //////////////////pagerStripTab
        ViewPager viewPager = (ViewPager) findViewById(R.id.student_pager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter());
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.student_home, menu);
        
        
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        
        // Configure the search info and add any event listeners
        // When using the support library, the setOnActionExpandListener() method is
        // static and accepts the MenuItem object as an argument
        MenuItemCompat.setOnActionExpandListener(searchItem, new OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when collapsed
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                return true;  // Return true to expand action view
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
        case R.id.action_settings:
            return true;
        case R.id.action_notification :
        	Intent intent = new Intent(StudentHomeActivity.this, StudentNotificationsActivity.class);
        	startActivity(intent);
        	break;
        default:
            return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
 
    /***
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
 
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }
 
    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
 
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }
 
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//    ..
//    mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
//    }
 
    /**
     * Slide menu item click listener
     * */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
            // display view for selected nav drawer item
        	Toast.makeText(getApplicationContext(), position+" clicked", Toast.LENGTH_SHORT);
            displayView(position);
            
        }
    }
 
     /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
		// update the main content by replacing fragments
		Intent intent = null ;
		switch (position) {
		case 0:
			intent = new Intent(this, StudentEnrollActivity.class);
			startActivity(intent);
			break;
		case 1:
			intent = new Intent(this, StudentRequestsActivity.class);
			startActivity(intent);
			break;
		case 2:
			intent = new Intent(this, StudentDropCourseActivity.class);
			startActivity(intent);
			break;
			
		case 3:
			intent = new Intent(this, StudentSettingsActivity.class);
			startActivity(intent);
			break;
		case 4 :
			intent = new Intent(this, LogInActivity.class); 
			startActivity(intent);
			finish();
			break;

		default:
			break;
		}
	}
    
    
	public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 3;
        public SampleFragmentPagerAdapter() {
            super(getSupportFragmentManager());

        }
        
        public CharSequence getPageTitle(int position) {
        	switch (position) {
            case 0:
                return "Profile";
            case 1:
                return "Tasks";
            case 2:
                return "Courses";
        	}
        	return null;
        }
        
        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
        @Override
        public Fragment getItem(int position) {
        	Fragment fragment = null;
        	switch(position)
        	{
        	case 0:
        		fragment =  new StudentProfileFragment();
        		break;
        	case 1:
        		fragment = new StudentTaskFragment();
        		break;
        	case 2:
        		fragment = new StudentCourseFragment();
        		break;
        		
        	};
            return fragment;
        }
    }

}