package com.development.metindagcilar.java8.function;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        apply();
        andThen();
        compose();
    }

    private static void apply() {
        // Created a function which returns the length of string.
        Function<String, Integer> lengthFunction = String::length;

        System.out.println("String length: " + lengthFunction.apply("This is awesome!!"));
    }

    private static void andThen() {
        Function<Integer,Integer> increment = x -> x + 10;
        Function<Integer,Integer> multiply = y -> y * 2;
        // Since we are using andThen(), increment will be done first and then multiplication will be done.
        System.out.println("andThen result: " + increment.andThen(multiply).apply(3));
    }

    private static void compose() {
        // Function which adds 10 to the given element.
        Function<Integer, Integer> increment = x -> x + 10;
        // Function which doubles the given element.
        Function<Integer, Integer> multiply = y -> y * 2;
        // Since we are using compose(), multiplication will be done first and then increment will be done.
        System.out.println("compose result: " + increment.compose(multiply).apply(3));
    }
}