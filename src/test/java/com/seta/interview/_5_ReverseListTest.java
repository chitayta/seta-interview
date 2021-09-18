package com.seta.interview;

import com.seta.interview.algorithm.model.ListNode;
import org.junit.jupiter.api.Test;

import static com.seta.interview.algorithm._5_ReverseList.reverseReference;
import static com.seta.interview.algorithm._5_ReverseList.reverseUsingStack;

public class _5_ReverseListTest {

    @Test
    void testReverseList() {
        // Approach 1: reverse reference
        ListNode root = new ListNode (1, new ListNode (2, new ListNode(3, null)));
        System.out.println(reverseReference(root));

        // Approach 2: reverse using stack
        ListNode root2 = new ListNode (1, new ListNode (2, new ListNode(3, null)));
        System.out.println(reverseUsingStack(root2));
    }
}
