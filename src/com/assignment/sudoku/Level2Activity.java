package com.assignment.sudoku;

import java.util.ArrayList;
import java.util.Random;

import com.assignment.sudoku.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Level2Activity extends GameActivity {
	// to record if the cells are prefilled, 1 for yes, 0 for no
	private Integer[] prefilled = new Integer[16];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level2);
		message = (TextView) findViewById(R.id.tvMessage);
		initializePrefilled();
		initializeCells();
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

	private void fillCells(int[][] cells) {
		EditText editText;
		if (prefilled[0] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell1);
				editText.setText(Integer.toString(cells[0][0]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[1] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell2);
				editText.setText(Integer.toString(cells[0][1]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[2] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell3);
				editText.setText(Integer.toString(cells[0][2]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[3] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell4);
				editText.setText(Integer.toString(cells[0][3]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[4] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell5);
				editText.setText(Integer.toString(cells[1][0]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[5] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell6);
				editText.setText(Integer.toString(cells[1][1]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[6] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell7);
				editText.setText(Integer.toString(cells[1][2]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[7] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell8);
				editText.setText(Integer.toString(cells[1][3]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[8] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell9);
				editText.setText(Integer.toString(cells[2][0]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[9] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell10);
				editText.setText(Integer.toString(cells[2][1]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[10] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell11);
				editText.setText(Integer.toString(cells[2][2]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[11] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell12);
				editText.setText(Integer.toString(cells[2][3]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[12] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell13);
				editText.setText(Integer.toString(cells[3][0]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[13] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell14);
				editText.setText(Integer.toString(cells[3][1]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[14] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell15);
				editText.setText(Integer.toString(cells[3][2]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}
		if (prefilled[15] > 0) {
			try {
				editText = (EditText) findViewById(R.id.cell16);
				editText.setText(Integer.toString(cells[3][3]));
				editText.setEnabled(false);
			} catch (Exception e) {
			}
		}

	}

	private int[][] getSolution() {
		int n = 2;
		int[][] field = new int[n * n][n * n];
		for (int i = 0; i < n * n; i++)
			for (int j = 0; j < n * n; j++)
				field[i][j] = (i * n + i / n + j) % (n * n) + 1;

		return field;
	}

	private void initializeCells() {
		int[][] field = getSolution();
		cells = field;
		Random myRandom = new Random();

		// give each harmless atomic shuffle a probability of 50% to happen
		if (myRandom.nextInt(2) > 0) {
			cells = reverseRows(cells);
		}
		if (myRandom.nextInt(2) > 0) {
			cells = switchRow12(cells);
		}
		if (myRandom.nextInt(2) > 0) {
			cells = switchRow34(cells);
		}
		if (myRandom.nextInt(2) > 0) {
			cells = reverseCols(cells);
		}
		if (myRandom.nextInt(2) > 0) {
			cells = switchCol12(cells);
		}
		if (myRandom.nextInt(2) > 0) {
			cells = switchCol34(cells);
		}

		fillCells(cells);
	}

	private void initializePrefilled() {
		// set all defaults to 0
		int i;
		for (i = 0; i < 16; i++) {
			prefilled[i] = 0;
		}

		// randomly set 8 cells to prefilled
		Random myRandom = new Random();
		ArrayList<Integer> preBits = new ArrayList<Integer>();
		int num;

		while (preBits.size() < 8) {
			num = myRandom.nextInt(16);
			if (!preBits.contains(num)) {
				preBits.add(num);
			}
		}

		for (i = 0; i < preBits.size(); i++) {
			prefilled[preBits.get(i)] = 1;
		}
	}

	// rows and columns both have 3 harmless atomic shuffle
	private int[][] reverseCols(int[][] cells) {
		int[][] reval = new int[4][4];
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				reval[i][j] = cells[i][3 - j];
			}
		}

		return reval;
	}

	private int[][] reverseRows(int[][] field) {
		int[][] reval = new int[4][4];

		reval[0] = field[3];
		reval[1] = field[2];
		reval[2] = field[1];
		reval[3] = field[0];

		return reval;
	}

	private int[][] switchCol12(int[][] cells) {
		int[][] reval = new int[4][4];
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 2; j++) {
				reval[i][j] = cells[i][1 - j];
			}
			for (j = 2; j < 4; j++) {
				reval[i][j] = cells[i][j];
			}
		}

		return reval;
	}

	private int[][] switchCol34(int[][] cells) {
		int[][] reval = new int[4][4];
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 2; j++) {
				reval[i][j] = cells[i][j];
			}
			for (j = 2; j < 4; j++) {
				reval[i][j] = cells[i][5 - j];
			}
		}

		return reval;
	}

	private int[][] switchRow12(int[][] field) {
		int[][] reval = new int[4][4];

		reval[0] = field[1];
		reval[1] = field[0];
		reval[2] = field[2];
		reval[3] = field[3];

		return reval;
	}

	private int[][] switchRow34(int[][] field) {
		int[][] reval = new int[4][4];

		reval[0] = field[0];
		reval[1] = field[1];
		reval[2] = field[3];
		reval[3] = field[2];

		return reval;
	}

}
