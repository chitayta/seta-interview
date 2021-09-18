package com.seta.interview;

import org.junit.jupiter.api.Test;

import static com.seta.interview.algorithm._3_IntegerToRoman.toRomanFrom;
import static org.assertj.core.api.Assertions.assertThat;

public class _3_StringToRomanTest {
    @Test
    void testStringToRoman() {
        assertThat(toRomanFrom(3)).isEqualTo("III");
        assertThat(toRomanFrom(4)).isEqualTo("IV");
        assertThat(toRomanFrom(9)).isEqualTo("IX");
        assertThat(toRomanFrom(58)).isEqualTo("LVIII");
        assertThat(toRomanFrom(1994)).isEqualTo("MCMXCIV");
    }
}
