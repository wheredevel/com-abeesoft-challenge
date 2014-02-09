package com.abeesoft.challenge.p110201_10038;

import java.util.logging.Logger;

import com.abeesoft.challenge.p110201_10038.Problem.Input;
import com.abeesoft.challenge.p110201_10038.Problem.Output;

public class Solution {

	private static Logger LOG = Logger.getLogger(Solution.class.getName());

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] numbers = { 1, 4, 2, 3 };
		Input input = new Input(numbers);
		Output output = solution.solve(input);
		System.out.println(output);
		LOG.info("Solution: " + solution);
	}

	public static class JollyFlagger {
		public JollyFlagger(int n) {
			super();
			if (n < 1)
				throw new IllegalArgumentException("n must be greater than 1");
			jollyFlags = new boolean[n];
		}

		private boolean[] jollyFlags;

		public boolean isJolly() {
			for (int i = 1; i < jollyFlags.length; i++) {
				if (!jollyFlags[i])
					return false;
			}
			return true;
		}

		public void setJollyFlag(int i) {
			if (i >= 1 && i < jollyFlags.length)
				jollyFlags[i] = true;
		}
	}

	@Override
	public String toString() {
		return "Solution [timeInMillis=" + timeInMillis + "]";
	}

	private long timeInMillis;

	public Output solve(Input input) {
		timeInMillis = System.currentTimeMillis();
		JollyFlagger jollyFlagger = new JollyFlagger(input.numbers.length);
		for (int i = 1; i < input.numbers.length; i++) {
			jollyFlagger.setJollyFlag(Math.abs(input.numbers[i]
					- input.numbers[i - 1]));
		}
		timeInMillis = System.currentTimeMillis() - timeInMillis;
		return new Output(jollyFlagger.isJolly());
	}

}