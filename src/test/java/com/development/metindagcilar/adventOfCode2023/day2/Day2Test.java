package com.development.metindagcilar.adventOfCode2023.day2;

import com.development.metindagcilar.adventOfCode2023.ReadPuzzleInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {

    private final ReadPuzzleInput readPuzzleInput = new ReadPuzzleInput(2);

    @Test
    void testSampleInput() {
        Day2 cubes = new Day2();
        int sumOfCalibrationValues = cubes.sumOfGameIds(readPuzzleInput.getSampleAsLines());

        assertThat(sumOfCalibrationValues).isEqualTo(8);
    }

    @Test
    void testPartOneInput() {
        Day2 cubes = new Day2();
        int sumOfCalibrationValues = cubes.sumOfGameIds(readPuzzleInput.getInputOneAsLines());

        assertThat(sumOfCalibrationValues).isEqualTo(2632);
    }

    @Test
    void testSampleTwoInput() {
        Day2 cubes = new Day2();
        int sumOfCalibrationValues = cubes.powerOfGameIds(readPuzzleInput.getSampleTwoAsLines());

        assertThat(sumOfCalibrationValues).isEqualTo(2286);
    }

    @Test
    void testPartTwoInput() {
        Day2 cubes = new Day2();
        int sumOfCalibrationValues = cubes.powerOfGameIds(readPuzzleInput.getInputOneAsLines());

        assertThat(sumOfCalibrationValues).isEqualTo(69629);
    }

}