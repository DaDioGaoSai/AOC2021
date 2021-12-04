package com.aoc2021.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.aoc2021.base.Solution;
import com.aoc2021.util.AocUtils;

// Sol: 7075
public class GiantSquidTwo extends Solution {

	final String fileName = "D:\\Dev\\AOC\\AOC2021\\src\\com\\aoc2021\\day4\\testData1.txt";

	public GiantSquidTwo() {
		super(4, 2);
	}

	@Override
	public void run() {
		final List<String> inputs = getSingleLineInput(fileName).stream().filter(str -> !str.isBlank())
				.collect(Collectors.toList());
		int result = 0;
		boolean winnerFound = false;
		final List<Board> boards = getBoards(inputs);
		final List<Integer> guessSequence = getGuessSequence(inputs);
		List<Integer> sequenceRecords = new ArrayList<>();
		List<Board> boardRecords = new ArrayList<>(boards);

		for (int guess : guessSequence) {
			if (winnerFound) {
				break;
			}
			sequenceRecords.add(guess);
			for (Board board : boards) {
				if (!board.getWonPoints(sequenceRecords).isEmpty()) {
					boardRecords.remove(board);
					if (boardRecords.size() == 0) {
						winnerFound = true;
						result = (getSumOfUnMarked(board.getPoints(), sequenceRecords)) * guess;
						break;
					}
				}
			}
		}
		printResult(Integer.toString(result));
	}

	private int getSumOfUnMarked(List<Point> points, List<Integer> sequenceRecords) {
		int result = 0;
		for (Point point : points) {
			if (!sequenceRecords.contains(point.value())) {
				result += point.value();
			}
		}
		return result;
	}

	private List<Integer> getGuessSequence(List<String> inputs) {
		List<String> strList = Arrays.asList(inputs.get(0).split(","));
		return AocUtils.convertStrListToInteger(strList);
	}

	private List<Board> getBoards(List<String> inputs) {
		final List<Board> boards = new ArrayList<>();
		int boardID = 0;
		for (int i = 1; i < inputs.size(); i = i + 5) {
			List<Point> points = new ArrayList<Point>();
			for (int j = i; j <= i + 4; j++) {
				List<String> strList = Arrays.asList(inputs.get(j).split("[ ]+"));
				List<Integer> tempIntList = AocUtils.convertStrListToInteger(strList);
				for (int k = 0; k < tempIntList.size(); k++) {
					points.add(new Point(k, (j % 5) - 1, tempIntList.get(k)));
				}
			}

			Board board = new Board(boardID, points);
			boards.add(board);
			boardID++;

		}
		return boards;
	}

}
