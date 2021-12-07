package com.development.metindagcilar.adventOfCode2021.day2;

import com.development.metindagcilar.adventOfCode2021.ReadPuzzleInput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DiveTest {

    private final ReadPuzzleInput readPuzzleInput = new ReadPuzzleInput(2);

    @Test
    void testSampleInput() {
        Dive dive = new Dive();
        int result = dive.calculatePositionPart1(readPuzzleInput.getSampleAsLines());

        Assertions.assertThat(result).isEqualTo(150);
    }

    @Test
    void testInputOne() {
        Dive dive = new Dive();
        int result = dive.calculatePositionPart1(readPuzzleInput.getInputOneAsLines());

        Assertions.assertThat(result).isEqualTo(1427868);
    }

    @Test
    void testSamplePart2() {
        Dive dive = new Dive();
        int result = dive.calculatePositionPart2(readPuzzleInput.getSampleAsLines());

        Assertions.assertThat(result).isEqualTo(900);
    }

    @Test
    void testInputTwo() {
        Dive dive = new Dive();
        int result = dive.calculatePositionPart2(readPuzzleInput.getInputOneAsLines());

        Assertions.assertThat(result).isEqualTo(1568138742);
    }

}