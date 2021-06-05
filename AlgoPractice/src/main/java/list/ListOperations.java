package list;

import java.util.Random;

public class ListOperations {
    public static void main(String[] args) {
        //findIntersection();
        //reverseLinkList();
        LinkedList ll1 = new LinkedList();
        for (int i = 1; i <= 4; i++) {
            ll1.addNodeAtEnd(new Node(i));
        }

        for (int i = 3; i > 0; i--) {
            ll1.addNodeAtEnd(new Node(i));
        }
        print(ll1.head);
        System.out.println("");

        Node mid = findMid(ll1.head);
        System.out.println("Mid " + mid.val);
        Node revHead = reverseLinkList(mid.next);
        print(revHead);
        Node fwd = ll1.head;
        boolean isPal = true;
        while (revHead != null) {
            if (revHead.val != fwd.val) {
                isPal = false;
            }
            revHead = revHead.next;
            fwd = fwd.next;
        }
        System.out.println("");
        System.out.println("IS Palindrome -> " + isPal);

       /* print(ll1.head);
        System.out.println("");
        Node rev = reverseLinkList(ll1.head);
        print(rev);*/
    }

    public static void print(Node head) {
        System.out.println(" ");
        Node tmp = head;
        while (tmp != null) {
            if (tmp.next != null) {
                System.out.print(tmp.val + "->");
            } else {
                System.out.print(tmp.val + "->Null");
            }
            tmp = tmp.next;
        }
    }

    private static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node reverseLinkList(Node head) {
        Node curr = head;
        Node prev = null;
        Node fwd;
        while (curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }

    private static void findIntersection() {
        LinkedList ll1 = new LinkedList();
        for (int i = 0; i < 10; i++) {
            ll1.addNodeAtEnd(new Node(i));
        }

        LinkedList ll2 = new LinkedList();
        for (int i = 7; i < 10; i++) {
            ll2.addNodeAtEnd(new Node(i));
        }

        int sizeDiff = Math.abs(ll1.size - ll2.size);
        Node maxList = null;
        if (ll1.size > ll2.size) maxList = ll1.head;
        else maxList = ll2.head;
        Node minList = null;
        if (ll1.size < ll2.size) minList = ll1.head;
        else minList = ll2.head;

        for (int i = 0; i < sizeDiff; i++) {
            maxList = maxList.next;
        }

        while (minList != null) {
            if (maxList.val == minList.val) {
                System.out.println(maxList.val);
                break;
            }
            maxList = maxList.next;
            minList = minList.next;
        }

    }
}

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    public void addNodeAtEnd(Node newNode) {
        if (head == null) {
            this.head = newNode;
        } else {
            Node curr = this.head;
            while (curr.next != null) {
                curr = curr.next;
            }
            newNode.next = null;
            curr.next = newNode;
            this.tail = curr.next;
        }
        this.size += 1;
    }

    public void printList() {
        if (this.head != null) {
            Node tmp = this.head;
            while (tmp != null) {
                if (tmp != this.tail) {
                    System.out.print(tmp.val + "->");
                } else {
                    System.out.print(tmp.val);
                }

                tmp = tmp.next;
            }
        }
    }

}
