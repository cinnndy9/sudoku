package com.assignment.sudoku;

import com.assignment.sudoku.R;

import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends Activity {

	protected Button btHome;
	protected Button btSubmit;
	protected int[][] cells = new int[4][4];
	protected TextView message;

	protected boolean checkAnswer(int[][] cells) {
		int[] counters = { 0, 0, 0, 0 }; // to count the number of 1,2,3,4
		int i, j;

		for (i = 0; i < 4; i++) { // row
			counters[0] = 0;
			counters[1] = 0;
			counters[2] = 0;
			counters[3] = 0;

			for (j = 0; j < 4; j++) {
				count(counters, cells[i][j]);
			}
			if (!(counters[0] == 1 && counters[1] == 1 && counters[2] == 1 && counters[3] == 1)) {
				return false;
			}
		}

		for (i = 0; i < 4; i++) { // column
			counters[0] = 0;
			counters[1] = 0;
			counters[2] = 0;
			counters[3] = 0;

			for (j = 0; j < 4; j++) {
				count(counters, cells[j][i]);
			}
			if (!(counters[0] == 1 && counters[1] == 1 && counters[2] == 1 && counters[3] == 1)) {
				return false;
			}
		}

		int r, c;

		for (i = 0; i < 4; i++) { // grid
			counters[0] = 0;
			counters[1] = 0;
			counters[2] = 0;
			counters[3] = 0;

			r = (i / 2) * 2;
			c = (i % 2) * 2;

			count(counters, cells[r][c]);
			count(counters, cells[r + 1][c]);
			count(counters, cells[r][c + 1]);
			count(counters, cells[r + 1][c + 1]);

			if (!(counters[0] == 1 && counters[1] == 1 && counters[2] == 1 && counters[3] == 1)) {
				return false;
			}
		}

		return true;
	}

	private void count(int[] counters, int number) {
		if (number == 1) {
			counters[0]++;
		}
		if (number == 2) {
			counters[1]++;
		}
		if (number == 3) {
			counters[2]++;
		}
		if (number == 4) {
			counters[3]++;
		}
	}

	protected void getCells() {
		cells[0][0] = Integer.parseInt(((EditText) findViewById(R.id.cell1)).getText().toString());
		cells[0][1] = Integer.parseInt(((EditText) findViewById(R.id.cell2)).getText().toString());
		cells[0][2] = Integer.parseInt(((EditText) findViewById(R.id.cell3)).getText().toString());
		cells[0][3] = Integer.parseInt(((EditText) findViewById(R.id.cell4)).getText().toString());
		cells[1][0] = Integer.parseInt(((EditText) findViewById(R.id.cell5)).getText().toString());
		cells[1][1] = Integer.parseInt(((EditText) findViewById(R.id.cell6)).getText().toString());
		cells[1][2] = Integer.parseInt(((EditText) findViewById(R.id.cell7)).getText().toString());
		cells[1][3] = Integer.parseInt(((EditText) findViewById(R.id.cell8)).getText().toString());
		cells[2][0] = Integer.parseInt(((EditText) findViewById(R.id.cell9)).getText().toString());
		cells[2][1] = Integer.parseInt(((EditText) findViewById(R.id.cell10)).getText().toString());
		cells[2][2] = Integer.parseInt(((EditText) findViewById(R.id.cell11)).getText().toString());
		cells[2][3] = Integer.parseInt(((EditText) findViewById(R.id.cell12)).getText().toString());
		cells[3][0] = Integer.parseInt(((EditText) findViewById(R.id.cell13)).getText().toString());
		cells[3][1] = Integer.parseInt(((EditText) findViewById(R.id.cell14)).getText().toString());
		cells[3][2] = Integer.parseInt(((EditText) findViewById(R.id.cell15)).getText().toString());
		cells[3][3] = Integer.parseInt(((EditText) findViewById(R.id.cell16)).getText().toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
