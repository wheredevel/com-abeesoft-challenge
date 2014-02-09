package com.abeesoft.challenge.p110201_10038;

import java.util.Arrays;

public class Problem {

	public static class Input {

		@Override
		public String toString() {
			return Arrays.toString(numbers);
		}

		public Input(int[] numbers) {
			super();
			this.numbers = numbers;
		}

		int[] numbers;
	}

	public static class Output {

		public Output(boolean jolly) {
			super();
			this.jolly = jolly;
		}

		@Override
		public String toString() {
			return jolly ? "Jolly" : "Not jolly";
		}

		boolean jolly;
	}

}
