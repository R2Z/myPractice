package graph;

import java.util.List;
import java.util.PriorityQueue;

public class MultiSolver {
    public static void main(String[] args) {
        int V = 7;
        GraphWithWeight graph = new GraphWithWeight(V);
        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 10);
        graph.addEdge(0, 3, 40);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 3);
        graph.addEdge(5, 6, 3);
        graph.addEdge(4, 6, 8);
        // Print the adjacency list representation of
        // the above graph
        //graph.printGraph();
        boolean[] visited = new boolean[V];
        multiSolver(graph, 0, 6, "0", 0, visited, 40);
        System.out.println("sPath " + sPath + " swt " + swt);
        System.out.println("lPath " + lPath + " lwt " + lwt);
        System.out.println("cPAth " + cPAth + " cwt " + cwt);
        System.out.println("fPath " + fPath + " fwt " + fwt);
        System.out.println(" nwt " + pq.peek());
        //multiSolver(graph.graph);
    }

    static String sPath;
    static int swt = Integer.MAX_VALUE;
    static String lPath;
    static int lwt = Integer.MIN_VALUE;
    static String lPAth;
    static int cwt = Integer.MAX_VALUE;
    static String cPAth;
    static int fwt = Integer.MIN_VALUE;
    static String fPath;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(2);

    private static void multiSolver(GraphWithWeight g, int src, int dst, String path, int wt, boolean[] visited, int crtWt) {
        if (src == dst) {
            if (wt < swt) {
                swt = wt;
                sPath = path;
            }

            if (wt > lwt) {
                lwt = wt;
                lPath = path;
            }

            if (wt > crtWt && wt < cwt) {
                cwt = wt;
                cPAth = path;
            }

            if (wt < crtWt && wt > fwt) {
                fwt = wt;
                fPath = path;
            }

            if (wt > crtWt) {
                if (pq.size() == 2) {
                    if (pq.peek() < crtWt) {
                        pq.poll();
                    }
                }
                pq.add(wt);
            }
            return;
        }

        List<GraphWithWeight.Edge> edges = g.graph[src];
        visited[src] = true;
        for (GraphWithWeight.Edge e : edges) {
            if (!visited[e.nbr]) {
                multiSolver(g, e.nbr, dst, path + "-" + e.nbr, wt + e.wt, visited, crtWt);
            }
        }
        visited[src] = false;
    }

}
