package com.abeesoft.challenge.pSLON;

import java.util.HashMap;
import java.util.Map;

public class Board {
	Map<Integer, Boolean> h;
	Map<Integer, Boolean> v;

	public Board(Board board) {
		super();
		h = new HashMap<Integer, Boolean>(h);
		v = new HashMap<Integer, Boolean>(v);
	}

}
