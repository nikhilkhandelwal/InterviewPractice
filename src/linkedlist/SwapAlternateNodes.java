package linkedlist;

/**
 * Created by nikhandelwal on 1/4/2016.
 */
public class SwapAlternateNodes {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode swapPairs(ListNode head) {

        if(head.next == null || head == null)
            return head ;
        ListNode node = head.next;
        head.next = swapPairs(head.next.next);
        node.next = head;
        return node;

    }

    public static ListNode swapPairNRecursive(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode next ;
        ListNode future;

        while(current.next!=null && current.next.next !=null){
            next = current.next;
            future = current.next.next;
            current.next = future;
            next.next = future.next;
            future.next = next;
            current = next;

        }
        return dummy.next;
    }

    public static void main(String [] args){

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
       l1.next.next = new ListNode(8);
        l1.next.next.next = new ListNode(7);
        l1.next.next.next.next = new ListNode(5);
        ListNode l3= swapPairNRecursive(l1);
        while (l3!=null){
            System.out.println(l3.val);
            l3=l3.next;
        }

    }
}

