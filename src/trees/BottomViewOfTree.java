package trees;

import commons.Shuffle;

import java.util.*;

/**
 * Created by nikhandelwal on 1/27/2016.
 */
public class BottomViewOfTree {

    public static TreeMap<Integer, TreeNode> bottomViewTree(TreeNode root){


        return bottomViewUtil(root);


    }

    public static TreeMap<Integer, TreeNode> bottomViewUtil(TreeNode root) {

        LinkedList<Wrapper> current = new LinkedList<>();

        TreeMap<Integer, TreeNode> bottomView = new TreeMap<>();
         current.add(new Wrapper(root,1));
        while(!current.isEmpty()){

            LinkedList<Wrapper> parents = current;

            current = new LinkedList<>();

            for(Wrapper n : parents){
                if(n.node.left != null){
                    current.add(new Wrapper(n.node.left, n.level-1 ));
                }
                if(n.node.right != null){
                    current.add(new Wrapper(n.node.right, n.level+1 ));
                }

                bottomView.put(n.level, n.node);
            }

        }

        return bottomView;
    }

    private static class Wrapper{

        TreeNode node;
        int level;
        public Wrapper(TreeNode n, int level){

            this.node =n;
            this.level =level;
        }
    }

    public static void main(String args[]){
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

        Iterator it = bottomViewTree(bst.root).entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            System.out.print(((TreeNode)pair.getValue()).data + " ,");
        }
    }
}
