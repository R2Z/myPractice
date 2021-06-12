package list;

import list.mylist.MyList;
import list.mylist.MyNode;

public class SeggregateZeroAndOnes {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1};
        MyList ll = new MyList();
        for (int val : arr) {
            ll.addLast(val);
        }
        ll.print();
        MyNode head = seggregateZeroOnes(ll.getHead());
        head.print();
    }

    private static MyNode seggregateZeroOnes(MyNode head) {

        MyNode current = head;
        MyNode ZNode = new MyNode(-1);
        MyNode ONode = new MyNode(-1);
        MyNode pZero = ZNode;
        MyNode pOne = ONode;

        if (current != null) {
            while (current != null) {
                if (current.getVal() == 0) {
                    pZero.setNext(current);
                    pZero = current;
                } else {
                    pOne.setNext(current);
                    pOne = current;
                }
                current = current.getNext();
            }
            pOne.setNext(null);
            ZNode = ZNode.getNext();
            pZero.setNext(ONode.getNext());
        }
        return ZNode;
    }
}
