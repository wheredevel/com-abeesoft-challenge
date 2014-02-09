package com.abeesoft.challenge.p8_6_2;

public class Puzzle {
	int[][] board = new int[4][4];
	int emptyI;
	int emptyJ;

	public Puzzle() {
	}

	@Override
	protected Puzzle clone() throws CloneNotSupportedException {
		Puzzle puzzle = new Puzzle();
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				puzzle.board[i][j] = this.board[i][j];
			}
		}
		puzzle.emptyI = this.emptyI;
		puzzle.emptyJ = this.emptyJ;
		return puzzle;
	}
}
