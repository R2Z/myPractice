package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Hamiltonian Path -> visits every vertex in graph exactly once
// A traceable graph is graph that contains Hamiltonian Path
// Hamiltonian cycle has start - end node edges
public class HamiltonianPathAndCycle {
    public static void main(String[] args) {
        int V = 7;
        GraphWithWeight g = new GraphWithWeight(V);
        g.addEdge(0, 1, 10);
        g.addEdge(1, 2, 10);
        g.addEdge(2, 3, 10);
        g.addEdge(2, 5, 10);
        g.addEdge(0, 3, 40);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 5, 3);
        g.addEdge(5, 6, 3);
        g.addEdge(4, 6, 8);

        Set<Integer> visited = new HashSet<>();
        printHamiltonianPaths(g, visited, 0, 0, 0 + "");
    }

    private static void printHamiltonianPaths(GraphWithWeight g, Set<Integer> visited, int v, int originalVertex, String psf) {

        if (g.graph.length - 1 == visited.size()) {
            boolean isCycle = false;
            List<GraphWithWeight.Edge> list = g.graph[v];
            //Hamiltonian cycle has start - end node edges
            for (GraphWithWeight.Edge e : list) {
                if (e.nbr == originalVertex) {
                    isCycle = true;
                }
            }
            if (isCycle) {
                System.out.println("psf " + psf + "*");
            } else {
                System.out.println("psf " + psf + ".");
            }
        }

        visited.add(v);
        List<GraphWithWeight.Edge> list = g.graph[v];
        for (GraphWithWeight.Edge e : list) {
            if (!visited.contains(e.nbr)) {
                printHamiltonianPaths(g, visited, e.nbr, originalVertex, psf + "-" + e.nbr);
            }
        }
        visited.remove(v);
    }
}
