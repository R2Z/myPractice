package list;

public class MergeSortedLL {

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 7, 15, 24};
        int[] arr2 = {-1, 0, 6, 17, 25};
        LinkedList ll1 = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            ll1.addNodeAtEnd(new Node(arr[i]));
        }

        LinkedList ll2 = new LinkedList();
        for (int i = 0; i < arr2.length; i++) {
            ll2.addNodeAtEnd(new Node(arr2[i]));
        }

        ListOperations.print(ll1.head);
        ListOperations.print(ll2.head);
        LinkedList newList = mergeTwoLists(ll1.head, ll2.head);
        ListOperations.print(newList.head);

    }

    public static LinkedList mergeTwoLists(Node n1, Node n2) {

        LinkedList newList = new LinkedList();
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                newList.addNodeAtEnd(new Node(n1.val));
                n1 = n1.next;
            } else {
                newList.addNodeAtEnd(new Node(n2.val));
                n2 = n2.next;
            }
        }
        while (n1 != null) {
            newList.addNodeAtEnd(new Node(n1.val));
            n1 = n1.next;
        }

        while (n2 != null) {
            newList.addNodeAtEnd(new Node(n2.val));
            n2 = n2.next;
        }
        return newList;
    }
}
