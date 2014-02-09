package com.abeesoft.challenge.p4_6_3;

public class DecisionForward {
	Person person1;
	Person person2;

	public DecisionForward(Person person1, Person person2) {
		super();
		this.person1 = person1;
		this.person2 = person2;
	}

	@Override
	public String toString() {
		return "DecisionA [person1=" + person1 + ", person2=" + person2 + "]";
	}
}
