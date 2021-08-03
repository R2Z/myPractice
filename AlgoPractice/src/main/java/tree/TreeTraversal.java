package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal {

    public static void main(String[] args) {
        Integer arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        //Integer arr[] = {1, 2, 3, 4, 5, 6};
        //Integer arr[] = {3,5,1,6,2,0,8,null,null,7,4};
        Node root = insertLevelOrder(arr, 0);
        /*System.out.println("PreOrder");
        preOrder(root);
        System.out.println();
        System.out.println("InOrder");
        inOrder(root);
        System.out.println();
        System.out.println("PostOrder");
        postOrder(root);
        System.out.println();*/
        System.out.println("LevelOrder");
        printLevelOrder(root);
        System.out.println();
        /*List<Integer> path = new ArrayList<>();
        findPath(root, 6, path);
        if (!path.isEmpty())
            System.out.println(path);*/
        //System.out.println(heightOfTree(root));
        printKLevelNodes(root, 2);
    }

    private static void printKLevelNodes(Node root, int k) {
        if (root == null || k < 0)
            return;

        if (k == 0)
            System.out.print(root.data + "->");

        printKLevelNodes(root.left, k - 1);
        printKLevelNodes(root.right, k - 1);
    }

    private static int heightOfTree(Node root) {

        if (root == null) {
            return 0;
        }
        int height = Integer.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
        return height;
    }

    private static boolean findPath(Node root, int num, List<Integer> path) {

        if (root == null) {
            return false;
        }

        if (root.data == num) {
            path.add(root.data);
            return true;
        }
        // check left tree
        boolean left = findPath(root.left, num, path);
        if (left) {
            path.add(root.data);
            return true;
        }

        // check right tree
        boolean right = findPath(root.right, num, path);
        if (right) {
            path.add(root.data);
            return true;
        }
        return false;
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

    // DLR
    private static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + "->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // LDR
    private static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "->");
            inOrder(root.right);
        }
    }

    // LRD
    private static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "->");
        }
    }

}

class Node {
    Integer data;
    public Node left;
    public Node right;

    /*public Node(Integer data) {
        this.data = data;
    }*/

    public Node(Integer data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
