package linkedlist;

public class ReverseInPair {


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

    public static SimpleLinkedList pairReverseLL(SimpleLinkedList head){


        return swapPairs(reverseLL(head));


    }


    public static SimpleLinkedList reverseLL(SimpleLinkedList head) {


        SimpleLinkedList prev = null;
        SimpleLinkedList curr = head;

        while (curr != null) {

            SimpleLinkedList temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }


        return prev;

    }
    public static SimpleLinkedList swapPairs(SimpleLinkedList head) {

        if ( head == null||head.next == null)
            return head;

        SimpleLinkedList temp = head.next;


        head.next = swapPairs(head.next.next);

        temp.next = head;

        return temp;


    }
    public static void main(String [] args){

        SimpleLinkedList head = createLL();
        printLL(head);
        printLL(pairReverseLL(head));

    }


}
