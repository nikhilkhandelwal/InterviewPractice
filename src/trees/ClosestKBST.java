package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by nikhandelwal on 12/3/2015.
 */
public class ClosestKBST {


    public static List<Integer> closestKBST(TreeNode root, int target, int k){
        List<Integer> res = new ArrayList<>();
        Stack<Integer> successors = new Stack<>();
        Stack<Integer> predecessors = new Stack<>();

        inorderTraversal(root, false, 3.8, successors);
        inorderTraversal(root, true, 3.8, predecessors);

        while(k-- >0){
            if(successors.isEmpty())
                res.add(predecessors.pop());
            else if(predecessors.isEmpty())
                res.add(successors.pop());
            else if (Math.abs(predecessors.peek() - target) < Math.abs(successors.peek() - target))
                res.add(predecessors.pop());
            else
                res.add(successors.pop());

        }
        return res;
    }

    public static void inorderTraversal(TreeNode root, boolean isReverse, double target, Stack<Integer> stack){

        if (root == null) return;

        inorderTraversal(isReverse ? root.right:root.left, isReverse, target, stack);

        if ((isReverse && root.value <= target) || (!isReverse && root.value > target)) return;

        stack.push(root.value);

        inorderTraversal(isReverse ? root.left:root.right, isReverse, target, stack);

    }

    public static void main(String args[]) {
    }


    private class TreeNode{

        int value;
        TreeNode left;
        TreeNode right;


    }
}
