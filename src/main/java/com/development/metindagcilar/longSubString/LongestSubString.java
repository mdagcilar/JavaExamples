package com.development.metindagcilar.longSubString;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public int value(String input) {
        String output = "";
        for (int start = 0; start < input.length(); start++) {
            Set<Character> visited = new HashSet<>();
            int end = start;
            for (; end < input.length(); end++) {
                char currChar = input.charAt(end);
                if (visited.contains(currChar)) {
                    break;
                } else {
                    visited.add(currChar);
                }
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end);
            }
        }
        return output.length();
    }

    public long[] solution(long n) {
        int[] fib = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811};

        long[] result = new long[(int) n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(fib[i])) {
                result[index] = fib[i];
                index++;
            }
        }

        long[] finalResult = new long[index];
        for (int i = 0; i < index; i++) {
            finalResult[i] = result[i];
        }

        return finalResult;
    }

    public boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    long[][] rotateCW(long[][] mat) {
        final int M = mat.length;
        final int N = mat[0].length;
        long[][] ret = new long[N][M];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                ret[c][M - 1 - r] = mat[r][c];
            }
        }
        return ret;
    }
}
