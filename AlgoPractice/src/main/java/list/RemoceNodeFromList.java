package list;

import java.util.Random;

public class RemoceNodeFromList {
    public static void main(String[] args) {
        int size = 4;
        Random r = new Random();
        LinkedList ll = new LinkedList();
        for (int i = 0; i < size; i++) {
            int val = r.nextInt();
            ll.addNodeAtEnd(new Node(val));
        }
        ListOperations.print(ll.head);
        removeNthNodeFromEnd(ll.head, 2);
        ListOperations.print(ll.head);
    }

    private static void removeNthNodeFromEnd(Node head, int n) {
        Node curr = head;
        Node forw = head;
        Node prev = curr;
        int i = 1;
        while (i != n) {
            forw = forw.next;
            i++;
        }
        while (forw.next != null) {
            prev = curr;
            curr = curr.next;
            forw = forw.next;
        }
        curr.next = null;
        prev.next = forw;
    }
}
