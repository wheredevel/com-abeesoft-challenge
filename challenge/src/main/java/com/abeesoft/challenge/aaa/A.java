package com.abeesoft.challenge.aaa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File(args[0]));
		FileWriter fileWriter = new FileWriter(args[1]);
		int N = scanner.nextInt();
		for (int i = 1; i <= N; i++) {
			int C = scanner.nextInt();
			int I = scanner.nextInt();
			int[] COSTS = new int[I + 1];
			for (int j = 1; j < COSTS.length; j++) {
				COSTS[j] = scanner.nextInt();
			}

			// scan for maxCost
			int maxCost = C;
			for (int j = 1; j < COSTS.length; j++) {
				maxCost = Math.max(maxCost, COSTS[j]);
			}

			// create COSTS_INDEXED
			Map<Integer, List<Integer>> COST_INDEXED = new HashMap<Integer, List<Integer>>();
			for (int j = 1; j < COSTS.length; j++) {
				List<Integer> indexes = COST_INDEXED.get(COSTS[j]);
				if (indexes == null) {
					indexes = new ArrayList<Integer>();
					COST_INDEXED.put(COSTS[j], indexes);
				}
				indexes.add(j);
			}

			for (int j1 = 1; j1 < COSTS.length; j1++) {
				if (C > COSTS[j1] && COST_INDEXED.containsKey(C - COSTS[j1])) {
					int j2 = COST_INDEXED.get(C - COSTS[j1]).get(0);
					if (j2 == j1)
						if (COST_INDEXED.get(COSTS[j1]).size() > 1)
							j2 = COST_INDEXED.get(COSTS[j1]).get(1);
						else
							continue;
					fileWriter.write("Case #" + i + ": " + Math.min(j1, j2) + " " + Math.max(j1, j2) + "\n");
					break;
				}
			}
		}
		fileWriter.close();
		scanner.close();
	}
}
