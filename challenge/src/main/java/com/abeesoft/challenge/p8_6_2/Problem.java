package com.abeesoft.challenge.p8_6_2;

import java.util.Scanner;

public class Problem {

	public static Problem read(Scanner scanner) {
		Problem problem = new Problem();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				problem.puzzle.board[i][j] = scanner.nextInt();
				if (problem.puzzle.board[i][j] == 0) {
					problem.puzzle.emptyI = i;
					problem.puzzle.emptyJ = j;
				}
			}
		}
		problem.checkSolved();
		return problem;
	}

	Puzzle puzzle = new Puzzle();

	Solution solution;

	boolean solved = false;

	public boolean isSolved() {
		return solved;
	}

	public Problem modify(Decision decision) {
		puzzle.board[puzzle.emptyI][puzzle.emptyJ] = puzzle.board[puzzle.emptyI + decision.i][puzzle.emptyJ + decision.j];
		puzzle.board[puzzle.emptyI + decision.i][puzzle.emptyJ + decision.j] = 0;
		puzzle.emptyI = puzzle.emptyI + decision.i;
		puzzle.emptyJ = puzzle.emptyJ + decision.j;
		checkSolved();
		return this;
	}

	public void print() {
		System.out.println("Puzzle:");
		for (int i = 0; i < puzzle.board.length; i++) {
			for (int j = 0; j < puzzle.board[i].length; j++) {
				System.out.print(puzzle.board[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		if (solution != null) {
			solution.print();
		} else {
			if (solved)
				System.out.println("Already solved!");
			else
				System.out.println("No solution (yet)!");
		}
	}

	protected void checkSolved()
	{
		int test = 1;
		for (int i = 0; i < puzzle.board.length; i++) {
			for (int j = 0; j < puzzle.board[i].length; j++) {
				if (puzzle.board[i][j] != test++) {
					break;
				}
			}
		}
		if (test == 17)
			solved = true;
	}

	@Override
	protected Problem clone() throws CloneNotSupportedException {
		Problem problem = new Problem();
		problem.puzzle = this.puzzle.clone();
		return problem;
	}
}
