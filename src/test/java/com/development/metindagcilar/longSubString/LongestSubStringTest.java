package com.development.metindagcilar.longSubString;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubStringTest {

    LongestSubString problem = new LongestSubString();

    @Test
    void test1() {
        int nndNfdfdf = problem.value("nndNfdfdf");

        Assertions.assertThat(nndNfdfdf).isEqualTo(4);

    }

    @Test
    void test2() {
        long[] solution = problem.solution(6);
    }

    @Test
    void test3() {
        long[][] input = {{1, 2}, {3, 4}};
        long[][] expected = {{3, 1}, {4, 2}};
        problem.rotateCW(input);

    }

    @Test
    void test4() {

    }

    @Test
    void test5() {

    }


}