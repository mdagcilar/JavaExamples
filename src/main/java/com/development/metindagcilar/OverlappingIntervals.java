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

        for (Interval b : B) {
            boolean overlapsWithA = false;

            // Check against A intervals for overlap or inclusion
            for (Interval a : A) {
                if (b.endDate.isBefore(a.startDate)) {
                    // B is entirely before A and can be added directly
                    result.add(new Interval(b.startDate, b.endDate));
                    overlapsWithA = true;
                    break; // Exit after adding B as it doesn't overlap with any A
                } else if (b.overlaps(a)) {
                    // If B starts before A and overlaps, add the non-overlapping part
                    if (b.startDate.isBefore(a.startDate)) {
                        result.add(new Interval(b.startDate, a.startDate.minusDays(1)));
                    }

                    // If B ends after A, adjust B's end date to be compared to possibly another A
                    if (b.endDate.isAfter(a.endDate)) {
                        b = new Interval(a.endDate.plusDays(1), b.endDate);
                    } else {
                        // B or remainder of B is completely within A
                        overlapsWithA = true;
                        break;
                    }
                }
                // If B starts after A, check if there is another A to compare to
            }

            // If B does not overlap with any A, add it
            if (!overlapsWithA) {
                result.add(new Interval(b.startDate, b.endDate));
            }
        }

        // Add all A intervals to result, we can assume these are non-overlapping from the API validation
        result.addAll(A);

        //sort for ease of test assertions
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

}