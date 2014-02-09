package com.abeesoft.challenge.p4_6_5;

import java.util.LinkedList;

public class Solution
{
	Cost cost;

	LinkedList<Decision> decisions = new LinkedList<Decision>();

	public Solution() {
		super();
	}

	public Solution(Solution solutionSub, Decision decision, Cost cost) {
		super();
		this.decisions = new LinkedList<Decision>(solutionSub.decisions);
		this.decisions.addFirst(decision);
		this.cost = cost;
	}
}
