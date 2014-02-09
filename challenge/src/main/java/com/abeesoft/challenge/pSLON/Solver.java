package com.abeesoft.challenge.pSLON;

import java.io.File;
import java.io.FileNotFoundException;

public class Solver {

	public static void main(String[] args) throws FileNotFoundException {
		for (Problem problem : Problem.createFrom(new File(args[0]))) {
			Solver solver = new Solver(problem);
			problem.print(System.out);
			Solution solution = solver.solve();
			solution.print(System.out);
		}
	}

	Problem problem;

	public Solver(Problem problem) {
		this.problem = problem;
	}

	public Solution solve() {
		Solution solution = new Solution();

		return solution;
	}
}
