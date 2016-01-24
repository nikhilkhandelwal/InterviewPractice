package linkedlist;

/**
 * Created by nikhandelwal on 1/4/2016.
 */
public class AddTwoLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int val = 0;
        int carry = 0;
        ListNode result = null;
        ListNode prev = null;
        while (l1 != null && l2 != null) {
            val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            //System.out.println(val);
            //System.out.println(carry);
            if (prev == null) {
                ListNode current = new ListNode(val );
                //prev.next = result;
                prev = current;
                result = current;

            } else {
                ListNode current = new ListNode(val );
                prev.next = current;
                prev = current;
            }
            l1=l1.next;
            l2=l2.next;
        }
        if(l1!= null|| l2!=null) {
            ListNode left = (l2 == null) ? l1 : l2;
            while(left!=null){
                prev.next = new ListNode((left.val +carry)%10);
                carry = (left.val +carry)/10;
                left=left.next;
                prev=prev.next;
            }
        }

        if (carry > 0){
            //System.out.println("here");
            prev.next = new ListNode(carry);
        }
        return result;
    }

    public static void main(String [] args){

        ListNode l1 = new ListNode(1);
        //l1.next = new ListNode(9);
        //l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        //l2.next.next = new ListNode(9);
        ListNode l3= addTwoNumbers(l1,l2);
        while (l3!=null){
            System.out.println(l3.val);
            l3=l3.next;
        }

    }
}
