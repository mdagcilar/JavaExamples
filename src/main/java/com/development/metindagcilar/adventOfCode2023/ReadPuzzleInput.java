package com.development.metindagcilar.adventOfCode2023;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class ReadPuzzleInput {

    private final int adventDay;
    private static final String INPUT_SAMPLE_TXT = "/sample.txt";
    private static final String INPUT_ONE_TXT = "/one.txt";

    public List<Integer> getSampleAsIntegers() {
        return getLinesAsIntegers(INPUT_SAMPLE_TXT);
    }

    public List<Integer> getInputOneAsIntegers() {
        return getLinesAsIntegers(INPUT_ONE_TXT);
    }

    public List<String> getSampleAsLines() {
        return getLines(INPUT_SAMPLE_TXT);
    }

    public List<String> getInputOneAsLines() {
        return getLines(INPUT_ONE_TXT);
    }

    private List<Integer> getLinesAsIntegers(String inputPath) {
        List<Integer> lines = new ArrayList<>();
        try {
            List<String> input = Files.readAllLines(Paths.get("src/main/resources/adventofcode2023/day" + adventDay + "/" + inputPath));
            return input.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    private List<String> getLines(String inputPath) {
        try {
            return Files.readAllLines(Paths.get("src/main/resources/adventofcode2023/day" + adventDay + "/" + inputPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
