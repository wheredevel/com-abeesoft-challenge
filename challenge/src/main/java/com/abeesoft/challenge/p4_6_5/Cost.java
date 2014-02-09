package com.abeesoft.challenge.p4_6_5;

public class Cost implements Comparable<Cost> {
	public static final Cost MAX = new Cost(Integer.MAX_VALUE);

	int penalty;

	public Cost() {
		super();
	}

	public Cost(int penalty) {
		super();
		this.penalty = penalty;
	}

	@Override
	public int compareTo(Cost o) {
		return Integer.compare(penalty, o.penalty);
	}

	@Override
	public String toString() {
		return "Cost [penalty=" + penalty + "]";
	}
}
