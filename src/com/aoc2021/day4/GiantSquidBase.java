package com.aoc2021.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.aoc2021.base.Solution;
import com.aoc2021.util.AocUtils;

public class GiantSquidBase extends Solution {

	protected final String fileName = "D:\\Dev\\AOC\\AOC2021\\src\\com\\aoc2021\\day4\\testData1.txt";

	protected final List<String> inputs;

	protected final List<Board> boards;

	protected final List<Integer> inputSequence;

	public GiantSquidBase(int day, int questionNumber) {
		super(day, questionNumber);
		this.inputs = getSingleLineInput(fileName).stream().filter(str -> !str.isBlank()).collect(Collectors.toList());
		this.boards = initBoards(inputs);
		this.inputSequence = initInputSequence(inputs);
	}

	@Override
	public void run() {

	}

	private List<Integer> initInputSequence(List<String> inputs) {
		List<String> strList = Arrays.asList(inputs.get(0).split(","));
		return AocUtils.convertStrListToInteger(strList);
	}

	private List<Board> initBoards(List<String> inputs) {
		final List<Board> boards = new ArrayList<>();

		for (int i = 1; i < inputs.size(); i = i + 5) {
			List<Point> points = new ArrayList<Point>();
			for (int j = i; j <= i + 4; j++) {
				List<String> strList = Arrays.asList(inputs.get(j).split("[ ]+"));
				List<Integer> tempIntList = AocUtils.convertStrListToInteger(strList);
				for (int k = 0; k < tempIntList.size(); k++) {
					points.add(new Point(k, (j % 5) - 1, tempIntList.get(k)));
				}
			}
			boards.add(new Board(points));

		}
		return boards;
	}

}
