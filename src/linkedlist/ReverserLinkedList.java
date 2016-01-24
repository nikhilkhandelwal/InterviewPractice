package linkedlist;

/**
 * Created by nikhandelwal on 12/15/2015.
 */
public class ReverserLinkedList {



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

    public static SimpleLinkedList reverseLL(SimpleLinkedList head){


        SimpleLinkedList prev = null;
        SimpleLinkedList current = head;
        SimpleLinkedList future = null;

        while(current != null){

            future = current.next;
            current.next = prev;
            prev = current;
            current = future;
        }

        return prev;
    }

    public static SimpleLinkedList recursiveReverseLL(SimpleLinkedList head){

        if( head == null || head.next == null){
            return head;
        }

        SimpleLinkedList remaining  = recursiveReverseLL(head.next);
        head.next.next = head;
        head.next = null;

        return remaining;

    }

    public static void main(String [] args){

        SimpleLinkedList head = createLL();
        printLL(head);
        printLL(recursiveReverseLL(head));

    }


}
