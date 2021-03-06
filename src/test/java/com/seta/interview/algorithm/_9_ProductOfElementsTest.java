package com.seta.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.seta.interview.algorithm._9_ProductOfElements.productOfElementsWithDivision;
import static com.seta.interview.algorithm._9_ProductOfElements.productOfElementsWithoutDivision;
import static org.assertj.core.api.Assertions.assertThat;

public class _9_ProductOfElementsTest {

    // Test the division approach
    @Test
    void testProductOfElements_WithDivisionApproach() {
        assertThat(
                productOfElementsWithDivision(Arrays.asList(1, 2, 3, 4))
        ).containsExactly(24, 12, 8, 6);

        assertThat(
                productOfElementsWithDivision(Arrays.asList(-1, 1, 0, -3, 3))
        ).containsExactly(0, 0, 9, 0, 0);
    }

    // Test the approach without division
    @Test
    void testProductOfElements_WithoutDivisionApproach() {
        assertThat(
                productOfElementsWithoutDivision(Arrays.asList(1, 2, 3, 4))
        ).containsExactly(24, 12, 8, 6);

        assertThat(
                productOfElementsWithoutDivision(Arrays.asList(-1, 1, 0, -3, 3))
        ).containsExactly(0, 0, 9, 0, 0);
    }
}
