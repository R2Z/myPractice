package list;

public class FoldLinkedList {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 6, 9, 9, 6, 4, 1, 5};
        LinkedList ll1 = new LinkedList();
        for (int i = 1; i < arr.length; i++) {
            ll1.addNodeAtEnd(new Node(arr[i]));
        }
        ListOperations.print(ll1.head);
        System.out.println("");

        foldList(ll1.head);
    }

    private static void foldList(Node head) {

        // find Mid
        Node mid = findMid(head);
        Node nextHead = mid.next;
        System.out.println("Mid " + nextHead);
        // reverse
        Node second = reverseList(mid);
        //ListOperations.print(second);
        //System.out.println("");
        // exchange pointers
        exchangeLinks(head, second);
        ListOperations.print(head);

    }

    private static void exchangeLinks(Node first, Node second) {

        Node c1 = first;
        Node c2 = second;
        Node f1 = null;
        Node f2 = null;

        while (c2 != null) {
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }

    private static Node reverseList(Node head) {

        Node cur = head;
        Node fwd = head;
        Node prev = null;

        while (cur != null) {
            fwd = cur.next;
            cur.next = prev;

            prev = cur;
            cur = fwd;
        }
        return prev;
    }

    private static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}


