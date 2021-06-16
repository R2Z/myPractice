package graph;

import java.util.*;

public class BFSOnGraph {

    public static void main(String[] args) {

        int V = 5;
        GraphMap graph = new GraphMap(V);
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
        System.out.println("");

        boolean[] visited = new boolean[V];
        BFS(0, graph.graph, visited);
        visited = new boolean[V];
        DFS(0, graph.graph, visited);

    }

    private static void DFS(int edge, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        visited[edge] = true;
        System.out.print(" " + edge + " ");
        Set<Integer> adj = graph.get(edge);
        for (Integer val : adj) {
            if (!visited[val]) {
                DFS(val, graph, visited);
            }
        }
    }

    private static void BFS(int edge, Map<Integer, Set<Integer>> graph, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> bfs = new ArrayList<>();
        visited[edge] = true;
        queue.add(edge);

        while (!queue.isEmpty()) {
            int val = queue.poll();
            bfs.add(val);
            Set<Integer> adj = graph.get(val);
            for (int e : adj) {
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                }
            }
        }
        System.out.println(bfs);
    }

}
