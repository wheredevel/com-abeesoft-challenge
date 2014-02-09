package com.abeesoft.challenge.pSLON;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem {

	public static List<Problem> createFrom(File file) throws FileNotFoundException {
		List<Problem> problems = new ArrayList<Problem>();
		Scanner scanner = new Scanner(file);
		int problemNum = scanner.nextInt();
		for (int i = 0; i < problemNum; i++) {
			problems.add(new Problem(scanner.nextInt(), scanner.nextInt()));
		}
		return problems;
	}

	int bishopNum;

	int boardSize;

	public Problem(int bishopNum, int boardSize) {
		super();
		this.bishopNum = bishopNum;
		this.boardSize = boardSize;
	}

	public void print(OutputStream outputStream) {

	}

}
