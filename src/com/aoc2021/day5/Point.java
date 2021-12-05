package com.aoc2021.day5;

public class Point {

	private final int x;

	private final int y;

	private int value;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.value = 1;
	}

	public int x() {
		return this.x;
	}

	public int y() {
		return this.y;
	}

	public int value() {
		return this.value;
	}

	public int value(int thredshold) {
		if (value >= thredshold) {
			return value;
		} else {
			return 0;
		}
	}

	public void increase() {
		this.value++;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Point))
			return false;
		Point point = (Point) o;
		return point.x == x && point.y == y;
	}

}
