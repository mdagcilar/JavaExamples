package com.development.metindagcilar;

import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervals {

    public static List<Interval> mergeIntervals(List<Interval> A, List<Interval> B) {
        // start our result list with all of A, since they should not overlap (based on API validation we can assume this)
        List<Interval> result = new ArrayList<>(A);

        for (Interval b : B) {
            boolean isBAdded = false;

            for (Interval a : A) {
                // if B is before A, then break early and add B
                if (b.endDate.isBefore(a.startDate)) {
                    result.add(new Interval(b.startDate, b.endDate));
                    isBAdded = true;
                    break;
                }
                if (b.overlaps(a)) {
                    // If B starts before A and overlaps, add the non-overlapping part
                    if (b.startDate.isBefore(a.startDate)) {
                        result.add(new Interval(b.startDate, a.startDate.minusDays(1)));
                    }

                    // If B ends after A, adjust B's end date to be compared to possibly another A
                    if (b.endDate.isAfter(a.endDate)) {
                        b = new Interval(a.endDate.plusDays(1), b.endDate);
                    } else {
                        // B or remainder of B is completely within A
                        isBAdded = true;
                        break;
                    }
                }
            }

            // If B does not overlap with any A, add it
            if (!isBAdded) {
                result.add(new Interval(b.startDate, b.endDate));
            }
        }

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

    public boolean overlaps(Interval other) {
        return !this.endDate.isBefore(other.startDate) && !this.startDate.isAfter(other.endDate);
    }

}