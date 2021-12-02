package com.aoc2021.util;

import java.util.List;
import java.util.stream.Collectors;

public final class TestDataUtil {

	private TestDataUtil() {
	}

	public static List<Integer> convertStrListToInteger(List<String> strList) {
		return strList.stream().map(Integer::parseInt).collect(Collectors.toList());
	}

}
