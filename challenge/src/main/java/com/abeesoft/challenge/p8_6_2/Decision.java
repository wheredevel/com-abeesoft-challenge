package com.abeesoft.challenge.p8_6_2;

public class Decision {
	public static final Decision D = new Decision(1, 0);
	public static final Decision L = new Decision(0, -1);
	public static final Decision R = new Decision(0, 1);
	public static final Decision U = new Decision(-1, 0);

	int i;
	int j;

	public Decision(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	public void print() {
		if (this == D)
			System.out.println("D");
		else if (this == L)
			System.out.println("L");
		else if (this == R)
			System.out.println("R");
		else if (this == U)
			System.out.println("U");
	}
}
