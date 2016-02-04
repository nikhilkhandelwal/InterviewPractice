package trees;

import commons.Shuffle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nikhandelwal on 1/25/2016.
 */
public class LevelOrderTraversal {




    public static LinkedList<LinkedList<TreeNode>> levelOrderR(TreeNode root){

        LinkedList<LinkedList<TreeNode>> lists = new LinkedList<>();
        levelOrderRUtil(root, lists, 0);
        return lists;
    }

    public static void levelOrderRUtil(TreeNode root, LinkedList<LinkedList<TreeNode>> lists, int level){

        if(root == null) return;
        LinkedList<TreeNode> list;
        if(level == lists.size()){
            list = new LinkedList<>();
            lists.add(list);
        }

        list = lists.get(level);

        list.add(root);

        levelOrderRUtil(root.left, lists, level+1);
        levelOrderRUtil(root.right, lists, level+1);

    }
    public static LinkedList<LinkedList<TreeNode>> levelOrderNR(TreeNode root){

        LinkedList<LinkedList<TreeNode>> lists = new LinkedList<>();
        levelOrderNRUtil(root, lists);

        return lists;
    }


    public static void levelOrderNRUtil(TreeNode root, LinkedList<LinkedList<TreeNode>> lists){

        LinkedList<TreeNode> current = new LinkedList<>();
        current.add(root);
        lists.add(current);
        while(!current.isEmpty()){

            LinkedList<TreeNode> parent = current;

            current = new LinkedList<>();

            for(TreeNode n : parent){
                if(n.left!=null  )
                    current.add(n.left);
                if(n.right!=null  )
                    current.add(n.right);

            }

            lists.add(current);
        }
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
        LinkedList<LinkedList<TreeNode>> lists = levelOrderR(bst.root);

        int count  =0;
        for(LinkedList<TreeNode> list : lists){
            System.out.println("Level "+count+++" ");
            for(TreeNode n : list){
                System.out.print(n.data + ",");
            }
            System.out.println("");
        }
    }
}
