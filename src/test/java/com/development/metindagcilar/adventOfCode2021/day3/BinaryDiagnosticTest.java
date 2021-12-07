package com.development.metindagcilar.adventOfCode2021.day3;

import com.development.metindagcilar.adventOfCode2021.ReadPuzzleInput;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryDiagnosticTest {

    ReadPuzzleInput readPuzzleInput = new ReadPuzzleInput(3);

    @Test
    void binaryToDecimalGammaSample() {
        BinaryDiagnostic binaryToDecimal = new BinaryDiagnostic();
        assertThat(binaryToDecimal.binaryToDecimal("10110")).isEqualTo(22);
    }

    @Test
    void binaryToDecimalEpsilonSample() {
        BinaryDiagnostic binaryToDecimal = new BinaryDiagnostic();
        assertThat(binaryToDecimal.binaryToDecimal("01001")).isEqualTo(9);
    }

    @Test
    void calculatePositionSamplePart1() {
        BinaryDiagnostic binaryToDecimal = new BinaryDiagnostic();
        assertThat(binaryToDecimal.calculatePowerConsumption(readPuzzleInput.getSampleAsLines())).isEqualTo(198);
    }

    @Test
    void calculatePositionPart1() {
        BinaryDiagnostic binaryToDecimal = new BinaryDiagnostic();
        assertThat(binaryToDecimal.calculatePowerConsumption(readPuzzleInput.getInputOneAsLines())).isEqualTo(3847100);
    }

}