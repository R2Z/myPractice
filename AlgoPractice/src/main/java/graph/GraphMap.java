package graph;

import java.util.*;

public class GraphMap {
    // TreeSet is used to get clear understand of graph.
    public Map<Integer, Set<Integer>> graph;

    // Graph Constructor
    public GraphMap(int v) {
        graph = new HashMap<>();
        for (int i = 0; i < v; i++) {
            graph.put(i, new TreeSet<>());
        }
    }

    // Adds an edge to an undirected graph
    public void addEdge(int src, int dest) {
        // Add an edge from src to dest into the set
        graph.get(src).add(dest);
        // Since graph is undirected, add an edge
        // from dest to src into the set
        graph.get(dest).add(src);
    }

    // A utility function to print the graph
    public void printGraph() {
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            System.out.println("");
            System.out.print("Adjacency list of vertex " + entry.getKey() + " -> ");
            Set<Integer> adjacent = entry.getValue();
            for (Integer val : adjacent) {
                System.out.print(" " + val + " ");
            }
        }
    }

    // Searches for a given edge in the graph
    public void searchEdge(int src, int dest) {
        Iterator set = graph.get(src).iterator();

        if (graph.get(src).contains(dest))
            System.out.println("Edge from " + src + " to " +
                    dest + " found");
        else
            System.out.println("Edge from " + src + " to " +
                    dest + " not found");

        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {

        // Create the graph given in the above figure
        GraphMap graph = new GraphMap(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print the adjacency list representation of
        // the above graph
        graph.printGraph();

        // Search the given edge in the graph
        System.out.println(" ");
        graph.searchEdge(2, 1);
        graph.searchEdge(0, 3);
    }
}
