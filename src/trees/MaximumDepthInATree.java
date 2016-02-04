package trees;

import commons.Shuffle;

/**
 * Created by nikhandelwal on 2/1/2016.
 */
public class MaximumDepthInATree {

    public static int depth(TreeNode root){


        if(root == null){

            return 0;
        }

        int height = Math.max(depth(root.left) , depth(root.right)) +1 ;

        return height;

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

        System.out.println(depth(bst.root));
    }
}
