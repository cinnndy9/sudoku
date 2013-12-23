package com.assignment.sudoku;

import com.assignment.sudoku.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Level1Activity extends GameActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level1);
		message = (TextView) findViewById(R.id.tvMessage);
		btHome = (Button) findViewById(R.id.btMenu);
		btHome.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				setResult(RESULT_OK, intent);
				finish();
			}
		});

		btSubmit = (Button) findViewById(R.id.btSubmit);
		btSubmit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					getCells();

					if (checkAnswer(cells)) {
						message.setText("Congratulations! You win!");
					} else {
						message.setText("Sorry, your answer is wrong!");
					}
				} catch (Exception e) {
					message.setText("Please fill in all the fields!");
				}
			}
		});
	}

}
