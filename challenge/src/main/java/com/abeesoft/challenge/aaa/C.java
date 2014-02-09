package com.abeesoft.challenge.aaa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class C {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File(args[0]));
		FileWriter fileWriter = new FileWriter(args[1]);
		int N = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= N; i++) {
			String line = scanner.nextLine();
			String[] words = line.split(" ");
			StringBuffer stringBuffer = new StringBuffer();
			for (String word : words) {
				stringBuffer.insert(0, word + " ");
			}
			stringBuffer.deleteCharAt(stringBuffer.length() - 1);
			fileWriter.write("Case #" + i + ": " + stringBuffer + "\n");
		}
		fileWriter.close();
		scanner.close();
	}
}
