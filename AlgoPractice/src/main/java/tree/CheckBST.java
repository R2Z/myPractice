package tree;

import scala.Int;

import java.util.*;

public class CheckBST {

    public static void main(String[] args) {
        //Integer arr[] = {1, 2, 3};
        Integer arr[] = {10, -2, 7, 8, -4};
        //Integer arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        //Integer arr[] = {1, 2, 3, 4, 5, 6};
        //Integer arr[] = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Node root = insertLevelOrder(arr, 0);
        printLevelOrder(root);
        /*System.out.println();
        System.out.println("isBST " + isBST(root).isBST);
        System.out.println("isBalanced " + isBalanced(root).isBalanced);
        MaxSubTreeBst bst = getMaxSubTreeBst(root);
        System.out.println("getMaxSubTreeBst node " + bst.node.data + " size " + bst.bstSize);*/
        System.out.println();
        //System.out.println("getMaxProfit " + getMaxProfit(root));
        //printLeftView(root, 1);
        // WidthPair width = new WidthPair();
        // widthOfTree(root, width, 0);
        //System.out.println("Width " + (width.right - width.left));
        /*printVerticalOrder(root);
        currLevel = 0;
        printLeftView(root, 1);
        currLevel = 0;
        System.out.println();
        printRightView(root, 1);*/
        /*System.out.println();
        printNodesDiagonally(root);
        max_dd = 0;
        printDiagonalSum(root);*/
        System.out.println(hasTargetSum(root, 8));
        findMaxSumLeafToRoot(root, 0);
        System.out.println("findMaxSumLeafToRoot " + max_sum);
        List<Integer> result = new ArrayList<>();
        System.out.println(hasGivenSumFromRootToLeaf(root, result, 17));
        System.out.println(result);
    }

