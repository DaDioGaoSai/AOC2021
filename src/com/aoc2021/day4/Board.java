package com.aoc2021.day4;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Board {

	private final List<Point> points;
	private final int id;

	public Board(int id, List<Point> points) {
		this.points = points;
		this.id = id;
	}

	public List<Point> getPoints() {
		return this.points;
	}

	public void printBoard() {
		System.out.println(String.format("The layout of Board %d:", this.id));
		int previousY = 0;
		for (int i = 0; i < points.size(); i++) {
			if (points.get(i).y() != previousY) {
				previousY = points.get(i).y();
				System.out.println();
			}
			System.out.print(String.format("%-2s ", points.get(i).value()));
		}
		System.out.println();
	}

	public List<Point> getWonPoints(List<Integer> sequence) {
		List<Point> points = getGuessdPointsFromTheBoard(sequence);
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

	private List<Point> getGuessdPointsFromTheBoard(List<Integer> sequence) {
		return points.stream().filter(point -> sequence.contains(point.value())).collect(Collectors.toList());
	}
}
