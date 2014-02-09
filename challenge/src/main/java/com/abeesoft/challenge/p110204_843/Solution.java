package com.abeesoft.challenge.p110204_843;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

import com.abeesoft.challenge.p110204_843.Problem.Input;
import com.abeesoft.challenge.p110204_843.Problem.Output;

public class Solution {

	private static Logger LOG = Logger.getLogger(Solution.class.getName());

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<String> words = new ArrayList<>();
		words.add("and");
		words.add("dick");
		words.add("jane");
		words.add("puff");
		words.add("spot");
		words.add("yertle");
		List<String> encriptedLines = new ArrayList<>();
		encriptedLines.add("bjvg xsb hxsn xsb qymm xsb rqat xsb pnetfn");
		encriptedLines.add("xxxx yyy zzzz www yyyy aaa bbbb ccc dddddd");
		Input input = new Input(words, encriptedLines);
		Output output = solution.solve(input);
		System.out.println(output);
		LOG.info("Solution: " + solution);
	}

	private long timeInMillis;

	public Output solve(Input input) {
		timeInMillis = System.currentTimeMillis();
		Collections.sort(input.words);
		for (String encriptedLine : input.encriptedLines) {
			List<String> encriptedWords = new ArrayList<>(new HashSet<String>(Arrays.asList(encriptedLine.split(" "))));
			Collections.sort(encriptedWords);
			for (String encriptedWord : encriptedWords) {
				for (String word : input.words) {
					if (word.length() == encriptedWord.length()) {

					}
				}
			}
		}
		timeInMillis = System.currentTimeMillis() - timeInMillis;
		return new Output();
	}

	@Override
	public String toString() {
		return "Solution [timeInMillis=" + timeInMillis + "]";
	}

}