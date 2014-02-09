package com.abeesoft.challenge.p8_6_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solver {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(args[0]));
		int probleNum = scanner.nextInt();
		for (int i = 0; i < probleNum; i++) {
			Problem problem = Problem.read(scanner);
			problem.print();
			try {
				problem.solution = Solver.solve(problem, new History(), 45);
			} catch (Exception e) {
				//
			}
			problem.print();
		}
		scanner.close();
	}

	public static Solution solve(Problem problem, History history, int maxVisistedNum) throws Exception {
		if (history.visited[problem.puzzle.emptyI][problem.puzzle.emptyJ] == 1 || history.visitedNum > maxVisistedNum)
			return null;

		System.out.println(history.visitedNum);

		history.visited[problem.puzzle.emptyI][problem.puzzle.emptyJ] = 1;
		history.visitedNum++;

		if (problem.solved)
			return null;

		Decision bestDecision = null;
		Problem bestSubProblem = null;
		Solution bestSubSolution = null;
		Cost bestCost = null;
		try {
			Decision decision = Decision.L;
			Problem subProblem = problem.clone().modify(decision);
			Solution subSolution = Solver.solve(subProblem, history.clone(), bestCost != null ? bestCost.depth : maxVisistedNum);
			if (bestSubSolution == null || subSolution == null || subSolution.isBetterThan(bestSubSolution)) {
				bestDecision = decision;
				bestSubProblem = subProblem;
				bestSubSolution = subSolution;
				bestCost = bestSubSolution != null ? bestSubSolution.cost.clone().modify(1) : new Cost(1);
			}
		} catch (Exception e) {
			//
		}
		try {
			Decision decision = Decision.R;
			Problem subProblem = problem.clone().modify(decision);
			Solution subSolution = Solver.solve(subProblem, history.clone(), bestCost != null ? bestCost.depth : maxVisistedNum);
			if (bestSubSolution == null || subSolution == null || subSolution.isBetterThan(bestSubSolution)) {
				bestDecision = decision;
				bestSubProblem = subProblem;
				bestSubSolution = subSolution;
				bestCost = bestSubSolution != null ? bestSubSolution.cost.clone().modify(1) : new Cost(1);
			}
		} catch (Exception e) {
			//
		}
		try {
			Decision decision = Decision.U;
			Problem subProblem = problem.clone().modify(decision);
			Solution subSolution = Solver.solve(subProblem, history.clone(), bestCost != null ? bestCost.depth : maxVisistedNum);
			if (bestSubSolution == null || subSolution == null || subSolution.isBetterThan(bestSubSolution)) {
				bestDecision = decision;
				bestSubProblem = subProblem;
				bestSubSolution = subSolution;
				bestCost = bestSubSolution != null ? bestSubSolution.cost.clone().modify(1) : new Cost(1);
			}
		} catch (Exception e) {
			//
		}
		try {
			Decision decision = Decision.D;
			Problem subProblem = problem.clone().modify(decision);
			Solution subSolution = Solver.solve(subProblem, history.clone(), bestCost != null ? bestCost.depth : maxVisistedNum);
			if (bestSubSolution == null || subSolution == null || subSolution.isBetterThan(bestSubSolution)) {
				bestDecision = decision;
				bestSubProblem = subProblem;
				bestSubSolution = subSolution;
				bestCost = bestSubSolution != null ? bestSubSolution.cost.clone().modify(1) : new Cost(1);
			}
		} catch (Exception e) {
			//
		}
		Solution solution = new Solution();
		solution.decision = bestDecision;
		solution.subProblem = bestSubProblem;
		solution.subProblem.solution = bestSubSolution;
		solution.cost = bestCost;
		return solution;
	}
}
