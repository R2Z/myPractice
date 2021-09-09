package tree;


public class BinaryTreeSummation {

    public static void main(String[] args) {
        Integer arr[] = {10, -2, 7, 8, -4};
        //Integer arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        //Integer arr[] = {1, 2, 3, 4, 5, 6};
        //Integer arr[] = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Node root = TreeTraversal.insertLevelOrder(arr, 0);
        TreeTraversal.printLevelOrder(root);
        Result result = findSumLeafToLeaf(root);
        System.out.println();
        System.out.println("LTL_MaxSum " + Integer.max(result.LTL_MaxSum, result.NTL_MaxSum));
        System.out.println("AnyNodeMaxSum " + findSumBetweenAnyNode(root));

    }

    static class Result {
        int LTL_MaxSum = Integer.MIN_VALUE;
        int NTL_MaxSum = Integer.MIN_VALUE;
    }

    private static Result findSumLeafToLeaf(Node node) {

        if (node == null) {
            Result tmp = new Result();
            return tmp;
        }

        // if node is  leaf
        if (node.left == null && node.right == null) {
            Result tmp = new Result();
            tmp.LTL_MaxSum = node.data;
            return tmp;
        }

        Result leftResult = findSumLeafToLeaf(node.left);
        Result rightResult = findSumLeafToLeaf(node.right);

        Result result = new Result();
        result.LTL_MaxSum = Integer.max(leftResult.LTL_MaxSum, rightResult.LTL_MaxSum);

        if (node.left != null && node.right != null) {
            result.NTL_MaxSum = Integer.max(result.NTL_MaxSum, leftResult.LTL_MaxSum + node.data + rightResult.LTL_MaxSum);
        }

        result.LTL_MaxSum = Integer.max(leftResult.LTL_MaxSum, rightResult.LTL_MaxSum) + node.data;
        return result;

    }

    private static int findSumBetweenAnyNode(Node node) {

        if (node == null) {
            return 0;
        }

        int left = findSumBetweenAnyNode(node.left);
        int right = findSumBetweenAnyNode(node.right);

        int sumWithNode = Integer.max(left + node.data + right, Integer.max(node.data + left, node.data + right));
        int maxSum = Integer.max(sumWithNode, Integer.max(node.data, Integer.max(node.data + left, node.data + right)));

        return maxSum;
    }

}
