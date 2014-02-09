package com.abeesoft.challenge.p8_6_2;

public class Solution {
	Cost cost;
	Decision decision;
	Problem subProblem;

	public boolean isBetterThan(Solution solution) {
		return solution.cost.compareTo(this.cost) < 0;
	}

	public void print() {
		decision.print();
		if (subProblem != null && subProblem.solution != null)
			subProblem.solution.print();
	}
}
