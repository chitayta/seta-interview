package com.seta.interview.algorithm;

import org.junit.jupiter.api.Test;

import static com.seta.interview.algorithm._2_LongestSubstring.findLongestSubstring;
import static org.assertj.core.api.Assertions.assertThat;

public class _2_LongesSubstringTest {

    @Test
    void testLongestSubString() {
        assertThat(findLongestSubstring("abcabcbad")).isEqualTo("cbad");
        assertThat(findLongestSubstring("abcabcbb")).isEqualTo("abc");
        assertThat(findLongestSubstring("bbbbb")).isEqualTo("b");
        assertThat(findLongestSubstring("pwwkew")).isEqualTo("wke");
    }
}
