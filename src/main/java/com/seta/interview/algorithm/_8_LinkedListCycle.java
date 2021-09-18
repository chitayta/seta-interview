package com.seta.interview.algorithm;

import com.seta.interview.algorithm.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class _8_LinkedListCycle {

    public static boolean isLinkedListCycle(ListNode root) {
        List<ListNode> traversed = new ArrayList<>();
        ListNode processing = root;
        while (processing != null) {
            traversed.add(processing);
            if (traversed.contains(processing.getNext())) {
                return true;
            }
            processing = processing.getNext();
        }
        return false;
    }
}
