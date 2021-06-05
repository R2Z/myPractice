package list;

import list.mylist.MyList;
import list.mylist.MyNode;

public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 5, 5, 6, 7};
        MyList ll = new MyList();
        for (int val : arr) {
            ll.addLast(val);
        }
        ll.print();
        MyList l2 = removeDuplicate(ll);
        l2.print();
    }

    private static MyList removeDuplicate(MyList ll) {
        MyList l = new MyList();
        if (ll != null) {
            while (ll.getHead() != null) {
                int val = ll.remveFirst();
                if (l.getSize() == 0) {
                    l.addFirst(val);
                } else {
                    MyNode node = l.getTail();
                    if (node.getVal() != val) {
                        l.addLast(val);
                    }
                }
            }
        }
        return l;
    }
}
