package graphs;

/**
 * Created by nikhandelwal on 12/29/2015.
 */
// A Java program to print topological sorting of a DAG
import javax.naming.InsufficientResourcesException;
import java.util.*;

class Graph
{
    public int getV() {
        return V;
    }

    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    //Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) { adj[v].add(w); }

    LinkedList<Integer> getAdjacentNodes(int v){

        return adj[v];
    }

    void dfs(int v, boolean [] visited){

        visited[v] = true;
        System.out.println(v);

        for(int w: getAdjacentNodes(v)){
            if(!visited[w])
                dfs(w, visited);
        }
    }

    void dfsFull(int v, boolean [] visited){

        visited[v] = true;
        System.out.println(v);

        for(int i =0; i< getV();i++){
            if(!visited[i])
                dfs(i, visited);
        }
    }

    // A recursive function used by topologicalSort
    int topologicalSortUtil(int v, Boolean visited[],ArrayList<HashSet<Integer>> orderLists)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        int level = 0;
        int maxLevel = 0;
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
               level= topologicalSortUtil(i, visited, orderLists);
        }
        if(level > maxLevel ) {
            maxLevel = level;

        }
        if(maxLevel == orderLists.size()){
            HashSet<Integer> list = new HashSet<>();
            list.add(v);
            orderLists.add(list);
        }
        else
        {
            orderLists.get(maxLevel).add(v);
        }

        return maxLevel+1;
    }

    // The function to do Topological Sort. It uses recursive
    // topologicalSortUtil()
    void topologicalSort() {
        ArrayList<HashSet<Integer>> orderLists = new ArrayList<>();

        // Mark all the vertices as not visited
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive helper function to store Topological
        // Sort starting from all vertices one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, orderLists);

        int level=0;
        for(HashSet<Integer> list : orderLists){
            System.out.println("");
            System.out.println("Level: "+level++ );
            for (Integer i: list)
                System.out.print(i);
        }
    }

        // Print contents of stack


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
        g.topologicalSort();
    }
}
