package com.aoc2021.day4;

import java.util.ArrayList;
import java.util.List;

public class GiantSquidTwo extends GiantSquidBase {

	public GiantSquidTwo() {
		super(4, 2);
	}

	@Override
	public void run() {
		int result = 0;
		boolean lastWwinner = false;

		List<Integer> drawnRecords = new ArrayList<>();
		List<Board> boardRecords = new ArrayList<>(boards);

		for (int guess : inputSequence) {
			if (lastWwinner) {
				break;
			}
			drawnRecords.add(guess);
			for (Board board : boards) {
				if (!board.getWinningPattern(drawnRecords).isEmpty()) {
					boardRecords.remove(board);
					if (boardRecords.size() == 0) {
						lastWwinner = true;
						result = board.getSumOfUnmarked() * guess;
						break;
					}
				}
			}
		}
		printResult(Integer.toString(result));
	}
}
