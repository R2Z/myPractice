package test;

import scala.Int;

import java.util.*;

public class GraphTest {
    public static void main(String[] args) {
        int[][] comps = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        Graph g = new Graph(comps.length);
        for (int i = 0; i < comps.length; i++) {
            int[] edge = comps[i];
            g.addVertices(edge[0], edge[1]);
        }
        for (Map.Entry<Integer, List<Integer>> e : g.gph.entrySet()) {
            System.out.println("Edge " + e.getKey() + " Nodes " + e.getValue());
        }
        boolean[] visited = new boolean[g.gph.size()];
        DFS(g.gph, 5, visited);
        BFS(g.gph, 5);
        visited = new boolean[g.gph.size()];
        System.out.println("Distance " + findDistance(g.gph, 2, 1, visited));
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < g.gph.size(); i++) {
            int dist = 0;
            for (int j = 0; j < g.gph.size(); j++) {
                if (i != j) {
                    visited = new boolean[g.gph.size()];
                    found = false;
                    int dis = findDistance(g.gph, i, j, visited);
                    System.out.println("distance between " + i + " and " + j + " = " + dis);
                    dist += dis;
                }
            }
            System.out.println("--------------------------------------------------------");
            distances.add(dist);
        }
        System.out.println(distances);
    }

    static boolean found = false;
    private static int findDistance(Map<Integer, List<Integer>> gph, int src, int dst, boolean[] visited) {
        if (src == dst) {
            return 0;
        }
        int distance = 0;
        visited[src] = true;
        List<Integer> edges = gph.get(src);
        for (Integer e : edges) {
            if (!visited[e] && !found) {
                distance = 1 + findDistance(gph, e, dst, visited);
                 if (dst == e) {
                     found = true;
                }
            }
        }
        return distance;
    }

    private static void DFS(Map<Integer, List<Integer>> gph, int edge, boolean[] visited) {
        visited[edge] = true;
        System.out.println("--" + edge + "--");
        List<Integer> edges = gph.get(edge);
        for (Integer edg : edges) {
            if (!visited[edg]) {
                DFS(gph, edg, visited);
            }
        }
    }

    private static void BFS(Map<Integer, List<Integer>> gph, int edge) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[gph.size()];
        List<Integer> ans = new ArrayList<>();
        visited[edge] = true;
        queue.add(edge);
        while (!queue.isEmpty()) {
            int val = queue.poll();
            ans.add(val);
            List<Integer> edges = gph.get(val);
            for (Integer edg : edges) {
                if (!visited[edg]) {
                    visited[edg] = true;
                    queue.add(edg);
                }
            }
        }
        System.out.println("BFS o/p " + ans);
    }
}


class Graph {

    public Map<Integer, List<Integer>> gph;

    public Graph(int n) {
        gph = new HashMap<>(n);
    }

    public void addVertices(int src, int dst) {
        if (!gph.containsKey(src)) {
            gph.put(src, new ArrayList<>());
        }
        if (!gph.containsKey(dst)) {
            gph.put(dst, new ArrayList<>());
        }
        gph.get(src).add(dst);
        gph.get(dst).add(src);
    }
}