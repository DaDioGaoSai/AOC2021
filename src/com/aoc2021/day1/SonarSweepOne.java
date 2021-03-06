package com.aoc2021.day1;

import java.util.List;

import com.aoc2021.base.Solution;
import com.aoc2021.util.AocUtils;

public class SonarSweepOne extends Solution {

	private final String fileName = "D:\\Dev\\AOC\\AOC2021\\src\\com\\aoc2021\\day1\\testData1.txt";

	public SonarSweepOne() {
		super(1, 1);
	}

	public void run() {
		final List<Integer> inputList = AocUtils.convertStrListToInteger(getSingleLineInput(fileName));
		int result = -1;
		int previous = -1;

		for (int value : inputList) {
			if (value > previous) {
				result++;
			}
			previous = value;
		}
		printResult(Integer.toString(result));
	}
}
