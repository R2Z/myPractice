package list;

public class RandomLinked {
    RandomNode head;
    RandomNode tail;
    int size;

    public void print() {
        RandomNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
    }

    public void addNodeAtFirst(RandomNode node) {
        node.next = head;
        head = node;
        size++;
    }

    public void addNodeAtEnd(RandomNode node) {
        if (head == null) {
            head = node;
            head.next = null;
            tail = head;
        } else {
            RandomNode tmp = head;
            while (tmp != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
            tail = tmp.next;
        }
        size++;
    }

}
