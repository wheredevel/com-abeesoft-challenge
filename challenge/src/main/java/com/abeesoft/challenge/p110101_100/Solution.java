package com.abeesoft.challenge.p110101_100;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import com.abeesoft.challenge.p110101_100.Problem.Input;
import com.abeesoft.challenge.p110101_100.Problem.Output;

public class Solution {

	public static class CycleLength {
		long length;

		long number;

		public CycleLength(long number, long length) {
			super();
			this.number = number;
			this.length = length;
		}

		@Override
		public String toString() {
			return "CycleLength [number=" + number + ", length=" + length + "]";
		}
	}

	private static Logger LOG = Logger.getLogger(Solution.class.getName());

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File(args[0]));
		FileWriter fileWriter = new FileWriter(args[1]);
		long N = scanner.nextInt();
		for (long i = 1; i <= N; i++) {
			Solution solution = new Solution();
			Input input = new Input(scanner.nextInt(), scanner.nextInt());
			Output output = solution.solve(input);
			fileWriter.write("" + input.start + " " + input.stop + " " + output.maxCycleLength + "\n");
			LOG.info("Solution: " + solution);
		}
		fileWriter.close();
		scanner.close();
	}

	private final Map<Long, Solution.CycleLength> _cycleLengths = new HashMap<Long, Solution.CycleLength>();

	private long timeInMillis;

	public Output solve(Input input) {
		timeInMillis = System.currentTimeMillis();
		long maxCycleLength = Long.MIN_VALUE;
		for (long i = input.start; i <= input.stop; i++) {
			Solution.CycleLength cycleLength = _cycleLength(i);
			maxCycleLength = Math.max(maxCycleLength, cycleLength.length);
		}
		timeInMillis = System.currentTimeMillis() - timeInMillis;
		return new Output(input.start, input.stop, maxCycleLength);

	}

	@Override
	public String toString() {
		return "Solution [timeInMillis=" + timeInMillis + "]";
	}

	private Solution.CycleLength _cycleLength(long number) {
		Solution.CycleLength cycleLength = _cycleLengths.get(number);
		if (cycleLength == null) {
			if (number > 1) {
				Solution.CycleLength nextCycleLength = _cycleLength(_next(number));
				cycleLength = new CycleLength(number, 1 + nextCycleLength.length);
				_cycleLengths.put(number, cycleLength);
				// LOG.info("Calculated " + cycleLength);
			} else if (number == 1) {
				cycleLength = new CycleLength(number, 1);
			} else
				throw new IllegalArgumentException("Cycles for numbers less than 1 are not defined!");
		}
		return cycleLength;
	}

	private long _next(long i) {
		return i % 2 == 0 ? i / 2 : i * 3 + 1;
	}

}