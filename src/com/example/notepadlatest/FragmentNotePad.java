package com.example.notepadlatest;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentNotePad extends Fragment {
	TextView Notepadtitle;
	//NotePadEditText Notepadtext;
	Button notepadsave;
	DataBaseHelperAdapter dbhelperadapter;
	SQLiteDatabase sqldatabase;
	int listviewnumber;
	SharedPreferences prefs;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragmentnotes, container,false);
		Notepadtitle = (TextView) v.findViewById(R.id.notepadtitle);
		//Notepadtext = (NotePadEditText) v.findViewById(R.id.note_edit_text);
		notepadsave = (Button) v.findViewById(R.id.notepadsave);
		
		//@@@@@@@@@@@@@@@@@@
		
		
		
		
		//@@@@@@@@@@@@@@@@@
		
		
		return v;
	}
	
	
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		//dbhelperadapter = new DataBaseHelperAdapter(getActivity()); 
		notepadsave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//insertData();
				
				
			}

			
		});
	}
/*public void insertData(){
	String Title = Notepadtitle.getText().toString();
	String Text =  Notepadtext.getText().toString();
	
	long id = dbhelperadapter.insertData(Title, Text);
	
String U_id =  dbhelperadapter.getUid(Title,Text);
	
	prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
	
	Editor editor = prefs.edit();
	editor.putString(Integer.toString(listviewnumber), U_id);
    
    editor.commit();
    
    
    
    
	if(id < 0){
		Log.d("Error", "error");
	}
	else
	{
		Log.d("Okay", "Okay");
	}
}*/

/*public void getUIDSpecificToTextandTitle(){
	String result = dbhelperadapter.getUid("Text4","Test4");
	Log.d("Uid", result);
}*/

	public void changetext(int index){
		listviewnumber = index;
		Log.d("Title", "Before SetText");
		String[] title = getResources().getStringArray(R.array.notesname);
		Log.d("Title", title[index]);
		Notepadtitle.setText(title[index]);
		
		
		
		//@@@@@@@@@@@@@@@@@@
		
		
		
		
		//@@@@@@@@@@@@@@@@@
				
	}
}
