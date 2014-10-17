package com.example.notepadlatest;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity implements FragmentDetails.Communicator {

	FragmentDetails f1;
	FragmentNotePad f2;
	FragmentManager manager;
	DataBaseHelperAdapter dbhelperadapter;
	SQLiteDatabase sqldatabase;
	SharedPreferences prefs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		manager = getFragmentManager();
		
		f1 = (FragmentDetails) manager.findFragmentById(R.id.fragment1);
		f1.setComm(this);
		
		
		dbhelperadapter = new DataBaseHelperAdapter(this); 
		//TestEntry();
		//Testviewalldetails();
		//getDataSpecificToTitle();
		//getUIDSpecificToTextandTitle();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void respond(int index) {
		// TODO Auto-generated method stub
		
		//prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		//int id = 1;
		   
		   
	      
		
		
		
		f2  = (FragmentNotePad) manager.findFragmentById(R.id.fragment2);
		
		if(f2 != null && f2.isVisible())
		{
			f2.changetext(index);
		}
		else
		{
			Intent intent =  new Intent(this,AnotherActivity.class);
			intent.putExtra("index", index);
			startActivity(intent);
		}
		
		
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	
	
	public void TestEntry(){

		String Title = "Test6";
		String Text =  "Text6";
		
		long id = dbhelperadapter.insertData(Title, Text);
		
		if(id < 0){
			Log.d("Error", "error");
		}
		else
		{
			Log.d("Okay", "Okay");
		}
	}
	
	public void Testviewalldetails(){
		String result = dbhelperadapter.getAllDetails();
		Log.d("Db", result);
	}
	
	public void getDataSpecificToTitle(){
		String result = dbhelperadapter.getData("Test1");
		Log.d("SpecificDb", result);
	}
	
	public void getUIDSpecificToTextandTitle(){
		String result = dbhelperadapter.getUid("Text4","Test4");
		Log.d("Uid", result);
	}
}
