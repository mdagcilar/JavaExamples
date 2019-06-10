package com.development.metindagcilar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestDifferenceTest {

    SmallestDifference smallestDifference;

    @BeforeEach
    private void setup() {
        smallestDifference = new SmallestDifference();
    }

    @Test
    void findSmallestDifference() {
        int[] array1 = new int[]{1, 2, 11, 15};
        int[] array2 = new int[]{4, 12, 19, 23, 127, 235};
        int smallestDifference = this.smallestDifference.findSmallestDifference(array1, array2);

        assertThat(smallestDifference).isEqualTo(1);
    }
}