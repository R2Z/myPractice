package list;

import java.util.Arrays;
import java.util.Random;

public class MergeSortList {

    public static void main(String[] args) {
        Random r = new Random(10);
        LinkedList ll = new LinkedList();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            int val = r.nextInt();
            ll.addNodeAtEnd(new Node(val));
            arr[i] = val;
        }
        ListOperations.print(ll.head);
        LinkedList sorted = mergeSort(ll.head, ll.tail);
        ListOperations.print(sorted.head);
        int arr2[] = Arrays.stream(arr).sorted().toArray();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "->");
        }
    }

    private static LinkedList mergeSort(Node head, Node tail) {
        // find mid
        // mergeSort left and right
        // merge two sorted lists
        if (head == tail) {
            LinkedList ll = new LinkedList();
            ll.addNodeAtEnd(new Node(head.val));
            return ll;
        }
        Node mid = findMid(head, tail);
        LinkedList left = mergeSort(head, mid);
        LinkedList right = mergeSort(mid.next, tail);
        return MergeSortedLL.mergeTwoLists(left.head, right.head);
    }

    private static Node findMid(Node head, Node tail) {
        Node slow = head;
        Node fast = head;
        while (fast.next != tail && fast != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
