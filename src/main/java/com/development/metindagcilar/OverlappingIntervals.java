package com.development.metindagcilar;

import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OverlappingIntervals {

    public static List<Interval> mergeIntervals(List<Interval> A, List<Interval> B) {
        // Sort both lists based on the start date
        A.sort((a, b) -> a.startDate.compareTo(b.startDate));
        B.sort((a, b) -> a.startDate.compareTo(b.startDate));

        List<Interval> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.size() && j < B.size()) {
            Interval a = A.get(i);
            Interval b = B.get(j);

            // could probs get away with adding all of A immediately?

            // Check if intervals overlap
            if (a.startDate.compareTo(b.endDate) <= 0 && b.startDate.compareTo(a.endDate) <= 0) {
                // Add interval from list A to mergedList
                mergedList.add(a);

                // Create a new interval to cover the gap in list B
                if (isBefore(a, b) && A.size() > (i + 1) && isAfter(b, A.get(i + 1))) {
                    Interval newInterval = new Interval(a.endDate.plusDays(1), A.get(i + 1).startDate.minusDays(1));
                    mergedList.add(newInterval);
                } else {
                    mergedList.add(new Interval(a.endDate.plusDays(1), b.endDate));
                }

                i++;
                j++;
            } else {
                // Add interval from list A to mergedList
                mergedList.add(a);
                i++;
            }
        }

//        // Add remaining intervals from list B to mergedList
//        while (j < B.size()) {
//            mergedList.add(B.get(j));
//            j++;
//        }
//
        // Add remaining intervals from list A to mergedList
        while (i < A.size()) {
            mergedList.add(A.get(i));
            i++;
        }

        return mergedList;
    }

    private static boolean isAfter(Interval b, Interval a) {
        return b.endDate.compareTo(a.startDate) > 0;
    }

    private static boolean isBefore(Interval a, Interval b) {
        return a.endDate.compareTo(b.endDate) < 0;
    }

    @EqualsAndHashCode
    static class Interval {
        LocalDate startDate;
        LocalDate endDate;

        public Interval(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }
}