package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by nikhandelwal on 12/28/2015.
 */
public class TopologicalSort {


    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List


    // A recursive function used by topologicalSort
    public static void topologicalSortUtil(Graph g, int v, Boolean visited[],Stack stack) {

        visited[v] = true;
       // System.out.println(v);

        for(int w: g.getAdjacentNodes(v)){
            if(!visited[w])
                topologicalSortUtil(g, w, visited, stack);
        }

        stack.push(v);
    }

    // The function to do Topological Sort. It uses recursive
    // topologicalSortUtil()
    public static Stack topologicalSort(Graph g) {

        Boolean visited [] = new Boolean[g.getV()];
        for (int i = 0; i < g.getV(); i++)
            visited[i] = false;
        Stack topologicalOrder = new Stack();
        for(int i =0; i< g.getV();i++){
            if(visited[i]==false){
                visited[i] = true;
                topologicalSortUtil(g,i, visited, topologicalOrder );
            }
        }
       return topologicalOrder;
    }

    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(8);
        g.addEdge(0, 4);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(1, 7);
        g.addEdge(2, 0);
        g.addEdge(5, 0);
        g.addEdge(3,6);

        System.out.println("Following is a Topological " +
                "sort of the given graph");

        //g.dfsFull(5, new boolean[g.getV()]);
        Stack order =topologicalSort(g);

        while(!order.isEmpty())
            System.out.println(order.pop());

        System.out.println("-------------");

        g.topologicalSort();

    }

}

