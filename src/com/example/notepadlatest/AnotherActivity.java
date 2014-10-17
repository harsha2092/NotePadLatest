package com.example.notepadlatest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class AnotherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notepad);
		
		Intent intent = getIntent();
		int index = intent.getIntExtra("index", 0);
		
		Log.d("Activity1", "In Anotheractivity: " + index );
		
		FragmentNotePad f2 = (FragmentNotePad) getFragmentManager().findFragmentById(R.id.fragment2);
		if(f2 != null){
			f2.changetext(index);
		}
	}
	
	

}
