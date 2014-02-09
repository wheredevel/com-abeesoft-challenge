package com.abeesoft.challenge.p110204_843;

import java.util.List;

public class Problem {

	public static class Input {
		List<String> words;
		List<String> encriptedLines;

		public Input(List<String> words, List<String> encriptedLines) {
			super();
			this.words = words;
			this.encriptedLines = encriptedLines;
		}

		@Override
		public String toString() {
			return "Input [words=" + words + ", encriptedLines=" + encriptedLines + "]";
		}
	}

	public static class Output {
		List<String> decriptedLines;

		@Override
		public String toString() {
			return "Output [decriptedLines=" + decriptedLines + "]";
		}
	}

}
