package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CheckBST {

    public static void main(String[] args) {
        //Integer arr[] = {1, 2, 3};
        //Integer arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        Integer arr[] = {1, 2, 3, 4, 5, 6};
        //Integer arr[] = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Node root = insertLevelOrder(arr, 0);
        printLevelOrder(root);
        /*System.out.println();
        System.out.println("isBST " + isBST(root).isBST);
        System.out.println("isBalanced " + isBalanced(root).isBalanced);
        MaxSubTreeBst bst = getMaxSubTreeBst(root);
        System.out.println("getMaxSubTreeBst node " + bst.node.data + " size " + bst.bstSize);*/
        System.out.println();
        System.out.println("getMaxProfit " + getMaxProfit(root).toString());
    }

    private static RobberyPair getMaxProfit(Node node) {

        if (node == null) {
            return new RobberyPair();
        }

        RobberyPair left = getMaxProfit(node.left);
        RobberyPair right = getMaxProfit(node.right);

        RobberyPair result = new RobberyPair();
        result.withRobbery = left.withoutRobbery + node.data + right.withoutRobbery;
        result.withoutRobbery = Integer.max(left.withoutRobbery, left.withRobbery) + Integer.max(right.withoutRobbery, right.withRobbery);

        return result;
    }

    static class RobberyPair {
        int withRobbery;
        int withoutRobbery;

        @Override
        public String toString() {
            return "RobberyPair{" +
                    "withRobbery=" + withRobbery +
                    ", withoutRobbery=" + withoutRobbery +
                    '}';
        }
    }

    static class MaxSubTreeBst {
        boolean isBST;
        int min;
        int max;
        Node node;
        int bstSize;
    }

    private static MaxSubTreeBst getMaxSubTreeBst(Node node) {

        if (node == null) {
            MaxSubTreeBst bst = new MaxSubTreeBst();
            bst.isBST = true;
            bst.min = Integer.MAX_VALUE;
            bst.max = Integer.MIN_VALUE;
            return bst;
        }

        MaxSubTreeBst leftMx = getMaxSubTreeBst(node.left);
        MaxSubTreeBst rightMx = getMaxSubTreeBst(node.right);

        MaxSubTreeBst currMx = new MaxSubTreeBst();
        currMx.isBST = leftMx.isBST && rightMx.isBST && (node.data > leftMx.max && node.data < rightMx.min);

        if (currMx.isBST) {
            currMx.node = node;
            currMx.bstSize = leftMx.bstSize + rightMx.bstSize + 1;
        } else if (leftMx.bstSize > rightMx.bstSize) {
            currMx.node = leftMx.node;
            currMx.bstSize = leftMx.bstSize;
        } else {
            currMx.node = rightMx.node;
            currMx.bstSize = rightMx.bstSize;
        }
        return currMx;
    }

    private static BalancedTreeVO isBalanced(Node node) {

        if (node == null) {
            BalancedTreeVO tree = new BalancedTreeVO();
            tree.hgt = 0;
            tree.isBalanced = true;
            return tree;
        }
        BalancedTreeVO left = isBalanced(node.left);
        BalancedTreeVO right = isBalanced(node.right);

        BalancedTreeVO tree = new BalancedTreeVO();
        tree.hgt = Integer.max(left.hgt, right.hgt) + 1;
        tree.isBalanced = Math.abs(left.hgt - right.hgt) <= 1 && left.isBalanced && right.isBalanced;

        return tree;
    }

    static class BalancedTreeVO {
        int hgt;
        boolean isBalanced;
    }

    private static BinaryTreeVO isBST(Node node) {

        if (node == null) {
            BinaryTreeVO btree = new BinaryTreeVO();
            btree.isBST = true;
            btree.max = Integer.MIN_VALUE;
            btree.min = Integer.MAX_VALUE;
            return btree;
        }

        BinaryTreeVO leftTree = isBST(node.left);
        BinaryTreeVO rightTree = isBST(node.right);

        BinaryTreeVO btree = new BinaryTreeVO();
        btree.isBST = leftTree.isBST && rightTree.isBST && node.data > leftTree.max && node.data < rightTree.min;
        btree.min = Integer.min(node.data, Integer.min(leftTree.min, rightTree.min));
        btree.max = Integer.max(node.data, Integer.max(leftTree.max, rightTree.max));

        return btree;
    }

    static class BinaryTreeVO {
        boolean isBST;
        int min;
        int max;
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

    private static Node insertLevelOrder(Integer[] arr, int i) {
        Node root = null;
        if (i < arr.length) {
            root = new Node(arr[i], null, null);
            root.left = insertLevelOrder(arr, 2 * i + 1);
            root.right = insertLevelOrder(arr, 2 * i + 2);

        }
        return root;
    }

    static class Node {
        public Integer data;
        public Node left;
        public Node right;

        public Node(Integer data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}


