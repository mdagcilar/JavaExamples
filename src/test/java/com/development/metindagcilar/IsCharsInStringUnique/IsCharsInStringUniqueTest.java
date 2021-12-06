package com.development.metindagcilar.IsCharsInStringUnique;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IsCharsInStringUniqueTest {

    IsCharsInStringUnique isCharsInStringUnique = new IsCharsInStringUnique();

//    @ParameterizedTest(name = "with argument={0}")
//    @ValueSource(strings = {"abcdefg", "alwofjt"})
//    void isUnique(String input) {
//        Assertions.assertThat(isCharsInStringUnique.isCharsInString(input)).isTrue();
//    }
//
    @Test
    void isUnique() {
        org.junit.jupiter.api.Assertions.assertTrue(isCharsInStringUnique.isCharsInString("asc"));
        Assertions.assertThat(isCharsInStringUnique.isCharsInString("asc")).isTrue();
    }
    @Test
    void isNotUnique() {
        Assertions.assertThat(isCharsInStringUnique.isCharsInString("abba")).isFalse();
    }


//    @ParameterizedTest
//    @ValueSource(strings = {"abba", "asdfsadfaaa"})
//    void isNotUnique(String input) {
//        Assertions.assertThat(isCharsInStringUnique.isCharsInString(input)).isFalse();
//    }

}