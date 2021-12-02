package com.aoc2021.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

public abstract class Solution {

	private final int day;

	private final int questionNumber;

	private static final String INFO_TEMPLATE = "Day %d Solution %d: ";

	public Solution(int day, int questionNumber) {
		this.day = day;
		this.questionNumber = questionNumber;
	}

	public abstract void run();

	protected List<String> getSingleLineInput(String filePathStr) {
		try {
			return getStrListFromFile(filePathStr);
		} catch (IOException e) {
			return Collections.emptyList();
		}
	}

	protected void printResult(String result) {
		System.out.println(getInfo() + result);
	}

	private List<String> getStrListFromFile(String filePathStr) throws IOException {
		final List<String> lines = Files.readAllLines(new File(filePathStr).toPath());
		return lines;
	}

	private String getInfo() {
		return String.format(INFO_TEMPLATE, day, questionNumber);
	}

}
