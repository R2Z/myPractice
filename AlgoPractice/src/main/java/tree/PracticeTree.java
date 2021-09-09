package tree;

import java.util.ArrayList;
import java.util.List;

public class PracticeTree {

    public static void main(String[] args) {
        //Integer arr[] = {10, -2, 7, 8, -4};
        Integer arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        //Integer arr[] = {1, 2, 3, 4, 5, 6};
        Node root = TreeTraversal.insertLevelOrder(arr, 0);
        TreeTraversal.printLevelOrder(root);
        System.out.println();
        int val = 6;
        List<Node> rootToNode = new ArrayList<>();
        getRootToNodes(root, val, rootToNode);
        Node prevNode = null;
        int k = 0;
        for (Node node : rootToNode) {
            int height = BTHeight(node, prevNode);
            MAX_TIME = Integer.max(MAX_TIME, height + k);
            prevNode = node;
            k = k + 1;
        }
        System.out.println("MAX_TIME " + MAX_TIME);
    }

    private static int BTHeight(Node node, Node skNode) {

        if (node == null) {
            return 0;
        }

        int left = 0;
        int right = 0;

        if (node.left != skNode) {
            left = BTHeight(node.left, skNode);
        }

        if (node.left != skNode) {
            right = BTHeight(node.right, skNode);
        }

        return Integer.max(left, right) + 1;

    }


    static int MAX_TIME = Integer.MIN_VALUE;

    private static boolean getRootToNodes(Node node, int val, List<Node> result) {

        if (node == null) {
            return false;
        }

        if (node.data == val) {
            result.add(node);
            return true;
        }

        if (getRootToNodes(node.left, val, result)) {
            result.add(node);
            return true;
        }

        if (getRootToNodes(node.right, val, result)) {
            result.add(node);
            return true;
        }
        return false;
    }


}
