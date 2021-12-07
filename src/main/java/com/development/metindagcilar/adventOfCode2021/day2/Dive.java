package com.development.metindagcilar.adventOfCode2021.day2;

import java.util.List;

public class Dive {

    private int horizontalPositions = 0;
    private int depth = 0;
    private int aim = 0;

    public int calculatePositionPart1(List<String> sampleInputIntoStream) {
        sampleInputIntoStream.forEach(line -> {
            String[] splitLine = line.split(" ");

            if (splitLine[0].equals("forward")) {
                horizontalPositions += Integer.parseInt(splitLine[1]);
                return;
            }

            if (splitLine[0].equals("up")) {
                depth -= Integer.parseInt(splitLine[1]);
                return;
            }
            if (splitLine[0].equals("down")) {
                depth += Integer.parseInt(splitLine[1]);
            }
        });

        return horizontalPositions * depth;
    }

    public int calculatePositionPart2(List<String> sampleInputIntoStream) {
        sampleInputIntoStream.forEach(line -> {
            String[] splitLine = line.split(" ");

            if (splitLine[0].equals("forward")) {
                horizontalPositions += Integer.parseInt(splitLine[1]);
                depth += aim * Integer.parseInt(splitLine[1]);
                return;
            }

            if (splitLine[0].equals("up")) {
                aim -= Integer.parseInt(splitLine[1]);
                return;
            }
            if (splitLine[0].equals("down")) {
                aim += Integer.parseInt(splitLine[1]);
            }
        });
        return horizontalPositions * depth;
    }
}