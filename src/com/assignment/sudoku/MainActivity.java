package com.assignment.sudoku;

import com.assignment.sudoku.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnLevel1;
	private Button btnLevel2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnLevel1 = (Button) findViewById(R.id.btnLevel1);
		btnLevel1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), Level1Activity.class);
				startActivityForResult(myIntent, 1);
			}
		});

		btnLevel2 = (Button) findViewById(R.id.btnLevel2);
		btnLevel2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), Level2Activity.class);
				startActivityForResult(myIntent, 2);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
