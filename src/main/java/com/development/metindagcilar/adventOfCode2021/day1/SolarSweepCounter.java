package com.development.metindagcilar.adventOfCode2021.day1;

import java.util.ArrayList;
import java.util.List;

public class SolarSweepCounter {

    public List<Integer> sumOfSlidingWindow(List<Integer> input) {
        List<Integer> sumOfSlidingWindow = new ArrayList<>();

        for (int i = 0; i < input.size() - 2; i++) {
            sumOfSlidingWindow.add(input.get(i) + input.get(i + 1) + input.get(i + 2));
        }
        return sumOfSlidingWindow;
    }

    public int numberOfTimesSolarSweepIsLargerThanPrevious(List<Integer> input) {
        int counter = -1;

        int previousValue = 0;
        for (int currentValue : input) {
            if (currentValue > previousValue) {
                counter++;
            }
            previousValue = currentValue;
        }

        return counter;
    }

}