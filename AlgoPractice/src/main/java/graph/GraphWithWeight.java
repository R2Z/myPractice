package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphWithWeight {

    int V;
    List[] graph;

    public GraphWithWeight(int v) {
        V = v;
        graph = new List[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Integer>();
        }
    }

    // Adds an edge to an undirected graph
    public void addEdge(int src, int nbr, int wt) {

        Edge v1 = new Edge(src, nbr, wt);
        Edge v2 = new Edge(nbr, src, wt);

        // Add an edge from src to dest into the set
        graph[src].add(v1);
        // Since graph is undirected, add an edge
        // from dest to src into the set
        graph[nbr].add(v2);
    }

    // A utility function to print the graph
    public void printGraph() {
        for (List<Edge> edges : graph) {
            for (Edge val : edges) {
                System.out.println(val.toString());
            }
        }
    }

    static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", nbr=" + nbr +
                    ", wt=" + wt +
                    '}';
        }
    }

}
