package com.development.metindagcilar.adventOfCode2021.day1;

import com.development.metindagcilar.adventOfCode2021.readingInput.ReadPuzzleInput;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolarSweepCounterTest {

    private final ReadPuzzleInput readPuzzleInput = new ReadPuzzleInput(1);

    @Test
    void testSampleInput() {
        SolarSweepCounter solarSweepCounter = new SolarSweepCounter();
        int actualCount = solarSweepCounter.numberOfTimesSolarSweepIsLargerThanPrevious(readPuzzleInput.sampleInput());

        assertThat(actualCount).isEqualTo(7);
    }

    @Test
    void testPuzzle1() {
        SolarSweepCounter solarSweepCounter = new SolarSweepCounter();
        int actualCount = solarSweepCounter.numberOfTimesSolarSweepIsLargerThanPrevious(readPuzzleInput.inputOne());

        assertThat(actualCount).isEqualTo(1559);
    }

    @Test
    void testPuzzle2() {
        SolarSweepCounter solarSweepCounter = new SolarSweepCounter();
        List<Integer> sumOfSlidingWindow = solarSweepCounter.sumOfSlidingWindow(readPuzzleInput.inputTwo());
        int actualCount = solarSweepCounter.numberOfTimesSolarSweepIsLargerThanPrevious(sumOfSlidingWindow);

        assertThat(actualCount).isEqualTo(1600);
    }
}