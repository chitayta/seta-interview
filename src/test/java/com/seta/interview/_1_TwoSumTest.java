package com.seta.interview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.seta.interview.algorithm._1_TwoSum.findPairNumber;
import static org.assertj.core.api.Assertions.assertThat;

public class _1_TwoSumTest {
    @Test
    void testTwoSum() {
        List<Integer> inputs = Arrays.asList(2, 7, 11, 15);

        assertThat(findPairNumber(inputs, 9)).containsExactlyInAnyOrder(2, 7);
        assertThat(findPairNumber(inputs, 22)).containsExactlyInAnyOrder(7, 15);
        assertThat(findPairNumber(inputs, 17)).containsExactlyInAnyOrder(15, 2);
        assertThat(findPairNumber(inputs, 8)).isEmpty();    // Not found
    }
}
