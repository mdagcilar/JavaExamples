package com.development.metindagcilar.adventOfCode2023.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Trebuchet {

    Map<String, String> numbersMap = Map.of(
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9"
    );

    public int sumOfCalibrationValues(List<String> calibrations) {
        List<String> convertWordsToDigits = calibrations.stream()
                .map(this::replaceWordsAsNumbers)
                .collect(Collectors.toList());

        List<String> digits = replaceAllNonDigits(convertWordsToDigits);

        List<String> collect = getReducedDigits(digits);
        return sumOfStrings(collect);
    }

    // e.g. xtwone3four
    // letter by letter advance by 1 index
    // see if the first index forms a match with any number from our numbers list
    // if match, strip out matching word and replace with number
    // continue to try and match until end of string
    private String replaceWordsAsNumbers(String calibration) {
        StringBuilder result = new StringBuilder();
        ArrayList<String> numbers = new ArrayList<>(numbersMap.keySet());

        for (int i = 0; i < calibration.length(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                String substring = calibration.substring(i);
                String number = numbers.get(j);
                if (substring.startsWith(number)) {
                    result.append(numbersMap.get(number));
                    if (i + number.length() >= calibration.length())
                        break;
                    i = i + number.length() -1;
                    j = -1;
                }
            }
            result.append(calibration.charAt(i));
        }
        return result.toString();
    }

    private List<String> replaceAllNonDigits(List<String> calibrations) {
        return calibrations.stream()
                .map(line -> line.replaceAll("\\D", ""))
                .toList();
    }

    private List<String> getReducedDigits(List<String> digits) {
        return digits.stream()
                .map(line -> {
                    int lengthOfInput = line.length();
                    if (lengthOfInput == 0) {
                        throw new RuntimeException();
                    } else if (lengthOfInput == 1) {
                        return line + line;
                    } else if (lengthOfInput == 2) {
                        return line;
                    } else {
                        return String.valueOf(line.charAt(0)) + line.charAt(lengthOfInput - 1);
                    }
                })
                .collect(Collectors.toList());
    }

    private int sumOfStrings(List<String> reducedDigits) {
        return reducedDigits.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

}
