package com.abeesoft.challenge.p4_6_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solver {

	public static void main(String[] args) throws FileNotFoundException {
		Problem problem = new Problem();
		{
			Scanner scanner = new Scanner(new File("src/main/java/com/abeesoft/challenge/p4_6_5/1.in"));
			int jobsNum = scanner.nextInt();
			for (int i = 1; i <= jobsNum; i++) {
				Job job = new Job(i, scanner.nextInt(), scanner.nextInt());
				problem.jobs.put(job.id, job);
			}
			scanner.close();
		}
		System.out.println("Problem: ");
		print(problem);
		Solution solution = solve(problem);
		System.out.println("Solution: ");
		print(solution);
	}

	private static int penalty(Problem problem, Decision decision) {
		int penalty = 0;
		for (Job job : problem.jobs.values()) {
			if (job.id != decision.job.id)
				penalty += job.penalty;
		}
		penalty *= decision.job.time;
		return penalty;
	}

	private static void print(Problem problem) {
		for (Job job : problem.jobs.values()) {
			System.out.println(job);
		}
	}

	private static void print(Solution solution) {
		System.out.println(solution.cost);
		for (Decision decision : solution.decisions) {
			System.out.println(decision.job.id);
		}
	}

	private static Solution solve(Problem problem) {
		System.out.println("Solving: ");
		print(problem);

		if (problem.jobs.size() < 0)
			throw new IllegalArgumentException();

		if (problem.jobs.size() == 0)
			return new Solution();

		if (problem.jobs.size() == 1) {
			return new Solution(new Solution(), new Decision(problem.jobs.values().iterator().next()), new Cost());
		}

		Decision minDecision = null;
		Solution minSolutionSub = null;
		Cost minCost = Cost.MAX;
		for (Job job : problem.jobs.values()) {
			Decision decision = new Decision(job);
			Problem problemSub = new Problem(problem, job);
			Solution solutionSub = solve(problemSub);
			Cost cost = new Cost(penalty(problem, decision) + solutionSub.cost.penalty);
			if (cost.compareTo(minCost) < 0) {
				minDecision = decision;
				minSolutionSub = solutionSub;
				minCost = cost;
			}
		}

		Solution solution = new Solution(minSolutionSub, minDecision, minCost);
		return solution;
	}
}
