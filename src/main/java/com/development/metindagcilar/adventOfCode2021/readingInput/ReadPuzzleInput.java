package com.development.metindagcilar.adventOfCode2021.readingInput;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@AllArgsConstructor
public class ReadPuzzleInput {

    private final int adventDay;
    private static final String BASE_PATH = "/Users/metin.dagcilar/IdeaProjects/other/JavaExamples/src/main/java/com/development/metindagcilar/adventOfCode2021/day";
    private static final String INPUT_SAMPLE_TXT = "/input/sample.txt";
    private static final String INPUT_ONE_TXT = "/input/one.txt";
    private static final String INPUT_TWO_TXT = "/input/two.txt";

    public List<Integer> sampleInput() {
        return readFileIntoIntegerList(samplePath());
    }

    public List<Integer> inputOne() {
        return readFileIntoIntegerList(inputOnePath());
    }

    public List<Integer> inputTwo() {
        return readFileIntoIntegerList(inputTwoPath());
    }

    public Stream<String> sampleInputIntoStream() {
        return readFileIntoStream(samplePath());
    }

    public Stream<String> inputOneIntoStream() {
        return readFileIntoStream(inputOnePath());
    }

    public Stream<String> inputTwoIntoStream() {
        return readFileIntoStream(inputTwoPath());
    }

    private List<Integer> readFileIntoIntegerList(String inputPath) {
        List<Integer> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(inputPath))) {
            stream.forEach(line -> lines.add(Integer.valueOf(line)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    private Stream<String> readFileIntoStream(String inputPath) {
        try {
            return Files.lines(Paths.get(inputPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String samplePath() {
        return BASE_PATH + adventDay + INPUT_SAMPLE_TXT;
    }

    private String inputOnePath() {
        return BASE_PATH + adventDay + INPUT_ONE_TXT;
    }

    private String inputTwoPath() {
        return BASE_PATH + adventDay + INPUT_TWO_TXT;
    }
}
