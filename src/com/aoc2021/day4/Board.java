package com.aoc2021.day4;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Board {

	private final List<Point> points;

	public Board(List<Point> points) {
		this.points = points;
	}

	public List<Point> getPoints() {
		return this.points;
	}

	public List<Point> getWinningPattern(List<Integer> sequence) {
		List<Point> points = getGuessdPointsFromTheBoard(sequence);
		points.forEach(point -> point.setMark(true));

		Map<Integer, List<Point>> rowMatched = points.stream()
				.collect(Collectors.groupingBy(Point::y, Collectors.toList()));
		Map<Integer, List<Point>> columnMatched = points.stream()
				.collect(Collectors.groupingBy(Point::x, Collectors.toList()));

		for (Map.Entry<Integer, List<Point>> entry : columnMatched.entrySet()) {
			if (entry.getValue().size() == 5) {
				return entry.getValue();
			}
		}

		for (Map.Entry<Integer, List<Point>> entry : rowMatched.entrySet()) {
			if (entry.getValue().size() == 5) {
				return entry.getValue();
			}
		}
		return Collections.emptyList();
	}

	public int getSumOfUnmarked() {
		int result = 0;
		for (Point point : points) {
			if (!point.isMarked()) {
				result += point.value();
			}
		}
		return result;
	}

	private List<Point> getGuessdPointsFromTheBoard(List<Integer> sequence) {
		return points.stream().filter(point -> sequence.contains(point.value())).collect(Collectors.toList());
	}
}
