package com.development.metindagcilar;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OverlappingIntervalsTest {

    @Test
    void pyramidOfPrecedenceShouldSplitTempRegimeIntoTwoTest(){
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

    @Test
    void inversePyramidOfPrecedenceShouldIgnoreTempRegimeOverride(){
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
    void tempRegimeOverrideThatOverlapsSecondHalfOfSkuAndSiteOverrideTestShouldSplitSecondHalfOfTempRegimeOverride() {
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
    void tempRegimeOverrideThatOverlapsFirstHalfOfSkuAndSiteOverrideTestShouldSplitFirstHalfOfTempRegimeOverride(){
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(LocalDate.of(2024, 1, 5), LocalDate.of(2024, 1, 10)));

        List<Interval> B = new ArrayList<>();
        B.add(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 8)));

        List<Interval> mergedList = OverlappingIntervals.mergeIntervals2(A, B);

        for (Interval interval : mergedList) {
            System.out.println("{startDate = " + interval.startDate + ", endDate = " + interval.endDate + "}");
        }

        assertThat(mergedList.size()).isEqualTo(2);
        assertThat(mergedList.get(0)).isEqualTo(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 4)));
        assertThat(mergedList.get(1)).isEqualTo(new Interval(LocalDate.of(2024, 1, 5), LocalDate.of(2024, 1, 10)));
    }

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
    void tempRegimeOverrideThatOverlapsFirstHalfOfSkuAndSiteOverrideWithSucceedingSkuSiteOverridesWithSucceedingSkuSiteOverridesShouldSplit(){
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));
        A.add(new Interval(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 15)));
        A.add(new Interval(LocalDate.of(2024, 1, 16), LocalDate.of(2024, 1, 20)));

        List<Interval> B = new ArrayList<>();
        B.add(new Interval(LocalDate.of(2024, 1, 3), LocalDate.of(2024, 1, 8)));

        List<Interval> mergedList = OverlappingIntervals.mergeIntervals2(A, B);

        for (Interval interval : mergedList) {
            System.out.println("{startDate = " + interval.startDate + ", endDate = " + interval.endDate + "}");
        }

        assertThat(mergedList.size()).isEqualTo(4);
        assertThat(mergedList.get(0)).isEqualTo(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));
        assertThat(mergedList.get(1)).isEqualTo(new Interval(LocalDate.of(2024, 1, 6), LocalDate.of(2024, 1, 8)));
        assertThat(mergedList.get(2)).isEqualTo(new Interval(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 15)));
        assertThat(mergedList.get(3)).isEqualTo(new Interval(LocalDate.of(2024, 1, 16), LocalDate.of(2024, 1, 20)));
    }

    @Test
    void tempRegimeOverrideThatOverlapsFirstHalfOfTheSecondSkuAndSiteOverrideShouldSplit() {
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));
        A.add(new Interval(LocalDate.of(2024, 1, 6), LocalDate.of(2024, 1, 10)));
        A.add(new Interval(LocalDate.of(2024, 1, 20), LocalDate.of(2024, 1, 25)));

        List<Interval> B = new ArrayList<>();
        B.add(new Interval(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 13)));

        List<Interval> mergedList = OverlappingIntervals.mergeIntervals2(A, B);

        for (Interval interval : mergedList) {
            System.out.println("{startDate = " + interval.startDate + ", endDate = " + interval.endDate + "}");
        }

        assertThat(mergedList.size()).isEqualTo(4);
        assertThat(mergedList.get(0)).isEqualTo(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));
        assertThat(mergedList.get(1)).isEqualTo(new Interval(LocalDate.of(2024, 1, 6), LocalDate.of(2024, 1, 10)));
        assertThat(mergedList.get(2)).isEqualTo(new Interval(LocalDate.of(2024, 1, 11), LocalDate.of(2024, 1, 13)));
        assertThat(mergedList.get(3)).isEqualTo(new Interval(LocalDate.of(2024, 1, 20), LocalDate.of(2024, 1, 25)));
    }

    @Test
    void tempRegimeOverrideThatStartsOnBoundaryOfSkuAndSiteOverrideWithSucceedingSkuSiteOverridesWithSucceedingSkuSiteOverridesShouldAddOverride(){
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));
        A.add(new Interval(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 15)));

        List<Interval> B = new ArrayList<>();
        B.add(new Interval(LocalDate.of(2024, 1, 7), LocalDate.of(2024, 1, 12)));

        List<Interval> mergedList = OverlappingIntervals.mergeIntervals2(A, B);

        for (Interval interval : mergedList) {
            System.out.println("{startDate = " + interval.startDate + ", endDate = " + interval.endDate + "}");
        }

        assertThat(mergedList.size()).isEqualTo(3);
        assertThat(mergedList.get(0)).isEqualTo(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));
        assertThat(mergedList.get(1)).isEqualTo(new Interval(LocalDate.of(2024, 1, 7), LocalDate.of(2024, 1, 9)));
        assertThat(mergedList.get(2)).isEqualTo(new Interval(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 15)));
    }

    @Test
    void tempRegimeOverrideThatEndsOnBoundaryOfSkuSiteOverrideShouldAddOverride(){
        List<Interval> A = new ArrayList<>();
        A.add(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));
        A.add(new Interval(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 15)));

        List<Interval> B = new ArrayList<>();
        B.add(new Interval(LocalDate.of(2024, 1, 7), LocalDate.of(2024, 1, 10)));

        List<Interval> mergedList = OverlappingIntervals.mergeIntervals2(A, B);

        for (Interval interval : mergedList) {
            System.out.println("{startDate = " + interval.startDate + ", endDate = " + interval.endDate + "}");
        }

        assertThat(mergedList.size()).isEqualTo(3);
        assertThat(mergedList.get(0)).isEqualTo(new Interval(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 5)));
        assertThat(mergedList.get(1)).isEqualTo(new Interval(LocalDate.of(2024, 1, 7), LocalDate.of(2024, 1, 9)));
        assertThat(mergedList.get(2)).isEqualTo(new Interval(LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 15)));
    }

}