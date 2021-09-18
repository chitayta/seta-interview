package com.seta.interview.algorithm;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class _9_ProductOfElements {

    /**
     * Find products of elements using division operation
     *
     * @param inputs
     * @return
     */
    public static List<Integer> productOfElementsWithDivision(List<Integer> inputs) {
        Integer productOfAll = inputs.stream()
                .filter(input -> input != 0)
                .reduce(1, (current, nextValue) -> current * nextValue);
        if (inputs.contains(0)) {
            return inputs.parallelStream().map(input -> input != 0 ? 0 : productOfAll).collect(Collectors.toList());
        }
        return inputs.parallelStream().map(input -> productOfAll / input).collect(Collectors.toList());
    }

    /**
     * Find products of elements WITHOUT using division operation
     *
     * @param inputs
     * @return
     */
    public static List<Integer> productOfElementsWithoutDivision(List<Integer> inputs) {
        //
        Map<Integer, Integer> mapInputs = inputs.stream()
                .collect(LinkedHashMap::new, (map, ch) -> map.put(map.size(), ch) , Map::putAll);
        Set<Map.Entry<Integer, Integer>> setEntries = mapInputs.entrySet();
        return setEntries.stream().map(entry ->
                setEntries.stream()
                        .filter(calculatedEntry -> !calculatedEntry.getKey().equals(entry.getKey()))
                        .map(Map.Entry::getValue)
                        .reduce(1, (currentProduct, nextValue) -> currentProduct * nextValue)
        ).collect(Collectors.toList());
    }
}
