package com.development.metindagcilar.java8.predicate;

import com.development.metindagcilar.java8.Person;

import java.util.function.BiPredicate;

public class BiPredicateTest {

    static boolean isPersonEligibleForVoting(
            Person person,
            Integer minAge,
            BiPredicate<Person, Integer> predicate) {
        return predicate.test(person, minAge);
    }

    public static void main(String args[]) {
        Person person = new Person("Alex", 23);

        boolean eligible = isPersonEligibleForVoting(
                person,
                18,
                (p, minAge) -> p.age > minAge);

        System.out.println("Person is eligible for voting: " + eligible);
    }
}

