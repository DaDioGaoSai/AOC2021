package com.aoc2021.day2;

import java.util.List;

import com.aoc2021.base.Solution;

public class DiveOne extends Solution {

	private final String fileName = "D:\\Dev\\AOC\\AOC2021\\src\\com\\aoc2021\\day2\\testData1.txt";

	public DiveOne() {
		super(2, 1);
	}

	@Override
	public void run() {
		final List<String> input = getSingleLineInput(fileName);

		int horizontal = 0;
		int depth = 0;

		for (String str : input) {
			final String[] splitStr = str.trim().split("\\s+");

			if (splitStr[0].equals("forward")) {
				horizontal += Integer.parseInt(splitStr[1]);
			} else if (splitStr[0].equals("down")) {
				depth += Integer.parseInt(splitStr[1]);
			} else if (splitStr[0].equals("up")) {
				depth -= Integer.parseInt(splitStr[1]);
			}
		}

		printResult(Integer.toString(depth * horizontal));
	}

}
