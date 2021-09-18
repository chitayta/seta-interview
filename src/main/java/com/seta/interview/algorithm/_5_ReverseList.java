package com.seta.interview.algorithm;

import com.seta.interview.algorithm.model.ListNode;

import java.util.Stack;

public class _5_ReverseList {
    private static ListNode lastNode;
    /**
     * Approach 1: reverse reference with recursive
     * Return last node
     */
    public static ListNode reverseReference(ListNode root) {
        reverseAndRetrieveLastNode(null, root);
        return lastNode;
    }

    private static void reverseAndRetrieveLastNode(ListNode previousNode, ListNode currentNode) {
        if (currentNode == null) {
            lastNode = previousNode;
            return;
        }
        reverseAndRetrieveLastNode(currentNode, currentNode.getNext());
        currentNode.setNext(previousNode);
    }

    /**
     * Approach 2: reverse using stack
     * Return last node
     */
    public static ListNode reverseUsingStack(ListNode root) {
        ListNode currentNode = root;
        Stack<ListNode> stack = new Stack<>();
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.getNext();
        }
        return createFrom(stack);
    }
    private static ListNode createFrom(Stack<ListNode> stack) {
        if (stack.isEmpty()) {
            return null;
        }
        return new ListNode(stack.pop().getVal(), createFrom(stack));
    }
}
