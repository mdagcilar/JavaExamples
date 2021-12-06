package com.development.metindagcilar.adventOfCode2021.readingInput;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@AllArgsConstructor
public class ReadPuzzleInput {

    private final int adventDay;

    public List<Integer> sampleInput() {
        String sampleInputPath =
                "/Users/metin.dagcilar/IdeaProjects/other/JavaExamples/src/main/java/com/development/metindagcilar/adventOfCode2021/day" + adventDay + "/input/sample.txt";

        return readFileIntoIntegerList(sampleInputPath);
    }

    public List<Integer> inputOne() {
        String inputPath =
                "/Users/metin.dagcilar/IdeaProjects/other/JavaExamples/src/main/java/com/development/metindagcilar/adventOfCode2021/day" + adventDay + "/input/one.txt";

        return readFileIntoIntegerList(inputPath);
    }

    public List<Integer> inputTwo() {
        String inputPath =
                "/Users/metin.dagcilar/IdeaProjects/other/JavaExamples/src/main/java/com/development/metindagcilar/adventOfCode2021/day" + adventDay + "/input/two.txt";

        return readFileIntoIntegerList(inputPath);
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
}
