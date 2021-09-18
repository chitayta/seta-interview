package com.seta.interview.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class _1_TwoSum {

    public static List<Integer> findPairNumber(List<Integer> numbers, int target) {
        Map<Integer, Integer> mapInputs = numbers.stream().collect(Collectors.toMap(Integer::intValue, Integer::intValue));
        for (Integer input : numbers) {
            // Find in the map if any key is the complement for the `input` then return
            Optional<Map.Entry<Integer, Integer>> matchNumber =
                    mapInputs.entrySet().stream().filter(entry -> (input + entry.getKey()) == target).findFirst();
            if (matchNumber.isPresent()) {
                return Arrays.asList(input, matchNumber.get().getKey());
            }
        }
        return Collections.emptyList();
    }
}
