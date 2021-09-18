package com.seta.interview.algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _3_IntegerToRoman {

    private static final Map<Integer, String> VALUES_MAP = new LinkedHashMap<>();

    static {
        VALUES_MAP.put(1000, "M");
        VALUES_MAP.put(900, "CM");
        VALUES_MAP.put(500, "D");
        VALUES_MAP.put(400, "CD");
        VALUES_MAP.put(100, "C");
        VALUES_MAP.put(90, "XC");
        VALUES_MAP.put(50, "L");
        VALUES_MAP.put(40, "XL");
        VALUES_MAP.put(10, "X");
        VALUES_MAP.put(9, "IX");
        VALUES_MAP.put(5, "V");
        VALUES_MAP.put(4, "IV");
        VALUES_MAP.put(1, "I");
    }


    public static String toRomanFrom(Integer input) {
        StringBuilder resultBuilder = new StringBuilder();
        Set<Map.Entry<Integer, String>> valuesEntries = VALUES_MAP.entrySet();
        for (Map.Entry<Integer, String> processingEntry : valuesEntries) {
            if (input < processingEntry.getKey()) {
                continue;
            }
            int quantity = (int) Math.floor(input * 1.0 / processingEntry.getKey());
            // Append the Roman characters
            resultBuilder.append(
                    Stream.generate(processingEntry::getValue).limit(quantity).collect(Collectors.joining())
            );
            input = input % processingEntry.getKey();
        }
        return resultBuilder.toString();
    }
}
