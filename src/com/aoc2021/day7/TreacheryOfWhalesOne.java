package com.aoc2021.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.aoc2021.base.Solution;
import com.aoc2021.util.AocUtils;

//Solution: 344605
public class TreacheryOfWhalesOne extends Solution {

	private final String fileName = "D:\\Dev\\AOC\\AOC2021\\src\\com\\aoc2021\\day7\\testData1.txt";

	public TreacheryOfWhalesOne() {
		super(7, 1);
	}

	@Override
	public void run() {
		final List<String> inputs = getSingleLineInput(fileName).stream().filter(str -> !str.isBlank())
				.collect(Collectors.toList());
		final List<Integer> positions = AocUtils.convertStrListToInteger(Arrays.asList(inputs.get(0).split(",")));
		final List<Integer> sumOfMovesToEachPoint = new ArrayList<>();

		int maxPosition = Collections.max(positions);
		int minPosition = Collections.min(positions);

		for (int i = minPosition; i <= maxPosition; i++) {
			int totalCost = 0;
			for (int j = 0; j < positions.size(); j++) {
				int steps = Math.abs(positions.get(j) - i);
				totalCost += steps;
			}
			sumOfMovesToEachPoint.add(totalCost);
		}

		String result = Integer.toString(Collections.min(sumOfMovesToEachPoint));
		printResult(result);
	}
}
