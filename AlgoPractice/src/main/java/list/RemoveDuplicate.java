package list;

import list.mylist.MyList;
import list.mylist.MyNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 5, 5, 6, 7};
        MyList ll = new MyList();
        for (int val : arr) {
            ll.addLast(val);
        }
        ll.print();
        //MyList l2 = removeDuplicate(ll);
        //l2.print();
        MyNode n = removeAllDups(ll.getHead());
        n.print();
    }

    private static MyNode removeAllDups(MyNode head) {

        Map<Integer, Integer> map = new HashMap<>();
        MyNode tmp = head;
        while (tmp != null) {
            int key = tmp.getVal();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
            tmp = tmp.getNext();
        }

        MyList ll = new MyList();
        tmp = head;
        while (tmp != null) {
            if (map.get(tmp.getVal()) == 1) {
                ll.addLast(tmp.getVal());
            }
            tmp = tmp.getNext();
        }
        return ll.getHead();
    }

    /**
     * remove duplicate without extra space or creating new linked list
     *
     * @param head
     * @return
     */
    private static MyNode removeDups(MyNode head) {
        MyNode curr = head;
        while (curr != null && curr.getNext() != null) {
            if (curr.getVal() == curr.getNext().getVal()) {
                MyNode tmp = curr.getNext().getNext();
                if (tmp == null) {
                    curr.setNext(null);
                    break;
                } else {
                    curr.setNext(tmp);
                }
            }
            curr = curr.getNext();
        }
        return head;
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
