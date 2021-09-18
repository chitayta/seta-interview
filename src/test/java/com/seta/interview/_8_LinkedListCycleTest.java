package com.seta.interview;

import com.seta.interview.algorithm.model.ListNode;
import org.junit.jupiter.api.Test;

import static com.seta.interview.algorithm._8_LinkedListCycle.isLinkedListCycle;
import static org.assertj.core.api.Assertions.assertThat;

public class _8_LinkedListCycleTest {

    @Test
    void testLinkedListCycle_FALSE() {
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        assertThat(isLinkedListCycle(node1)).isFalse();
    }

    @Test
    void testLinkedListCycle_TRUE() {
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node4.setNext(node2);

        assertThat(isLinkedListCycle(node1)).isTrue();
    }
}
