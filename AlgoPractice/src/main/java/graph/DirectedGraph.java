package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph {
    public Map<Integer, Set<Integer>> graph;

    public DirectedGraph(int v) {
        graph = new HashMap<>(v);
    }

    public void addVertices(int src, int nbr) {
        Set<Integer> nbrs;
        if (graph.containsKey(src)) {
            nbrs = graph.get(src);
        } else {
            nbrs = new HashSet<>();
        }
        nbrs.add(nbr);
        graph.put(src, nbrs);
    }

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

}
