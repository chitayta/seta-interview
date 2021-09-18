package com.seta.interview.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class _2_LongestSubstring {

    public static String findLongestSubstring(String input) {
        List<Character> listCharacters = input.chars().mapToObj(value -> (char) value).collect(Collectors.toList());
        Iterator<Character> iterator = listCharacters.listIterator();
        List<Character> tempString = new ArrayList<>();
        tempString.add(iterator.next());
        String longestSubstring = "";
        while (iterator.hasNext()) {
            Character c = iterator.next();
            // if tempString contains c then remove from tempString all the characters from the beginning to c
            if (tempString.contains(c)) {
                int idx = tempString.indexOf(c);
                tempString = tempString.subList(idx + 1, tempString.size());
            }
            // add c to the tail of tempString for next processing
            tempString.add(c);
            // check if the tempString is the new longest candidate or not
            if (tempString.size() > longestSubstring.length()) {
                longestSubstring = tempString.stream().map(String::valueOf).collect(Collectors.joining());
            }
        }
        return longestSubstring;
    }

}
