package com.development.metindagcilar.smallest.difference;

import java.util.Arrays;

public class SmallestDifference {

    public int findSmallestDifference(int[] array1, int[] array2) {
        if (array1.length == 0 || array2.length == 0) return -1;

        Arrays.sort(array1);
        Arrays.sort(array2);
        int a = 0, b = 0;
        int diff = Integer.MAX_VALUE;

        while (a < array1.length && b < array2.length) {
            int abs = Math.abs(array1[a] - array2[b]);
            if (abs < diff) {
                diff = abs;
            }

            // move to smaller value
            if (array1[a] < array2[b]) {
                a++;
            } else
                b++;
        }
        return diff;
    }
}
