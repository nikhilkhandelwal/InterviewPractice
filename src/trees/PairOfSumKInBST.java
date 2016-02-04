package trees;

import commons.Shuffle;

import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * Created by nikhandelwal on 1/27/2016.
 */
public class PairOfSumKInBST {


    public static boolean getPairofSumK(TreeNode root1, TreeNode root2, int k){

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root1);
        s2.push(root2);
        TreeNode temp1 = root1;
        TreeNode temp2 = root2;
        while(!(s1.isEmpty())&&!(s2.isEmpty())){

            while(temp1!=null){
                s1.push(temp1);
                temp1= temp1.left;

            }

            while(temp2!=null){
                s2.push(temp2);
                temp2= temp2.right;

            }

            TreeNode t1 = s1.peek();
            TreeNode t2 = s2.peek();

            System.out.println("s1 top : "+ s1.peek().data);
            System.out.println("s2 top : "+ s2.peek().data);

            if(t1.data+ t2.data == k)
                return true;
            else if(t1.data+ t2.data > k){
                temp2 = s2.pop();
                temp2 = temp2.left;
            }
            else{
                temp1 = s1.pop();
                temp1 = temp1.right;
            }
        }

        return false;
    }

    public static void main(String args[]){
        BinarySearchTree bst1 = new BinarySearchTree();

        bst1.insert(4);
        bst1.insert(3);
        bst1.insert(1);
        bst1.insert(5);
        bst1.insert(6);


        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.insert(1);
        bst2.insert(9);
        bst2.insert(2);
        bst2.insert(7);
        bst2.insert(5);

        BTreePrinter printer = new BTreePrinter();

        printer.printNode(bst1.root);
        printer.printNode(bst2.root);

        System.out.println(getPairofSumK(bst1.root, bst2.root, 13));

    }
}
