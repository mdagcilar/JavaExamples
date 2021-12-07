package com.development.metindagcilar.adventOfCode2021.day3;

import java.util.ArrayList;
import java.util.List;

public class BinaryDiagnostic {

    public int calculatePowerConsumption(List<String> binaries) {
        String gammaRate = applyMostCommonValue(binaries, "0", "1");
        String epsilonRate = applyMostCommonValue(binaries, "1", "0");
        int gammaValue = binaryToDecimal(gammaRate);
        int epsilonValue = binaryToDecimal(epsilonRate);

        return gammaValue * epsilonValue;
    }

    private String applyMostCommonValue(List<String> binaries, String mostCommon, String leastCommon) {
        StringBuilder sb = new StringBuilder();

        List<char[]> chars = toListOfChars(binaries);

        int length = chars.get(0).length;
        for (int i = 0; i < length; i++) {
            int count = getCount(chars, i);
            if (count > chars.size() / 2) {
                sb.append(mostCommon);
            } else {
                sb.append(leastCommon);
            }
        }
        return sb.toString();
    }

    private int getCount(List<char[]> chars, int i) {
        int count = 0;
        for (char[] aChar : chars) {
            char c = aChar[i];
            count += Integer.parseInt(String.valueOf(c));
        }
        return count;
    }

    private List<char[]> toListOfChars(List<String> binaries) {
        List<char[]> chars = new ArrayList<>();
        for (String binary : binaries) {
            chars.add(binary.toCharArray());
        }
        return chars;
    }

    public int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
