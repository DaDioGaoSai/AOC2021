package com.aoc2021.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aoc2021.base.Solution;

// Performance problem ... Need to fix =.=
public class HydrothermalVentureOne extends Solution {

	private final String fileName = "D:\\Dev\\AOC\\AOC2021\\src\\com\\aoc2021\\day5\\Example.txt";

	private List<Point> points = new ArrayList<Point>();

	public HydrothermalVentureOne() {
		super(5, 1);
	}

	@Override
	public void run() {
		final List<String> inputs = getSingleLineInput(fileName).stream().filter(str -> !str.isBlank())
				.collect(Collectors.toList());

		inputs.forEach(input -> {
			final String dataSet[] = input.replaceAll(" -> ", ",").split(",");
			final int x1 = Integer.parseInt(dataSet[0]);
			final int y1 = Integer.parseInt(dataSet[1]);
			final int x2 = Integer.parseInt(dataSet[2]);
			final int y2 = Integer.parseInt(dataSet[3]);

			if (x1 == x2) {
				for (int i = y1; i <= y2; i++) {
					Point point = new Point(x1, i);
					addOrIncreasePoint(point);
				}

				for (int i = y2; i <= y1; i++) {
					Point point = new Point(x1, i);
					addOrIncreasePoint(point);
				}
			} else if (y1 == y2) {
				for (int i = x1; i <= x2; i++) {
					Point point = new Point(i, y1);
					addOrIncreasePoint(point);
				}

				for (int i = x2; i <= x1; i++) {
					Point point = new Point(i, y2);
					addOrIncreasePoint(point);
				}
			} else {
				if (x2 - x1 == y1 - y2) {
					for (int i = 0; i <= (x1 - x2); i++) {
						Point point = new Point(x1 - i, y1 + i);
						addOrIncreasePoint(point);
					}
					for (int i = 0; i <= (x2 - x1); i++) {
						Point point = new Point(x1 + i, y1 - i);
						addOrIncreasePoint(point);
					}

				} else if (x1 - x2 == y1 - y2) {
					for (int i = 0; i <= (x1 - x2); i++) {
						Point point = new Point(x2 + i, y2 + i);
						addOrIncreasePoint(point);
					}
					for (int i = 0; i <= (x2 - x1); i++) {
						Point point = new Point(x1 + i, y1 + i);
						addOrIncreasePoint(point);
					}
				}
			}
		});

		printResult(Integer.toString(getResult()));
	}

	private void addOrIncreasePoint(Point point) {
		Optional<Point> pointOpt = points.stream().filter(p -> p.equals(point)).findAny();
		if (pointOpt.isEmpty()) {
			points.add(point);
		} else {
			pointOpt.get().increase();
		}
	}

	private int getResult() {
		int result = 0;
		for (Point point : points) {
			if (point.value(2) > 0) {
				result++;
			}
		}
		return result;
	}

}
