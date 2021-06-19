package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class FindPath {
    public static void main(String[] args) {
        int V = 7;
        GraphMap graph = new GraphMap(V);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(4, 6);

        // Print the adjacency list representation of
        // the above graph
        //graph.printGraph();
        boolean[] visited = new boolean[V];
        System.out.println("");
        System.out.println("hasPath -> " + hasPath(graph, 0, 6, visited));

        Arrays.fill(visited, false);
        System.out.println("All paths");
        List<Integer> paths = new ArrayList<>();
        paths.add(0);
        printAllPaths(graph, 0, 6, visited, "0");

    }

    private static boolean hasPath(GraphMap map, int src, int dst, boolean[] visited) {
        if (src == dst) {
            return true;
        }

        Set<Integer> edges = map.graph.get(src);
        visited[src] = true;
        for (Integer v : edges) {
            if (!visited[v]) {
                if (hasPath(map, v, dst, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printAllPaths(GraphMap graph, int src, int dst, boolean[] visited, String path) {
        if (src == dst) {
            System.out.println(path);
            return;
        }

        Set<Integer> edges = graph.graph.get(src);
        visited[src] = true;
        for (Integer e : edges) {
            if (!visited[e]) {
                printAllPaths(graph, e, dst, visited, path + "-" + e);
            }
        }
        visited[src] = false;
    }
}
