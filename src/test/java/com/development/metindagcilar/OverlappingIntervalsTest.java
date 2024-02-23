package com.development.metindagcilar;

import com.development.metindagcilar.OverlappingIntervals.Interval;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OverlappingIntervalsTest {

    @Test
    void tempRegimeOverrideThatOverlapsTwoSkuAndSiteOverridesTestShouldReduceTheTempRegimeOverrideWindow(){
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));
        A.add(new Interval(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 15)));

        List<Interval> B = new ArrayList<>();
        B.add(new Interval(LocalDate.of(2024, 1, 3), LocalDate.of(2024, 1, 12)));

        List<Interval> mergedList = OverlappingIntervals.mergeIntervals2(A, B);

        for (Interval interval : mergedList) {
            System.out.println("{startDate = " + interval.startDate + ", endDate = " + interval.endDate + "}");
        }

        assertThat(mergedList.size()).isEqualTo(3);
        assertThat(mergedList.get(0)).isEqualTo(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));
        assertThat(mergedList.get(1)).isEqualTo(new Interval(LocalDate.of(2024, 1, 06), LocalDate.of(2024, 1, 9)));
        assertThat(mergedList.get(2)).isEqualTo(new Interval(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 15)));
    }


    @Test
    void tempRegimeOverrideThatOverlapsSecondHalfOfSkuAndSiteOverrideTestShouldSplitSecondHalfOfTempRegimeOverride(){
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));

        List<Interval> B = new ArrayList<>();
        B.add(new Interval(LocalDate.of(2024, 1, 3), LocalDate.of(2024, 1, 12)));

        List<Interval> mergedList = OverlappingIntervals.mergeIntervals2(A, B);

        for (Interval interval : mergedList) {
            System.out.println("{startDate = " + interval.startDate + ", endDate = " + interval.endDate + "}");
        }

        assertThat(mergedList.size()).isEqualTo(2);
        assertThat(mergedList.get(0)).isEqualTo(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));
        assertThat(mergedList.get(1)).isEqualTo(new Interval(LocalDate.of(2024, 1, 6), LocalDate.of(2024, 1, 12)));
    }

    @Test
    void tempRegimeOverrideWhichIsCompletelyCoveredBySkuSiteOverrideShouldBeIgnored(){
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 15)));

        List<Interval> B = new ArrayList<>();
        B.add(new Interval(LocalDate.of(2024, 1, 3), LocalDate.of(2024, 1, 12)));

        List<Interval> mergedList = OverlappingIntervals.mergeIntervals2(A, B);

        for (Interval interval : mergedList) {
            System.out.println("{startDate = " + interval.startDate + ", endDate = " + interval.endDate + "}");
        }

        assertThat(mergedList.size()).isEqualTo(1);
        assertThat(mergedList.get(0)).isEqualTo(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 15)));
    }


    @Test
    void pyramidOfPrecedenceTest(){
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(LocalDate.of(2024, 1, 5), LocalDate.of(2024, 1, 10)));

        List<Interval> B = new ArrayList<>();
        B.add(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 15)));

        List<Interval> mergedList = OverlappingIntervals.mergeIntervals2(A, B);

        for (Interval interval : mergedList) {
            System.out.println("{startDate = " + interval.startDate + ", endDate = " + interval.endDate + "}");
        }

        assertThat(mergedList.size()).isEqualTo(3);
        assertThat(mergedList.get(0)).isEqualTo(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 4)));
        assertThat(mergedList.get(1)).isEqualTo(new Interval(LocalDate.of(2024, 1, 5), LocalDate.of(2024, 1, 10)));
        assertThat(mergedList.get(2)).isEqualTo(new Interval(LocalDate.of(2024, 1, 11), LocalDate.of(2024, 1, 15)));
    }


}