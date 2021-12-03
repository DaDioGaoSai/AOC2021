package com.aoc2021.day3;

import java.util.ArrayList;
import java.util.List;

public class BinaryDiagnosticTwo extends BinaryDiagnosticBase {

	public BinaryDiagnosticTwo() {
		super(3, 2);
	}

	@Override
	public void run() {
		final List<String> inputs = getSingleLineInput(fileName);

		int result = Integer.parseInt(getRating(inputs, true), 2) * Integer.parseInt(getRating(inputs, false), 2);
		printResult(Integer.toString(result));

	}

	private String getRating(List<String> inputList, boolean isOxygenGenRating) {
		List<String> inputs = new ArrayList<>(inputList);

		for (int i = 0; i < 12; i++) {
			final String mostCommonBitStr = getMostLeastCommonBitStr(inputs, isOxygenGenRating);
			if (inputs.size() == 1) {
				return inputs.get(0);
			} else {
				int index = i;
				inputs.removeIf(str -> str.charAt(index) != mostCommonBitStr.charAt(index));
			}
		}
		return inputs.get(0);
	}

}
