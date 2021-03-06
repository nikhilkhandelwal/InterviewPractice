package trees;

import commons.Shuffle;

import java.util.Stack;

/**
 * Created by nikhandelwal on 12/22/2015.
 */

public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean find(int id) {
        TreeNode current = root;
        while (current != null) {
            if (current.data == id) {
                return true;
            } else if (current.data > id) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeftChild = false;
        while (current.data != id) {
            parent = current;
            if (current.data > id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        //if i am here that means we have found the TreeNode
        //Case 1: if TreeNode to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //Case 2 : if TreeNode to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            //now we have found the minimum element in the right sub tree
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public TreeNode getSuccessor(TreeNode deleleTreeNode) {
        TreeNode successsor = null;
        TreeNode successsorParent = null;
        TreeNode current = deleleTreeNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if (successsor != deleleTreeNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleTreeNode.right;
        }
        return successsor;
    }

    public void insert(int id) {
        TreeNode newTreeNode = new TreeNode(id);
        if (root == null) {
            root = newTreeNode;
            return;
        }
        TreeNode current = root;
        TreeNode parent;
        while (true) {
            parent = current;
            if (id < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newTreeNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newTreeNode;
                    return;
                }
            }
        }
    }

    public void display(TreeNode root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    public void displayNRecursive(TreeNode root) {


        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.data);
            cur = cur.right;
        }

    }

    public static void main(String arg[]) {
        BinarySearchTree b = new BinarySearchTree();
//        b.insert(3);
//        b.insert(8);
//        b.insert(1);
//        b.insert(4);
//        b.insert(6);
//        b.insert(2);
//        b.insert(10);
//        b.insert(9);
//        b.insert(20);
//        b.insert(25);
//        b.insert(15);
//        b.insert(16);
//        System.out.println("Original Tree : ");
//        b.display(b.root);

        Integer a[] = new Integer[10];
        for (int i = 9; i >= 0; i--) {
            a[i] = i;
        }
        Shuffle.shuffleArray(a);
        for (int x : a) {
            b.insert(x);
        }
        BTreePrinter printer = new BTreePrinter();

        printer.printNode(b.root);
        System.out.println("");
        System.out.println("Check whether TreeNode with value 4 exists : " + b.find(4));
        System.out.println("Delete TreeNode with no children (2) : " + b.delete(2));



    }


}