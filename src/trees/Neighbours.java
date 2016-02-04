package trees;

import commons.Shuffle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nikhandelwal on 1/25/2016.
 */
public class Neighbours {


        public static HashMap<Integer, Integer> findNeighbours(TreeNode root){

             /*   HashMap<Integer, Integer> neighbours = new HashMap<>();
                prev = root;

                findNeighboursUtil(root.left,1, neighbours);
                findNeighboursUtil(root.right,1, neighbours);

                return  neighbours;*/

                return  null;
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
                HashMap<Integer, Integer> neighbours = findNeighbours(bst.root);

                for(Integer i :  neighbours.keySet()){
                        System.out.println("Node: "+ i+" Neighbour: "+ neighbours.get(i));
                }

        }

}
