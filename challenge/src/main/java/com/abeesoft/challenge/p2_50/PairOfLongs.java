package com.abeesoft.challenge.p2_50;

public class PairOfLongs {
	private final long first;
	private final long second;
	private boolean unreversed = true;

	public PairOfLongs(long first, long second) {
		super();
		if (first < second) {
			unreversed = true;
			this.first = first;
			this.second = second;
		} else {
			this.first = second;
			this.second = first;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PairOfLongs other = (PairOfLongs) obj;
		if (first != other.first)
			return false;
		if (second != other.second)
			return false;
		return true;
	}

	public long firstCube() {
		return (long) Math.pow(getFirst(), 3);
	}

	public long getFirst() {
		return unreversed ? first : second;
	}

	public long getSecond() {
		return unreversed ? second : first;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (first ^ (first >>> 32));
		result = prime * result + (int) (second ^ (second >>> 32));
		return result;
	}

	public long ranj() {
		return firstCube() + secondCube();
	}

	public long secondCube() {
		return (long) Math.pow(getSecond(), 3);
	}

}
