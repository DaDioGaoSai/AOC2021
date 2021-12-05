package com.aoc2021.day4;

public class Point {

	private final int x;

	private final int y;

	private final int value;

	private boolean isMarked;

	Point(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
		this.isMarked = false;
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

	public void setMark(boolean isMarked) {
		this.isMarked = isMarked;
	}

	public boolean isMarked() {
		return this.isMarked;
	}
}
