package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class SerializationAndDeserializationOfBinaryTree {

    public static void main(String[] args) {
        //Integer arr[] = {1, 2, 3};
        Integer arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6};
        //Integer arr[] = {1, 2, 3, 4, 5, 6};
        Node root = insertLevelOrder(arr, 0);
        printLevelOrder(root);
        StringBuilder sb = new StringBuilder();
        serializeTree(root, sb);
        System.out.println();
        System.out.println(sb);
        Node node = deserializeTree(sb);
        printLevelOrder(node);
    }

    private static Node deserializeTree(StringBuilder sb) {
        System.out.println();
        System.out.println("deserializeTree");
        String[] arr = sb.toString().split(",");
        return createDeserializeTree(arr);
    }

    static int count = 0;

    private static Node createDeserializeTree(String str[]) {
        Node node ;

        if (count >= str.length) {
            return null;
        }

        if (str[count].equals("-1")) {
            return null;
        }

        node = new Node(Integer.valueOf(str[count]), null, null);
        ++count;
        node.left = createDeserializeTree(str);
        ++count;
        node.right = createDeserializeTree(str);

        return node;
    }

    private static void serializeTree(Node node, StringBuilder sb) {

        if (node == null) {
            sb.append("-1,");
            return;
        }
        sb.append(node.data + ",");
        serializeTree(node.left, sb);
        serializeTree(node.right, sb);
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
            if (nd.left != null) que.add(nd.left);
            if (nd.right != null) que.add(nd.right);
        }
    }


}
