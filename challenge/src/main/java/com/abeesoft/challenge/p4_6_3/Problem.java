package com.abeesoft.challenge.p4_6_3;

import java.util.HashMap;
import java.util.Map;

public class Problem {
	Map<Integer, Person> personsBackward = new HashMap<Integer, Person>();
	Map<Integer, Person> personsForward = new HashMap<Integer, Person>();

	public Problem() {
	}

	public Cost cost(DecisionBackward decisionBackward) {
		return new Cost(decisionBackward.person.time);
	}

	public Cost cost(DecisionForward decisionForward) {
		if (decisionForward.person2 == null)
			return new Cost(decisionForward.person1.time);
		else
			return new Cost(Math.max(decisionForward.person1.time, decisionForward.person2.time));
	}

	public Problem subProblemByDecisionBackward(DecisionBackward decisionBackward) {
		Problem problem = new Problem();
		problem.personsForward = new HashMap<>(personsForward);
		problem.personsBackward = new HashMap<>(personsBackward);
		problem.personsBackward.remove(decisionBackward.person.id);
		problem.personsForward.put(decisionBackward.person.id, decisionBackward.person);
		return problem;
	}

	public Problem subProblemByDecisionForward(DecisionForward decisionForward) {
		Problem problem = new Problem();
		problem.personsForward = new HashMap<>(personsForward);
		problem.personsBackward = new HashMap<>(personsBackward);
		problem.personsForward.remove(decisionForward.person1.id);
		problem.personsBackward.put(decisionForward.person1.id, decisionForward.person1);
		if (decisionForward.person2 != null) {
			problem.personsForward.remove(decisionForward.person2.id);
			problem.personsBackward.put(decisionForward.person2.id, decisionForward.person2);
		}
		return problem;
	}
}
