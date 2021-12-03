package com.aoc2021.day3;

import java.util.ArrayList;
import java.util.List;

import com.aoc2021.base.Solution;
import com.aoc2021.util.AocUtils;

public class BinaryDiagnosticBase extends Solution {

	public BinaryDiagnosticBase(int day, int questionNumber) {
		super(day, questionNumber);
	}

	@Override
	public void run() {

	}

	protected final String fileName = "D:\\Dev\\AOC\\AOC2021\\src\\com\\aoc2021\\day3\\testData1.txt";

	protected String getMostLeastCommonBitStr(List<String> inputs, boolean isMostCommon) {
		final List<Integer> numOfBitOneForEachColum = getNumOfBitOneForEachColumn(inputs);

		String commonBitString = AocUtils.EMPTY_STR;
		for (int oneCount : numOfBitOneForEachColum) {
			int zeroCount = inputs.size() - oneCount;
			if (zeroCount > oneCount) {
				commonBitString += '0';
			} else {
				commonBitString += '1';
			}
		}

		return isMostCommon ? commonBitString
				: commonBitString.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");
	}

	private List<Integer> getNumOfBitOneForEachColumn(List<String> inputs) {
		List<Integer> numOfBitOneForEachColum = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		for (String str : inputs) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '1') {
					int current = numOfBitOneForEachColum.get(i) + 1;
					numOfBitOneForEachColum.set(i, current);
				}
			}
		}
		return numOfBitOneForEachColum;
	}
}
