package trees;

import commons.Shuffle;

/**
 * Created by nikhandelwal on 2/1/2016.
 */
public class MirrorImageOfATree {


    public static void mirror(TreeNode root){

        if (root == null ) return;

        TreeNode temp = null;
        mirror(root.left);
        mirror(root.right);

        temp = root.left;
        root.left = root.right;
        root.right = temp;

    }

    public static void main(String [] args){

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

        mirror(bst.root);

        BTreePrinter.printNode(bst.root);
    }

}
