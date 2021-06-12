package list;

import list.mylist.MyList;
import list.mylist.MyNode;

public class SegregateNodeOverPivot {

    public static void main(String[] args) {
        //int[] arr = {1, 5, 2, 9, 5, 3, 14, 11, 1, 10, 10, 1};
        int[] arr = {5, 5, 5, 5, 3};
        MyList ll = new MyList();
        for (int val : arr) {
            ll.addLast(val);
        }

        ll.print();

        MyNode head = segregate(ll.getHead(), 3);
        head.print();
    }

    private static MyNode segregate(MyNode head, int pivot) {

        MyNode gHead = new MyNode(-1);
        MyNode lHead = new MyNode(-1);
        MyNode pivotNode = null;

        MyNode pGreater = gHead;
        MyNode pLess = lHead;

        MyNode curr = head;

        while (curr != null) {
            if (curr.getVal() == pivot) {
                pivotNode = curr;
            } else if (curr.getVal() < pivot) {
                pLess.setNext(curr);
                pLess = curr;
            } else {
                pGreater.setNext(curr);
                pGreater = curr;
            }
            curr = curr.getNext();
        }
        pGreater.setNext(null);
        pivotNode.setNext(gHead.getNext());
        pLess.setNext(pivotNode);
        lHead = lHead.getNext();
        return lHead;
    }
}
