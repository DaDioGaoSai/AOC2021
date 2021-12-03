package com.aoc2021.day1;

import java.util.List;

import com.aoc2021.base.Solution;
import com.aoc2021.util.AocUtils;

public class SonarSweepTwo extends Solution {

	private final String fileName = "D:\\Dev\\AOC\\AOC2021\\src\\com\\aoc2021\\day1\\testData2.txt";

	public SonarSweepTwo() {
		super(1, 2);
	}

	public void run() {
		final List<Integer> inputs = AocUtils.convertStrListToInteger(getSingleLineInput(fileName));

		int result = -1;
		int previous = -1;

		for (int i = 2; i < inputs.size(); i++) {
			int current = inputs.get(i - 2) + inputs.get(i - 1) + inputs.get(i);
			if (current > previous) {
				result++;
			}
			previous = current;
		}
		printResult(Integer.toString(result));
	}
}
