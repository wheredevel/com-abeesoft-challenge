package com.abeesoft.challenge.p4_6_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Solver {

	public static void main(String[] args) throws FileNotFoundException {
		Problem problem = new Problem();
		{
			Scanner scanner = new Scanner(new File("src/main/java/com/abeesoft/challenge/p4_6_3/1.in"));
			int personsNum = scanner.nextInt();
			for (int i = 1; i <= personsNum; i++) {
				Person person = new Person(i, scanner.nextInt());
				problem.personsForward.put(person.id, person);
			}
		}
		Solution solution = solveForward(problem);
		System.out.println(solution.cost.time);
		print(solution);

		// System.out.println("Problem: ");
		// explain(problem);
		// System.out.println("Solution: ");
		// explain(solution);
	}

	private static void explain(Problem problem) {
		System.out.println("Persons Forward");
		for (Person person : problem.personsForward.values()) {
			System.out.println(person);
		}
		System.out.println("Persons Backward");
		for (Person person : problem.personsBackward.values()) {
			System.out.println(person);
		}
	}

	private static void explain(Solution solution) {
		System.out.println(solution.cost.time);
		if (solution.decisionForward != null) {
			System.out.println(solution.decisionForward);
		} else {
			System.out.println(solution.decisionBackward);
		}
		if (solution.solutionSub != null)
			explain(solution.solutionSub);
	}

	private static void print(Solution solution) {
		if (solution.decisionForward != null) {
			System.out.print(solution.decisionForward.person1.time);
			if (solution.decisionForward.person2 != null)
				System.out.print(" " + solution.decisionForward.person2.time);
			System.out.println();
		} else {
			System.out.println(solution.decisionBackward.person.time);
		}
		if (solution.solutionSub != null)
			print(solution.solutionSub);
	}

	private static Solution solveBackward(Problem problem) {
		// System.out.println("Solving Backward: ");
		// explain(problem);

		if (problem.personsBackward.size() < 1)
			throw new IllegalArgumentException();

		if (problem.personsBackward.size() == 1) {
			DecisionBackward decisionBackward = new DecisionBackward(problem.personsBackward.values().iterator().next());
			return new Solution(decisionBackward, null, problem.cost(decisionBackward));
		}

		DecisionBackward minDecisionBackward = null;
		Solution minSolutionForwardSub = null;
		Cost minCost = Cost.MAX;
		for (Person person : problem.personsBackward.values()) {
			DecisionBackward decisionBackward = new DecisionBackward(person);
			Problem problemForwardSub = problem.subProblemByDecisionBackward(decisionBackward);
			Solution solutionForwardSub = solveForward(problemForwardSub);
			Cost cost = new Cost(problem.cost(decisionBackward).time + solutionForwardSub.cost.time);
			if (cost.compareTo(minCost) < 0) {
				minDecisionBackward = decisionBackward;
				minSolutionForwardSub = solutionForwardSub;
				minCost = cost;
			}
		}

		Solution solution = new Solution(minDecisionBackward, minSolutionForwardSub, minCost);
		return solution;
	}

	private static Solution solveForward(Problem problem) {
		// System.out.println("Solving Forward: ");
		// explain(problem);

		if (problem.personsForward.size() < 1)
			throw new IllegalArgumentException();

		if (problem.personsForward.size() == 1) {
			Iterator<Person> iterator = problem.personsForward.values().iterator();
			DecisionForward decisionForward = new DecisionForward(iterator.next(), null);
			return new Solution(decisionForward, null, problem.cost(decisionForward));
		}

		if (problem.personsForward.size() == 2) {
			Iterator<Person> iterator = problem.personsForward.values().iterator();
			DecisionForward decisionForward = new DecisionForward(iterator.next(), iterator.next());
			return new Solution(decisionForward, null, problem.cost(decisionForward));
		}

		DecisionForward minDecisionForward = null;
		Solution minSolutionBackwardSub = null;
		Cost minCost = Cost.MAX;
		for (Person person1 : problem.personsForward.values()) {
			for (Person person2 : problem.personsForward.values()) {
				if (person1.id < person2.id) {
					DecisionForward decisionForward = new DecisionForward(person1, person2);
					Problem problemSubBackward = problem.subProblemByDecisionForward(decisionForward);
					Solution solutionSubBackward = solveBackward(problemSubBackward);
					Cost cost = new Cost(problem.cost(decisionForward).time + solutionSubBackward.cost.time);
					if (cost.compareTo(minCost) < 0) {
						minDecisionForward = decisionForward;
						minSolutionBackwardSub = solutionSubBackward;
						minCost = cost;
					}
				}
			}
		}

		Solution solution = new Solution(minDecisionForward, minSolutionBackwardSub, minCost);
		return solution;
	}
}