    private static boolean hasGivenSumFromRootToLeaf(Node node, List<Integer> result, int targetSum) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null && node.data == targetSum) {
            result.add(node.data);
            return true;
        }

        boolean found = hasGivenSumFromRootToLeaf(node.left, result, targetSum - node.data);
        if (!found) {
            found = hasGivenSumFromRootToLeaf(node.right, result, targetSum - node.data);
        }

        if (found) {
            result.add(node.data);
        }
        return found;
    }

    static int max_sum = Integer.MIN_VALUE;

    private static void findMaxSumLeafToRoot(Node node, int currSum) {
        if (node == null) {
            return;
        }
        currSum += node.data;
        if (node.left == null && node.right == null) {
            max_sum = Integer.max(max_sum, currSum);
        } else {
            findMaxSumLeafToRoot(node.left, currSum);
            findMaxSumLeafToRoot(node.right, currSum);
        }
    }

    static boolean hasTargetSum(Node n, int ts) {

        if (n == null || ts < 0) {
            return false;
        }
        if (ts == 0) {
            return true;
        }
        return hasTargetSum(n.left, ts - n.data) || hasTargetSum(n.right, ts - n.data);
    }

    static List<List<Integer>> ans = new ArrayList<>();

    static Boolean allNodesWithTS(Node node, int ts) {
        if (node == null || ts < 0) {
            return false;
        }
        if (ts == 0) {
            return true;
        }

        boolean left = allNodesWithTS(node.left, ts - node.data);
        if (left) {
            List<Integer> leftAns = new ArrayList<>();
            leftAns.add(node.data);
            leftAns.add(node.left.data);
            ans.add(leftAns);
        }

        boolean right = allNodesWithTS(node.right, ts - node.data);
        if (right) {
            List<Integer> leftAns = new ArrayList<>();
            leftAns.add(node.data);
            leftAns.add(node.right.data);
            ans.add(leftAns);
        }
        return left || right;
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
            if (nd.left != null) que.add(nd.left);
            if (nd.right != null) que.add(nd.right);
        }
    }

    static class DiagonalPair {
        Node n;
        int dd;

        public DiagonalPair(Node n, int dd) {
            this.n = n;
            this.dd = dd;
        }
    }

    private static int max_dd = 0;

    private static void printNodesDiagonally(Node node) {
        Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        getDiagonalOrders(node, map);
        System.out.println("Printing nodes diagonally");
        for (int i = 0; i <= max_dd; i++) {
            System.out.println(map.get(i));
        }
        System.out.println("Printing nodes diagonally");
        map = new TreeMap<>();
        diagonalOrder(node, map, 0);
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            System.out.println(e.getValue());
        }
    }

    private static void printDiagonalSum(Node node) {
        max_dd = 0;
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        getDiagonalSum(node, map, 0);
        System.out.println("Printing nodes diagonally sum ");
        for (int i = 0; i <= max_dd; i++) {
            System.out.println(map.get(i));
        }
    }

    private static void getDiagonalSum(Node node, Map<Integer, Integer> map, int hd) {
        if (node == null)
            return;

        max_dd = Integer.max(max_dd, hd);

        Integer value = 0;
        if (map.containsKey(hd)) {
            value = map.get(hd);
        }
        value += node.data;
        map.put(hd, value);

        getDiagonalSum(node.left, map, hd + 1);
        getDiagonalSum(node.right, map, hd);
    }

    private static void getDiagonalOrders(Node node, Map<Integer, List<Integer>> map) {

        Queue<DiagonalPair> queue = new ArrayDeque<>();
        DiagonalPair pair = new DiagonalPair(node, 0);
        queue.add(pair);
        while (!queue.isEmpty()) {
            DiagonalPair dp = queue.poll();
            Node nd = dp.n;
            List<Integer> elements = null;
            int dd = dp.dd;
            max_dd = Integer.max(max_dd, dd);
            if (map.containsKey(dd)) {
                elements = map.get(dd);
            } else {
                elements = new ArrayList<>();
            }
            elements.add(nd.data);
            map.put(dd, elements);

            if (nd.left != null) {
                DiagonalPair dpLeft = new DiagonalPair(nd.left, dd + 1);
                queue.add(dpLeft);
            }

            if (nd.right != null) {
                DiagonalPair dpRight = new DiagonalPair(nd.right, dd);
                queue.add(dpRight);
            }
        }
    }

    private static int currLevel = 0;

    private static void printLeftView(Node node, int level) {
        if (node == null) {
            return;
        }
        if (currLevel < level) {
            currLevel = level;
            System.out.print(node.data + "-");
        }
        printLeftView(node.left, level + 1);
        printLeftView(node.right, level + 1);
    }

    private static void printRightView(Node node, int level) {
        if (node == null) {
            return;
        }
        if (currLevel < level) {
            currLevel = level;
            System.out.print(node.data + "-");
        }
        printLeftView(node.right, level + 1);
        printLeftView(node.left, level + 1);
    }

    private static void verticalOrder(Node node, Map<Integer, List<Integer>> map, int hd) {
        if (node == null)
            return;

        List<Integer> values;
        if (map.containsKey(hd)) {
            values = map.get(hd);
        } else {
            values = new ArrayList<>();
        }
        values.add(node.data);
        map.put(hd, values);

        verticalOrder(node.left, map, hd - 1);
        verticalOrder(node.right, map, hd + 1);
    }


    private static void diagonalOrder(Node node, Map<Integer, List<Integer>> map, int hd) {
        if (node == null)
            return;

        List<Integer> values;
        if (map.containsKey(hd)) {
            values = map.get(hd);
        } else {
            values = new ArrayList<>();
        }
        values.add(node.data);
        map.put(hd, values);

        diagonalOrder(node.left, map, hd + 1);
        diagonalOrder(node.right, map, hd);
    }

    private static void printVerticalOrder(Node node) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        verticalOrder(node, map, 0);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static void widthOfTree(Node node, WidthPair pair, int currLevel) {
        if (node == null) return;
        pair.left = Integer.min(pair.left, currLevel);
        widthOfTree(node.left, pair, currLevel - 1);
        pair.right = Integer.max(pair.left, currLevel);
        widthOfTree(node.right, pair, currLevel + 1);
    }

    static class WidthPair {
        int left;
        int right;
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


