package com.abeesoft.challenge.p2_50;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class A {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File(args[0]));
		FileWriter fileWriter = new FileWriter(args[1]);
		long n = scanner.nextLong();
		Map<Long, Set<PairOfLongs>> hits = new HashMap<Long, Set<PairOfLongs>>();
		_solve(n, hits, fileWriter, true);
		fileWriter.close();
		scanner.close();
	}

	private static void _solve(long n, Map<Long, Set<PairOfLongs>> hits, FileWriter fileWriter, boolean unique) throws IOException {
		for (long a = 1; a <= n; a++)
			for (long b = n; b >= a; b--) {
				PairOfLongs pairOfLongs = new PairOfLongs(a, b);
				long ranj = pairOfLongs.ranj();
				System.out.println("a=" + a + " b=" + b + " ranj=" + ranj);
				Set<PairOfLongs> set = hits.get(ranj);
				if (set == null) {
					set = new HashSet<PairOfLongs>();
					hits.put(ranj, set);
					continue;
				} else {
					set.add(pairOfLongs);
				}
			}
		for (Set<PairOfLongs> set : hits.values()) {
			for (PairOfLongs pairOfLongs1 : set) {
				for (PairOfLongs pairOfLongs2 : set) {
					if (unique) {
						if (!pairOfLongs1.equals(pairOfLongs2)) {
							fileWriter.write("a=" + pairOfLongs1.getFirst() + " b=" + pairOfLongs1.getSecond() + " c=" + pairOfLongs2.getFirst() + " d="
									+ pairOfLongs2.getSecond() + "\n");
						}
					} else {
						fileWriter.write("a=" + pairOfLongs1.getFirst() + " b=" + pairOfLongs1.getSecond() + " c=" + pairOfLongs2.getFirst() + " d="
								+ pairOfLongs2.getSecond() + "\n");
						fileWriter.write("a=" + pairOfLongs1.getSecond() + " b=" + pairOfLongs1.getFirst() + " c=" + pairOfLongs2.getFirst() + " d="
								+ pairOfLongs2.getSecond() + "\n");
						fileWriter.write("a=" + pairOfLongs1.getFirst() + " b=" + pairOfLongs1.getSecond() + " c=" + pairOfLongs2.getSecond() + " d="
								+ pairOfLongs2.getFirst() + "\n");
						fileWriter.write("a=" + pairOfLongs1.getSecond() + " b=" + pairOfLongs1.getFirst() + " c=" + pairOfLongs2.getSecond() + " d="
								+ pairOfLongs2.getFirst() + "\n");
					}
				}
			}
		}
	}
}
