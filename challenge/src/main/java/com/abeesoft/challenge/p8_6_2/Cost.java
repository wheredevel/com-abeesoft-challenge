package com.abeesoft.challenge.p8_6_2;

public class Cost implements Comparable<Cost>, Cloneable {
	int depth;

	public Cost(int depth) {
		this.depth = depth;
	}

	@Override
	public int compareTo(Cost other) {
		return this.depth - other.depth;
	}

	public Cost modify(int depthIncrement) {
		depth += depthIncrement;
		return this;
	}

	public void print() {
		System.out.println(depth);
	}

	@Override
	protected Cost clone() throws CloneNotSupportedException {
		Cost cost = new Cost(this.depth);
		return cost;
	}
}
