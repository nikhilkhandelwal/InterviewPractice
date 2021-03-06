package linkedlist;

import java.util.LinkedList;


public class SwapAlternateNodes {

    private static void printLL(SimpleLinkedList node) {
        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println(node.val);
    }

    private static SimpleLinkedList createLL() {
        SimpleLinkedList head = new SimpleLinkedList(1);
        SimpleLinkedList node = head;
        for (int i = 2; i < 11; i++) {
            node.next = new SimpleLinkedList(i);
            node = node.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static SimpleLinkedList swapPairs(SimpleLinkedList head) {

        if ( head == null||head.next == null)
            return head;

        SimpleLinkedList temp = head.next;


        head.next = swapPairs(head.next.next);

        temp.next = head;

        return temp;


    }

    public static ListNode swapPairNRecursive(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode next;
        ListNode future;

        while (current.next != null && current.next.next != null) {
            next = current.next;
            future = current.next.next;
            current.next = future;
            next.next = future.next;
            future.next = next;
            current = next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {


        SimpleLinkedList head = createLL();
        printLL(head);
        printLL(swapPairs(head));



    }
}

