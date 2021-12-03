package com.aoc2021.day3;

import java.util.List;

public class BinaryDiagnosticOne extends BinaryDiagnosticBase {

	public BinaryDiagnosticOne() {
		super(3, 1);
	}

	@Override
	public void run() {
		final List<String> inputs = getSingleLineInput(fileName);
		final int mostCommonBitSt = Integer.parseInt(getMostLeastCommonBitStr(inputs, true), 2);
		final int leastCommonBitSt = Integer.parseInt(getMostLeastCommonBitStr(inputs, false), 2);

		printResult(Integer.toString(mostCommonBitSt * leastCommonBitSt));

	}
}
