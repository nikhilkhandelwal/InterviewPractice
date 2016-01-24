package trees;

import commons.Shuffle;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by nikhandelwal on 12/22/2015.
 */
public class RightViewofBTree {

    public static int maxLevel=0;

    public static void printRightViewBTDFS(TreeNode root, int level){

        if(root == null)
            return ;

        if(level == maxLevel){
            System.out.println(root.data);
            maxLevel++;
        }

        printRightViewBTDFS(root.right, level + 1);
        printRightViewBTDFS(root.left, level + 1);

    }


    public static LinkedList<Integer> printRightViewBTBFS(TreeNode root){


        LinkedList<TreeNode> current = new LinkedList<>();
       // LinkedList<Integer> result = new LinkedList<>();
        current.add(root);
        while(!current.isEmpty()){

           // result.add(current.getFirst().data);
            System.out.println(current.getFirst().data);
            LinkedList<TreeNode> parents  = current;
            current = new LinkedList<>();
            ListIterator<TreeNode> it = parents.listIterator();
            while(it.hasNext()){

                TreeNode n = it.next();
                if(n.right!=null){
                    current.add(n.right);
                }
                if(n.left!=null){
                    current.add(n.left);
                }
            }
        }
        return null;
    }
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
        printRightViewBTBFS(bst.root);


    }


}
