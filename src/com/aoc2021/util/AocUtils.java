package com.aoc2021.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class AocUtils {

	public static final String EMPTY_STR = "";

	private AocUtils() {
	}

	public static List<Integer> convertStrListToInteger(List<String> strList) {
		List<String> strListLocal = new ArrayList<>(strList);
		strListLocal.removeIf(item -> item == null || EMPTY_STR.equals(item));

		return strListLocal.stream().map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
	}

}
