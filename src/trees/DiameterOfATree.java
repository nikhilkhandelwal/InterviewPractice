package trees;

import commons.Shuffle;

/**
 * Created by nikhandelwal on 1/11/2016.
 */
public class DiameterOfATree {


    public static int maxDiameter=Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Integer a[] = new Integer[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i + 1;
        }
        Shuffle.shuffleArray(a);
        for (int x : a) {
            bst.insert(x);
        }

        BTreePrinter.printNode(bst.root);
        //printRightViewBTDFS(bst.root, 0);
        daimeterOfATree(bst.root);

        System.out.println(maxDiameter);


    }

    private static int daimeterOfATree(TreeNode root) {

        if(root == null) return 0;

        int leftHeight = daimeterOfATree(root.left) ;
        int rightHeight= daimeterOfATree(root.right);

        int height = Math.max(leftHeight, rightHeight) +1;
        int diameter = leftHeight + rightHeight +1;
        if(diameter > maxDiameter)
            maxDiameter =diameter;

        return height;
    }
}
