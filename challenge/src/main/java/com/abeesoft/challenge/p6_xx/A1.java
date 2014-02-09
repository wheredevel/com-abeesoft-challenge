package com.abeesoft.challenge.p6_xx;

public class A1 {

	private static int counter = 0;

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6 };
		subsets(a);
		System.out.println(counter);
	}

	private static void subsets(int[] a) {
		if (a == null)
			throw new IllegalArgumentException("a can not be null");
		subsets(a, 1, a.length - 1, "");
	}

	private static void subsets(int[] a, int i, int j, String prefix) {
		if (i > j) {
			System.out.println("{" + prefix + "}");
			counter++;
			return;
		}
		subsets(a, i + 1, j, prefix);
		subsets(a, i + 1, j, prefix.concat((prefix.length() > 0 ? "," : "") + a[i]));
	}
}
