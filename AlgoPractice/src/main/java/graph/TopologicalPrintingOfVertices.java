package graph;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopologicalPrintingOfVertices {

    public static void main(String[] args) {
        int V = 7;
        DirectedGraph dir = new DirectedGraph(V);
        dir.addVertices(0, 1);
        dir.addVertices(0, 3);

        dir.addVertices(1, 2);
        dir.addVertices(2, 3);

        dir.addVertices(4, 3);
        dir.addVertices(4, 5);
        dir.addVertices(4, 6);
        dir.addVertices(5, 6);

        dir.printGraph();

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalOrdering(i, dir.graph, visited, stack);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    private static void topologicalOrdering(int v, Map<Integer, Set<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        if (graph.containsKey(v)) {
            Set<Integer> nbrs = graph.get(v);
            for (Integer nbr : nbrs) {
                if (!visited[nbr]) {
                    topologicalOrdering(nbr, graph, visited, stack);
                }
            }
        }
        stack.push(v);
    }

}
