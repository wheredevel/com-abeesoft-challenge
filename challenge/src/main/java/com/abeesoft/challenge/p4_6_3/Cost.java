package com.abeesoft.challenge.p4_6_3;

public class Cost implements Comparable<Cost> {
	public static final Cost MAX = new Cost(Integer.MAX_VALUE);

	int time;

	public Cost(int time) {
		super();
		this.time = time;
	}

	@Override
	public int compareTo(Cost o) {
		return Integer.compare(time, o.time);
	}
}
