package graphs;

import java.util.LinkedList;

/**
 * Created by nikhandelwal on 12/29/2015.
 */
public class GraphTemp {

    LinkedList<Integer> adj[] ;
    int noOfVertices;

    GraphTemp(int v){

        noOfVertices = v;
        adj = new LinkedList[v];
        for (int i =0; i< v; i++){

            adj[i] = new LinkedList<Integer>();
        }
    }

    void dfs(int v, boolean [] visited){

        visited[v] = true;
        System.out.println(v);

        for(int w: getAdjacentNodes(v)){
            if(!visited[w])
                dfs(w, visited);
        }
    }
    void addEdge(int v, int w){

        adj[v].add(w);
    }

     LinkedList<Integer> getAdjacentNodes(int v){

        return adj[v];
    }
    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        GraphTemp g = new GraphTemp(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(5,1);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        //g.addEdge(3, 1);
        g.dfs(5, new boolean[g.noOfVertices]);


        System.out.println("Following is a Topological " +
                "sort of the given graph");
        //g.topologicalSort();

    }
}
