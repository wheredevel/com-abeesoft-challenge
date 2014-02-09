package com.abeesoft.challenge.p8_6_2;

public class History implements Cloneable {
	int[][] visited = new int[4][4];
	int visitedNum = 0;

	@Override
	protected History clone() throws CloneNotSupportedException {
		History history = new History();
		for (int i = 0; i < history.visited.length; i++) {
			for (int j = 0; j < history.visited[i].length; j++) {
				history.visited[i][j] = this.visited[i][i];
			}
		}
		history.visitedNum = this.visitedNum;
		return history;
	}
}
