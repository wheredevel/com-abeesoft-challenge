package com.abeesoft.challenge.p4_xx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File(args[0]));
		FileWriter fileWriter = new FileWriter(args[1]);
		int n = scanner.nextInt();
		double x = scanner.nextDouble();
		double[] S = new double[n + 1];
		for (int i = 1; i <= n; i++) {
			S[i] = scanner.nextDouble();
		}
		Arrays.sort(S);
		HashSet<Double> lookup = new HashSet<Double>(n);
		for (int i = 1; i <= n; i++) {
			double complement = Math.round((x - S[i]) * 100) / 100.;
			if (complement >= 0) {
				System.out.print("Check: " + S[i] + " + " + complement + "\n");
				if (lookup.contains(complement))
					fileWriter.write("Match: " + S[i] + " and " + complement + "\n");
			}
			lookup.add(S[i]);
		}
		fileWriter.close();
		scanner.close();
	}
}
