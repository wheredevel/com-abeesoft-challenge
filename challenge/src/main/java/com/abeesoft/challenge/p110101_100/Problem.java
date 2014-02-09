package com.abeesoft.challenge.p110101_100;


public class Problem {

	public static class Input {
		long start;

		long stop;

		public Input(long start, long stop) {
			super();
			this.start = start;
			this.stop = stop;
		}
	}

	public static class Output {

		long start;

		long stop;

		long maxCycleLength;

		public Output(long start, long stop, long maxCycleLength) {
			super();
			this.start = start;
			this.stop = stop;
			this.maxCycleLength = maxCycleLength;
		}

		@Override
		public String toString() {
			return "Output [i=" + start + ", j=" + stop + ", maxCycleLength="
					+ maxCycleLength + "]";
		}
	}

}
