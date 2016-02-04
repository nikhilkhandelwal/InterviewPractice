package trees;

import commons.Shuffle;

/**
 * Created by nikhandelwal on 2/2/2016.
 */
public class ConvertBSTToBT {

    public static int max = 0;
    public static void convertBSTToBT(TreeNode root){

        if(root == null) return;

        convertBSTToBT(root.right);
        int temp = root.data;
        root.data = max;
        max += temp;
        convertBSTToBT(root.left);

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

        convertBSTToBT(bst.root);

        BTreePrinter.printNode(bst.root);
    }
}
