package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AllNodesKDistance {

    public static void main(String[] args) {
        //Integer arr[] = {1, 2, 3};
        //Integer arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        Integer arr[] = {1, 2, 3, 4, 5, 6};
        //Integer arr[] = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        int distance = 2;
        Node root = insertLevelOrder(arr, 0);
        printLevelOrder(root);
        System.out.println();
        /*List<Node> list = new ArrayList<>();
        if (findAllNodes(root, 5, list)) {
            for (int i = 0; i < list.size(); i++) {
                printKLevelDown(list.get(i), distance - i, i == 0 ? null : list.get(i - 1));
            }
        }
        printRootToLeafWithGivenSum(root, "", 0, 6, 20);*/
        //Node n = transformToLeftCloned(root);
        //preOrder(n);
        //System.out.println("Diameter of tree " + diameterOfTree(root));
        //System.out.println("Diameter of tree " + diameterPair(root).dia);
        TiltPair p = new TiltPair();
        tiltOfTree(root, p);
        System.out.println("Tilt " + p.tilt);
    }

    private static int tiltOfTree(Node node, TiltPair tilt) {

        if (node == null) {
            return 0;
        }

        int lsum = tiltOfTree(node.left, tilt);
        int rsum = tiltOfTree(node.right, tilt);

        tilt.tilt += Math.abs(lsum - rsum);
        int sum = lsum + rsum + node.data;

        return sum;
    }

    private static class TiltPair {
        int tilt;
    }

    private static int diameterOfTree(Node node) {

        if (node == null) {
            return 0;
        }
        // Left Diameter
        int leftTreeDia = diameterOfTree(node.left);
        int rightTreeDia = diameterOfTree(node.right);
        // Diameter passing through Root Node
        int diaRoot = heightOfTree(node.left) + heightOfTree(node.right) + 2;
        // Max of ((LHT + RHT +2), LD, RD)
        return Integer.max(diaRoot, Integer.max(leftTreeDia, rightTreeDia));
    }

    static class Pair {
        int dia;
        int hgt;
    }

    private static Pair diameterPair(Node node) {

        if (node == null) {
            Pair p = new Pair();
            p.hgt = -1;
            p.dia = 0;
            return p;
        }
        Pair leftPair = diameterPair(node.left);
        Pair rightPair = diameterPair(node.right);

        int rootDia = leftPair.hgt + rightPair.hgt + 2;
        int dia = Integer.max(rootDia, Integer.max(leftPair.dia, rightPair.dia));

        Pair p = new Pair();
        p.dia = dia;
        p.hgt = Integer.max(leftPair.hgt, rightPair.hgt) + 1;
        return p;
    }

    private static int heightOfTree(Node root) {

        if (root == null) {
            return -1;
        }
        int height = Integer.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
        return height;
    }

    private static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + "->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private static Node transformToLeftCloned(Node node) {

        if (node == null) {
            return null;
        }


        Node left = transformToLeftCloned(node.left);
        Node right = transformToLeftCloned(node.right);

        Node newNode = new Node(node.data, left, null);
        node.left = newNode;
        node.right = right;

        return node;

    }

    private static void printRootToLeafWithGivenSum(Node node, String path, int sum, int low, int high) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            sum += sum + (node.data == null ? 0 : node.data);
            if (sum > low && sum < high) {
                System.out.println(path + "-" + node.data);
            }

        }
        printRootToLeafWithGivenSum(node.left, path + "-" + node.data, sum + (node.data == null ? 0 : node.data), high, low);
        printRootToLeafWithGivenSum(node.right, path + "-" + node.data, sum + (node.data == null ? 0 : node.data), high, low);
    }

    private static void printKLevelDown(Node node, int k, Node block) {

        if (node == null || node.data == null || k < 0 || node == block)
            return;

        if (k == 0) {
            System.out.print(node.data + " ");
            return;
        }

        printKLevelDown(node.left, k - 1, block);
        printKLevelDown(node.right, k - 1, block);

    }

    private static boolean findAllNodes(Node node, int val, List<Node> list) {

        if (node == null) {
            return false;
        }

        if (node.data == val) {
            list.add(node);
            return true;
        }

        if (findAllNodes(node.left, val, list)) {
            list.add(node);
            return true;
        }

        if (findAllNodes(node.right, val, list)) {
            list.add(node);
            return true;
        }

        return false;
    }

    private static Node insertLevelOrder(Integer[] arr, int i) {
        Node root = null;
        if (i < arr.length) {
            root = new Node(arr[i], null, null);
            root.left = insertLevelOrder(arr, 2 * i + 1);
            root.right = insertLevelOrder(arr, 2 * i + 2);

        }
        return root;
    }

    private static void printLevelOrder(Node root) {
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        while (!que.isEmpty()) {
            Node nd = que.poll();
            System.out.print(nd.data + "->");

            if (nd.left != null)
                que.add(nd.left);
            if (nd.right != null)
                que.add(nd.right);
        }
    }

}


