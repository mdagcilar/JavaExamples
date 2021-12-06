package com.development.metindagcilar.IsCharsInStringUnique;

import java.util.HashSet;
import java.util.Set;

public class IsCharsInStringUnique {

    public boolean isCharsInString(String inputString) {
        char[] chars = inputString.toCharArray();

        Set<Character> charsSet = new HashSet<>();
        for (char c : chars) {
            charsSet.add(c);
        }

        return charsSet.size() == inputString.length();
    }
}
