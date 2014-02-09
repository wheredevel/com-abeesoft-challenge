package com.abeesoft.challenge.x1;

import java.util.Arrays;
import java.util.InputMismatchException;

public class A {

	public static void main(String[] args) {
		int[] a = { -2, 0, -1 };
		int[] before = before(a);
		int[] after = after(a);
		int[] output = output(a, before, after);
		if (a.length < 2)
			throw new InputMismatchException("a length must be at least 2!");
		System.out.println("a =" + Arrays.toString(a));
		System.out.println("before =" + Arrays.toString(before));
		System.out.println("after =" + Arrays.toString(after));
		System.out.println("output =" + Arrays.toString(output));
	}

	private static int[] after(int[] a) {
		int[] after = new int[a.length];
		after[a.length - 1] = 1;
		for (int i = a.length - 2; i >= 0; i--) {
			after[i] = after[i + 1] * a[i + 1];
		}
		return after;
	}

	private static int[] before(int[] a) {
		int[] before = new int[a.length];
		before[0] = 1;
		for (int i = 1; i < a.length; i++) {
			before[i] = before[i - 1] * a[i - 1];
		}
		return before;
	}

	private static int[] output(int[] a, int[] before, int[] after) {
		int[] output = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			output[i] = before[i] * after[i];
		}
		return output;
	}

}
