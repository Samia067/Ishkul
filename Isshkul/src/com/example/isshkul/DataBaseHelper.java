package com.example.isshkul;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.example.isshkul.R;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {

	private static final String pkg = "com.example.isshkul";//"com.example.isshkul";
	private static String DB_PATH = "/data/data/" + pkg + "/databases/";

	private static String DB_NAME = "iskul_local_db.sqlite";
	int[] dbfiles = { R.raw.iskul_local_db };

	private SQLiteDatabase myDataBase;
	private final Context myContext;
	
	public DataBaseHelper(Context context) {
		super(context, DB_NAME, null, 1);
		this.myContext = context;
	}

	public void createDataBase() {

		boolean dbExist = checkDataBase();

		if (dbExist) {
			// do nothing - database already exist
		} else {
			this.getReadableDatabase();
			try {
				CopyDataBase();
			} catch (IOException e) {
				Toast.makeText(myContext, e.getMessage(), Toast.LENGTH_SHORT)
						.show();
				Log.d("Create DB", e.getMessage());
			}
		}

	}

	private boolean checkDataBase() {
		SQLiteDatabase checkDB = null;
		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		} catch (SQLiteException e) {
			Toast.makeText(myContext, e.getMessage(), Toast.LENGTH_SHORT)
					.show();
			Log.d("Check DB", e.getMessage());
		}

		if (checkDB != null) {
			checkDB.close();
		}
		return checkDB != null ? true : false;
	}

	private void CopyDataBase() throws IOException {
		InputStream databaseInput = null;
		Resources resources = myContext.getResources();
		String outFileName = DB_PATH + DB_NAME;

		OutputStream databaseOutput = new FileOutputStream(outFileName);

		byte[] buffer = new byte[512];
		int length;

		for (int i = 0; i < dbfiles.length ; i++) {
			databaseInput = resources.openRawResource(dbfiles[i]);
			while ((length = databaseInput.read(buffer)) > 0) {
				databaseOutput.write(buffer, 0, length);
				databaseOutput.flush();
			}
			databaseInput.close();
		}

		databaseOutput.flush();
		databaseOutput.close();
	}

	public void openDataBase() throws SQLException {
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.NO_LOCALIZED_COLLATORS);
	}

	@Override
	public synchronized void close() {
		if (myDataBase != null)
			myDataBase.close();
		super.close();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
	
	public Cursor getPassword(String email) {
		String SQL = "SELECT password from Self where email = \""+email+"\";" ;
		Cursor cursor = myDataBase.rawQuery(SQL, null) ;
		
		
		return cursor ;
	}
	
	public Cursor getAccountType(String email) {
		String SQL = "SELECT type from User where email = \""+email+"\";" ;
		Cursor cursor = myDataBase.rawQuery(SQL, null) ;
		return cursor ;
	}
	
	public Cursor getStudentTasks(){
		
		String SQL = "select * from Task  JOIN Course where Task.courseID = Course.id ;" ;
		Cursor cursor = myDataBase.rawQuery(SQL, null) ;
		return cursor;
	}
	
	public Cursor getCourse()
	{
		String SQL = "select id , courseNumber from Course where isRunning = \"TRUE\";" ;
		Cursor cursor = myDataBase.rawQuery(SQL, null) ;
		return cursor;
	}
	
	
	
	public boolean insertTask(int id ,String taskName , String type , String deadline , int courseID )
	{
		String SQL = "insert into Task values" +
				"("+ id +", \""+taskName+"\",\""+type+"\",\""+deadline+"\",\""+courseID+");";

		try {
			myDataBase.execSQL(SQL);
			return true ;
		} catch (Exception e) {
			return false ;
		}


	}

	
	public Cursor getInstitution() {
		// TODO Auto-generated method stub
		String SQL = "select name from Institution;" ;
		Cursor cursor = myDataBase.rawQuery(SQL, null) ;
		return cursor;
		
		//return null;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
