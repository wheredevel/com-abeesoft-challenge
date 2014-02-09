package com.abeesoft.challenge.p4_6_3;

public class Solution
{
	Cost cost;
	DecisionBackward decisionBackward;
	DecisionForward decisionForward;
	Solution solutionSub;

	public Solution() {
		super();
	}

	public Solution(DecisionBackward decisionBackward, Solution solutionSub, Cost cost) {
		super();
		this.decisionBackward = decisionBackward;
		this.solutionSub = solutionSub;
		this.cost = cost;
	}

	public Solution(DecisionForward decisionForward, Solution solutionSub, Cost cost) {
		super();
		this.decisionForward = decisionForward;
		this.solutionSub = solutionSub;
		this.cost = cost;
	}
}