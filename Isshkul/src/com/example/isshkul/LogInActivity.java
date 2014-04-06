package com.example.isshkul;

import com.example.ishkul.student.StudentHomeActivity;
import com.example.ishkul.student.TestActivity;

import android.R.layout;
import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends Activity {

	EditText user, pass ;
	Button login , signup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);
		user = (EditText)findViewById(R.id.username);
		pass = (EditText)findViewById(R.id.password);
		login = (Button)findViewById(R.id.loginButton);
		signup = (Button)findViewById(R.id.signUpButton);
		
		
		signup.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v){
				ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo ni = cm.getActiveNetworkInfo();
				  
				if (ni == null) {
				// There are no active networks.
					 
					//doesnt go to signup activity, shows Toast
					Context context = getApplicationContext();
			    	CharSequence text = "Cannot sign up without internet . Please try again later.";
			    	int duration = Toast.LENGTH_LONG;

			    	Toast toast = Toast.makeText(context, text, duration);
			    	toast.show();
			    	
				} 
				else{//net available , so goes to signup activity
					Intent intent = new Intent(LogInActivity.this,SignUpActivity.class);
					startActivity(intent);
				}
				
			}
			
		});
		
		
		login.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v){
				String user_email = user.getText().toString().trim();
				String user_password = pass.getText().toString().trim();
				Intent intent = null;
				if (user_email.isEmpty() || user_password.isEmpty())
				{
					Toast.makeText(getApplicationContext(), "Please fill up email and password", Toast.LENGTH_SHORT);
				}
				else if(user_email.equals("a@yahoo.com") && user_password.equals("1234")){
	    			intent = new Intent(LogInActivity.this, TeacherHomeActivity.class);
	    			
	    			startActivity(intent);
		    		finish();
	    		}
	    		else if(user_email.equals("a@gmail.com") && user_password.equals("1234")){
	    			
	    			intent = new Intent(LogInActivity.this, StudentHomeActivity.class);
			    	//intent = new Intent(LogInActivity.this, TestActivity.class);
	    			startActivity(intent);
		    		finish();
	    		}
	    		else
				{
					Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_SHORT);
				}
	    		
				
//					String user_email = user.getText().toString();
//					String user_password = pass.getText().toString();
//					String pass_in_db = "";
//					String account_type = "";
//					Intent intent = null;
//					
//					DataBaseHelper helper = new DataBaseHelper(LogInActivity.this);
//				    helper.openDataBase();
//				    
//				    Cursor c = helper.getPassword(user_email);
//				    
//				    if(c.getCount() == 1){
//				    	c.moveToFirst();
//				    	pass_in_db = (String)c.getString(c.getColumnIndexOrThrow("password"));
//				    	
//				    	if(pass_in_db.trim().equals(user_password.trim())){
//				    		//get account type
//				    		Cursor a = helper.getAccountType(user_email);
//				    		a.moveToFirst();
//				    		account_type = (String)a.getString(a.getColumnIndexOrThrow("type"));
//				    		a.close();
//				    		
//				    		if(account_type.equals("Teacher")){
//				    			intent = new Intent(LogInActivity.this, TeacherHomeActivity.class);
//					    		
//				    		}
//				    		else if(account_type.equals("Student")){
//				    			
//				    			intent = new Intent(LogInActivity.this, StudentHomeActivity.class);
//						    	//intent = new Intent(LogInActivity.this, TestActivity.class);
//				    		}
//				    		startActivity(intent);
//				    		finish();
//
//				    		
//				    	}
//				    	else{
//					    	
//					    	user.setText("");
//					    	pass.setText("");
//					    	Context context = getApplicationContext();
//					    	CharSequence text = "Invalid user email or password";
//					    	int duration = Toast.LENGTH_SHORT;
//
//					    	Toast toast = Toast.makeText(context, text, duration);
//					    	toast.show();
//			        
//					    }
//				    	
//				    }
//				    else{
//				    	
//				    	Context context = getApplicationContext();
//				    	CharSequence text = "Please sign up";
//				    	int duration = Toast.LENGTH_SHORT;
//
//				    	Toast toast = Toast.makeText(context, text, duration);
//				    	toast.show();
//				    }
//				    c.close();
//				    helper.close();
//				    
			}

		});
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.log_in, menu);
		return true;
	}
	
	public void Home(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, TeacherHomeActivity.class);
    	startActivity(intent);
    }
	

}
