package com.abeesoft.challenge.p4_6_5;

import java.util.HashMap;
import java.util.Map;

public class Problem {
	Map<Integer, Job> jobs = new HashMap<Integer, Job>();

	public Problem() {
	}

	public Problem(Problem problem, Job job) {
		super();
		this.jobs = new HashMap<>(problem.jobs);
		this.jobs.remove(job.id);
	}
}
