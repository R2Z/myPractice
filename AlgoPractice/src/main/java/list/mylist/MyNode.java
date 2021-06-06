package list.mylist;

public class MyNode {
    int val;
    MyNode next;

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public MyNode getNext() {
        return next;
    }

    public void print() {
        MyNode curr = this;
        while (curr != null) {
            if (curr.next == null) {
                System.out.print(curr.val + ".");
            } else {
                System.out.print(curr.val + "->");
            }
            curr = curr.next;
        }
    }

    public MyNode(int val) {
        this.val = val;
    }
}
