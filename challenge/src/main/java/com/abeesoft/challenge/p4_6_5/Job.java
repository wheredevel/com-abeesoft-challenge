package com.abeesoft.challenge.p4_6_5;

public class Job {
	int id;
	int penalty;
	int time;

	public Job(int id, int penalty, int time) {
		super();
		this.id = id;
		this.penalty = penalty;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", penalty=" + penalty + ", time=" + time + "]";
	}
}
