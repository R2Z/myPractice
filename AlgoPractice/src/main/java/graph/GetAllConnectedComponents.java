package graph;

import java.util.ArrayList;
import java.util.List;

// print all graphs with all edges
public class GetAllConnectedComponents {
    public static void main(String[] args) {
        int V = 7;
        GraphWithWeight graph = new GraphWithWeight(V);
        graph.addEdge(0, 1, 10);
        graph.addEdge(2, 3, 10);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 10);
        graph.addEdge(4, 6, 10);
        // Print the adjacency list representation of
        // the above graph
        //graph.printGraph();
        boolean[] visited = new boolean[V];
        List<List<Integer>> allComps = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            List<Integer> comp = new ArrayList<>();
            if (!visited[i]) {
                findAllComponents(graph, i, visited, comp);
                allComps.add(comp);
            }

        }
        System.out.println(allComps);
    }

    private static void findAllComponents(GraphWithWeight graph, int src,
                                          boolean[] visited, List<Integer> comp) {
        visited[src] = true;
        comp.add(src);
        List<GraphWithWeight.Edge> edgeList = graph.graph[src];
        for (GraphWithWeight.Edge e : edgeList) {
            if (!visited[e.nbr]) {
                findAllComponents(graph, e.nbr, visited, comp);
            }
        }
        // visited[src] = false;
    }

}
