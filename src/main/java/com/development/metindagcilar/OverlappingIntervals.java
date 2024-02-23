package com.development.metindagcilar;

import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervals {

//    public static List<Interval> mergeIntervals(List<Interval> A, List<Interval> B) {
//        // Sort both lists based on the start date
//        A.sort(Comparator.comparing(a -> a.startDate));
//        B.sort(Comparator.comparing(a -> a.startDate));
//
//        List<Interval> mergedList = new ArrayList<>();
//        int i = 0, j = 0;
//
//        while (i < A.size() && j < B.size()) {
//            Interval a = A.get(i);
//            Interval b = B.get(j);
//
//            // could probs get away with adding all of A immediately?
//
//            // Check if intervals overlap
//            if (!a.startDate.isAfter(b.endDate) && !b.startDate.isAfter(a.endDate)) {
//                // Add interval from list A to mergedList
//                mergedList.add(a);
//
//                // Create a new interval to cover the gap in list B
//                if (a.endDate.isBefore(b.endDate) && hasSucceedingInterval(A, i) && b.endDate.isAfter(A.get(i + 1).startDate)) {
//                    Interval newInterval = new Interval(a.endDate.plusDays(1), A.get(i + 1).startDate.minusDays(1));
//                    mergedList.add(newInterval);
//                } else {
//                    mergedList.add(new Interval(a.endDate.plusDays(1), b.endDate));
//                }
//
//                i++;
//                j++;
//            } else {
//                // Add interval from list A to mergedList
//                mergedList.add(a);
//                i++;
//            }
//        }
//
////        // Add remaining intervals from list B to mergedList
////        while (j < B.size()) {
////            mergedList.add(B.get(j));
////            j++;
////        }
////
//        // Add remaining intervals from list A to mergedList
//        while (i < A.size()) {
//            mergedList.add(A.get(i));
//            i++;
//        }
//
//        return mergedList;
//    }

    public static List<Interval> mergeIntervals2(List<Interval> A, List<Interval> B) {
        List<Interval> result = new ArrayList<>();

        // Process each interval in B
        for (Interval b : B) {
            boolean isAdded = false;

            for (int i = 0; i < A.size() && !isAdded; i++) {
                Interval a = A.get(i);

                // If b is entirely before a, add b and break
                if (b.endDate.isBefore(a.startDate)) {
                    result.add(new Interval(b.startDate, b.endDate));
                    isAdded = true;
                    break;
                }

                // If b starts before a and b ends after start of a, split b into the part before a
                if (b.startDate.isBefore(a.startDate) && b.endDate.isAfter(a.startDate)) {
                    result.add(new Interval(b.startDate, a.startDate.minusDays(1)));
                    if (b.endDate.isBefore(a.endDate)) {
                        isAdded = true;
                    }
                    b.startDate = a.endDate.plusDays(1); // Adjust b to start after a
                }

                // If b is completely within a, skip b
                if (b.isWithin(a)) {
                    isAdded = true; // b is skipped
                    break;
                }

                // If b starts within a and ends after a, adjust b to start after a
                if (!b.startDate.isBefore(a.startDate) && b.endDate.isAfter(a.endDate)) {
                    b.startDate = a.endDate.plusDays(1);
                }

                // If b starts after a, check against the next interval in A
            }

            // If b was not added and is not overlapping or within any A intervals, add it
            if (!isAdded) {
                result.add(new Interval(b.startDate, b.endDate));
            }
        }

        // Add all A intervals to result
        result.addAll(A);

        // Sort the result based on the start date
        result.sort(Comparator.comparing(interval -> interval.startDate));

        return result;
    }
}

@EqualsAndHashCode
class Interval {
    LocalDate startDate;
    LocalDate endDate;

    public Interval(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Method to check if this interval overlaps with another interval
    public boolean overlaps(Interval other) {
        return !this.endDate.isBefore(other.startDate) && !this.startDate.isAfter(other.endDate);
    }

    // Checks if this interval is completely within another interval
    public boolean isWithin(Interval other) {
        return !this.startDate.isBefore(other.startDate) && !this.endDate.isAfter(other.endDate);
    }

    // Getters and setters
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}