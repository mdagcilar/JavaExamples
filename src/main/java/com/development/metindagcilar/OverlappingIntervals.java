package com.development.metindagcilar;

import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervals {

    public static List<Interval> mergeIntervals(List<Interval> A, List<Interval> B) {
        // Sort both lists based on the start date
        A.sort(Comparator.comparing(a -> a.startDate));
        B.sort(Comparator.comparing(a -> a.startDate));

        List<Interval> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.size() && j < B.size()) {
            Interval a = A.get(i);
            Interval b = B.get(j);

            // could probs get away with adding all of A immediately?

            // Check if intervals overlap
            if (!a.startDate.isAfter(b.endDate) && !b.startDate.isAfter(a.endDate)) {
                // Add interval from list A to mergedList
                mergedList.add(a);

                // Create a new interval to cover the gap in list B
                if (a.endDate.isBefore(b.endDate) && A.size() > (i + 1) && b.endDate.isAfter(A.get(i + 1).startDate)) {
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

    public static List<Interval> mergeIntervals2(List<Interval> A, List<Interval> B) {
        // Sort both lists based on the start date
        A.sort(Comparator.comparing(a -> a.startDate));
        B.sort(Comparator.comparing(a -> a.startDate));

        List<Interval> mergedList = new ArrayList<>(A); // Start with all of A's elements
        int i = 0, m = 0;

        while (i < B.size()) {
            Interval b = B.get(i);

            if (b.startDate.isBefore(mergedList.get(m).startDate)) {
                LocalDate endDate = b.endDate.isBefore(mergedList.get(m).startDate) ? b.endDate : mergedList.get(m).startDate.minusDays(1);
                Interval newInterval = new Interval(b.startDate, endDate);
                mergedList.add(newInterval);
                m++;
            } else if (b.endDate.isAfter(mergedList.get(m).endDate)) {
                if (mergedList.size() > (m + 1) && b.endDate.isAfter(mergedList.get(i + 1).startDate)) {
                    Interval newInterval = new Interval(mergedList.get(m).endDate.plusDays(1), mergedList.get(i + 1).startDate.minusDays(1));
                    mergedList.add(newInterval);
                    i++;
                } else {
                    Interval newInterval = new Interval(mergedList.get(m).endDate.plusDays(1), b.endDate);
                    mergedList.add(newInterval);
                    i++;
                }
            } else {
                i++;
            }
        }

        mergedList.sort(Comparator.comparing(a -> a.startDate));
        return mergedList;
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