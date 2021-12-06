package com.development.metindagcilar.adventOfCode2021.day2;

import java.util.stream.Stream;

public class Dive {

    private int horizontalPositions = 0;
    private int depth = 0;

    public int calculatePosition(Stream<String> sampleInputIntoStream) {
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
}