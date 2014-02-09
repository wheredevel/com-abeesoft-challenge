package com.abeesoft.challenge.p4_6_3;

public class Person {
	int id;
	int time;

	public Person(int id, int time) {
		super();
		this.id = id;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", time=" + time + "]";
	}
}
