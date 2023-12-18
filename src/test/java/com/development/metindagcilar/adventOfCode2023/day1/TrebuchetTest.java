package com.development.metindagcilar.adventOfCode2023.day1;

import com.development.metindagcilar.adventOfCode2023.ReadPuzzleInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrebuchetTest {

    private final ReadPuzzleInput readPuzzleInput = new ReadPuzzleInput(1);

    @Test
    void testSampleInput() {
        Trebuchet trebuchet = new Trebuchet();
        int sumOfCalibrationValues = trebuchet.sumOfCalibrationValues(readPuzzleInput.getSampleAsLines());

        assertThat(sumOfCalibrationValues).isEqualTo(142);
    }

    @Test
    void testPartOneInput() {
        Trebuchet trebuchet = new Trebuchet();
        int sumOfCalibrationValues = trebuchet.sumOfCalibrationValues(readPuzzleInput.getInputOneAsLines());

        assertThat(sumOfCalibrationValues).isEqualTo(55652);
    }

    @Test
    void testSampleTwoInput() {
        Trebuchet trebuchet = new Trebuchet();
        int sumOfCalibrationValues = trebuchet.sumOfCalibrationValues(readPuzzleInput.getSampleTwoAsLines());

        assertThat(sumOfCalibrationValues).isEqualTo(281);
    }

    @Test
    void testPartTwoInput() {
        Trebuchet trebuchet = new Trebuchet();
        int sumOfCalibrationValues = trebuchet.sumOfCalibrationValues(readPuzzleInput.getInputOneAsLines());

        assertThat(sumOfCalibrationValues).isEqualTo(55652);
    }


}