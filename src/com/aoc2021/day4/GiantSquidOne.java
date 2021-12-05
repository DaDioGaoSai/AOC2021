package com.aoc2021.day4;

import java.util.ArrayList;
import java.util.List;

public class GiantSquidOne extends GiantSquidBase {

	public GiantSquidOne() {
		super(4, 1);
	}

	@Override
	public void run() {
		int result = 0;
		boolean firsWinner = false;

		List<Integer> drawnRecords = new ArrayList<>();

		for (int guess : inputSequence) {
			if (firsWinner) {
				break;
			}
			drawnRecords.add(guess);
			for (Board board : boards) {
				if (!board.getWinningPattern(drawnRecords).isEmpty()) {
					firsWinner = true;
					result = board.getSumOfUnmarked() * guess;
					break;
				}
			}
		}
		printResult(Integer.toString(result));
	}
}
