package misc;

import javax.xml.soap.Node;

public class Main {


    public static class Node {

        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;

    }

/*

    {?,5}
      0 /     \ 1
     {?,2}   {A,3}
    0/   \1
{B,1}  {C,1}

S="1001011"
 */

    public static void decode(String S, Node root) {

        for (int i = 0; i < S.length(); ) {
            Node currentNode = root;
            while (currentNode.left != null || currentNode.right != null) {
                if (S.charAt(i) == '0')
                    currentNode = currentNode.left;
                else if (S.charAt(i) == '1')
                    currentNode = currentNode.right;
                i++;
            }
            System.out.print(currentNode.data);
        }
    }

    public static void printTree(Node root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.println(root.data);
        printTree(root.right);
    }

    public static void main(String args[]) {
        Node root = new Node();
        root.frequency = 5;
        root.data = 'p';
        root.left = new Node();
        root.right = new Node();
        root.left.frequency = 2;
        root.right.frequency = 3;
        root.left.data = 'p';
        root.right.data = 'A';
        root.left.left = new Node();
        root.left.left.frequency = 1;
        root.left.left.data = 'B';

        root.left.right = new Node();
        root.left.right.frequency = 1;
        root.left.right.data = 'C';

        // printTree(root);

        decode("1001011", root);


    }

}
