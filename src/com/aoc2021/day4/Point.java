package com.aoc2021.day4;

public class Point {

	private int x;

	private int y;

	private int value;

	Point(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
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
}
