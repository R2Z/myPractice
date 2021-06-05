package list.mylist;

public class MyList {

    MyNode head;
    MyNode tail;
    int size;

    public int getSize() {
        return size;
    }

    public MyNode getHead() {
        return head;
    }

    public MyNode getTail() {
        return tail;
    }

    public void print() {
        MyNode tmp = this.head;
        while (tmp != null) {
            if (tmp == this.tail) {
                System.out.print(tmp.val + ".");
            } else {
                System.out.print(tmp.val + "->");
            }
            tmp = tmp.next;
        }
        System.out.println("");
    }

    public int remveFirst() {
        MyNode tmp = this.head;
        this.head = this.head.next;
        --size;
        tmp.next = null;
        return tmp.val;
    }

    public int addFirst(int val) {
        MyNode node = new MyNode(val);
        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            MyNode tmp = this.head;
            this.head = node;
            this.head.next = tmp;
        }
        return ++size;
    }

    public int addLast(int val) {
        MyNode node = new MyNode(val);
        if (this.head == null) {
            this.head = node;
        } else {
            MyNode tmp = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
            this.tail = node;
        }
        return ++size;
    }

}
