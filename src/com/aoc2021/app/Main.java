package com.aoc2021.app;

import java.util.List;

import com.aoc2021.base.Solution;
import com.aoc2021.day1.SonarSweepOne;
import com.aoc2021.day1.SonarSweepTwo;
import com.aoc2021.day2.DiveOne;
import com.aoc2021.day2.DiveTwo;
import com.aoc2021.day3.BinaryDiagnosticOne;
import com.aoc2021.day3.BinaryDiagnosticTwo;
import com.aoc2021.day4.GiantSquidOne;
import com.aoc2021.day4.GiantSquidTwo;

public class Main {
	public static void main(String[] args) {
		final List<Solution> solutions = List.of(new SonarSweepOne(), new SonarSweepTwo(), new DiveOne(), new DiveTwo(),
				new BinaryDiagnosticOne(), new BinaryDiagnosticTwo(), new GiantSquidOne(), new GiantSquidTwo());

		solutions.forEach(solution -> {
			solution.run();
		});
	}

}
