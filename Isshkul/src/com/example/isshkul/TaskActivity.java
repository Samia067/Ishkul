package com.example.isshkul;

import java.util.ArrayList;
import java.util.List;

import com.example.isshkul.adapter.CustomArrayAdapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TaskActivity extends FragmentActivity {
	
	
	ArrayList<String> tasknames = new ArrayList<String>();
	ArrayList<String> deadlines = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task);
		
		
		
//////////////read from db
		
		//db code to get institution list
		DataBaseHelper helper9 = new DataBaseHelper(TaskActivity.this);
		helper9.openDataBase();
		Cursor cur = (Cursor)helper9.getStudentTasks();
		List<Model> entries = new ArrayList<Model>();
				
		//Store institutions into array

		if(cur.getCount() > 0){
			cur.moveToFirst();

			while(!cur.isAfterLast()){
				// extract data from cursor
				
				tasknames.add(cur.getString(cur.getColumnIndex("name")));
				deadlines.add(cur.getString(cur.getColumnIndex("deadline")));
				

				cur.moveToNext();

			}
		}
		cur.close();

		helper9.close();
      
      
      /////////////////////////////
		
		//List
		// to give support on lower android version, we are not calling getFragmentManager() 
        FragmentManager fm = getSupportFragmentManager();
 
        // Create the list fragment and add it as our sole content.
        if (fm.findFragmentById(android.R.id.content) == null) {
            DataListFragment list = new DataListFragment();
            fm.beginTransaction().add(android.R.id.content, list).commit();
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.task, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_task:
	        	Intent i = new Intent(this, AddTaskActivity.class); 
				startActivity(i);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	    
	}

	//List added
	
	public static class DataListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<List<Model>> {
	    
	    CustomArrayAdapter mAdapter;
	    View previous;
	
	    @Override 
	    public void onActivityCreated(Bundle savedInstanceState) {
	        super.onActivityCreated(savedInstanceState);
	         
	        System.out.println("DataListFragment.onActivityCreated");
	
	        // Initially there is no data 
	        setEmptyText("No Data Here");
	
	        // Create an empty adapter we will use to display the loaded data.
	        mAdapter = new CustomArrayAdapter(getActivity());
	 
	        setListAdapter(mAdapter);
	
	        // Start out with a progress indicator.
	        setListShown(false);
	
	        // Prepare the loader.  Either re-connect with an existing one,
	        // or start a new one.
	        getLoaderManager().initLoader(0, null, this);
	    }
	
	    @Override
	    public void onListItemClick(ListView l, View v, int position, long id) {
	        // List Item Selection
	    	/**super.onListItemClick(l, v, position, id); 
	    	l.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	        //Logic to highlight selected item
	         previous.setSelected(false);
	         v.setSelected(true);
	         previous=v;**/
	    	// getItemList(selectedStore);
	        Log.i("DataListFragment", "Item clicked: " + id);
	        
	    }
	
	    @Override
	    public Loader<List<Model>> onCreateLoader(int arg0, Bundle arg1) {
	        System.out.println("DataListFragment.onCreateLoader");
	        return new DataListLoader(getActivity());
	    }
	
	    @Override
	    public void onLoadFinished(Loader<List<Model>> arg0, List<Model> data) {
	        mAdapter.setData(data);
	        System.out.println("DataListFragment.onLoadFinished");
	        // The list should now be shown.
	        if (isResumed()) {
	            setListShown(true);
	        } else {
	            setListShownNoAnimation(true);
	        }
	    }
	
	    @Override
	    public void onLoaderReset(Loader<List<Model>> arg0) {
	        mAdapter.setData(null);
	    }
	
	} 
	public static class DataListLoader extends AsyncTaskLoader<List<Model>> {
	     
	    List<Model> mModels;
	
	    public DataListLoader(Context context) {
	        super(context);
	    }
	
	    @Override
	    public List<Model> loadInBackground() {
	        System.out.println("DataListLoader.loadInBackground");
	         
	         // You should perform the heavy task of getting data from 
	         // Internet or database or other source 
	         // Here, we are generating some Sample data
	        
	        
	        
	        
	        // Create corresponding array of entries and load with data.
	        List<Model> entries = new ArrayList<Model>(5);
	        entries.add(new Model("Test 1", "10-3-2014"));
	        entries.add(new Model("Online 2", "8-4-2014"));
	        entries.add(new Model("Python Assignment", "18-4-2014"));
	        entries.add(new Model("JavaScript", "18-4-2014"));
	
	        return entries;
	    }
	     
	    /**
	     * Called when there is new data to deliver to the client.  The
	     * super class will take care of delivering it; the implementation
	     * here just adds a little more logic.
	     */
	    @Override public void deliverResult(List<Model> listOfData) {
	        if (isReset()) {
	            // An async query came in while the loader is stopped.  We
	            // don't need the result.
	            if (listOfData != null) {
	                onReleaseResources(listOfData);
	            }
	        }
	        List<Model> oldApps = listOfData;
	        mModels = listOfData;
	
	        if (isStarted()) {
	            // If the Loader is currently started, we can immediately
	            // deliver its results.
	            super.deliverResult(listOfData);
	        }
	
	        // At this point we can release the resources associated with
	        // 'oldApps' if needed; now that the new result is delivered we
	        // know that it is no longer in use.
	        if (oldApps != null) {
	            onReleaseResources(oldApps);
	        }
	    }
	
	    /**
	     * Handles a request to start the Loader.
	     */
	    @Override protected void onStartLoading() {
	        if (mModels != null) {
	            // If we currently have a result available, deliver it
	            // immediately.
	            deliverResult(mModels);
	        }
	
	
	        if (takeContentChanged() || mModels == null) {
	            // If the data has changed since the last time it was loaded
	            // or is not currently available, start a load.
	            forceLoad();
	        }
	    }
	
	    /**
	     * Handles a request to stop the Loader.
	     */
	    @Override protected void onStopLoading() {
	        // Attempt to cancel the current load task if possible.
	        cancelLoad();
	    }
	
	    /**
	     * Handles a request to cancel a load.
	     */
	    @Override public void onCanceled(List<Model> apps) {
	        super.onCanceled(apps);
	
	        // At this point we can release the resources associated with 'apps'
	        // if needed.
	        onReleaseResources(apps);
	    }
	
	    /**
	     * Handles a request to completely reset the Loader.
	     */
	    @Override protected void onReset() {
	        super.onReset();
	
	        // Ensure the loader is stopped
	        onStopLoading();
	
	        // At this point we can release the resources associated with 'apps'
	        // if needed.
	        if (mModels != null) {
	            onReleaseResources(mModels);
	            mModels = null;
	        }
	    }
	
	    /**
	     * Helper function to take care of releasing resources associated
	     * with an actively loaded data set.
	     */
	    protected void onReleaseResources(List<Model> apps) {}
	     
	}
}
