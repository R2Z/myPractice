package list;

public class AddTwoLinkedList {

    public static void main(String[] args) {
        RandomNode n1 = getList1();
        RandomNode n2 = getList2();
        RandomLinked result = new RandomLinked();

        print(n1);
        print(n2);
        int s1 = getSize(n1);
        int s2 = getSize(n2);
        System.out.println("");
        System.out.println("n1 size " + s1 + " n2 size " + s2);

        int carry = addTwoLists(n1, s1, n2, s2, result);
        if (carry > 0) {
            RandomNode r = new RandomNode(carry);
            result.addNodeAtFirst(r);
        }
        result.print();
    }

    private static int addTwoLists(RandomNode n1, int s1, RandomNode n2, int s2, RandomLinked result) {

        if (s1 == 0 && s2 == 0)
            return 0;

        int sum = 0;
        int carry = 0;
        if (s1 > s2) {
            carry = addTwoLists(n1.next, s1 - 1, n2, s2, result);
            sum = n1.val + carry;
        } else if (s2 > s1) {
            carry = addTwoLists(n1, s1, n2.next, s2 - 1, result);
            sum = n1.val + carry;
        } else {
            carry = addTwoLists(n1.next, s1 - 1, n2.next, s2 - 1, result);
            sum = n1.val + n2.val + carry;
        }
        RandomNode newNode = new RandomNode(sum % 10);
        result.addNodeAtFirst(newNode);
        return sum / 10;
    }

    private static int getSize(RandomNode n1) {
        int size = 0;
        while (n1 != null) {
            n1 = n1.next;
            size++;
        }
        return size;
    }


    private static void print(RandomNode head) {
        System.out.println(" ");
        while (head != null) {
            if (head.next != null)
                System.out.print(head.val + "->");
            else
                System.out.print(head.val);
            head = head.next;
        }
    }

    private static RandomNode getList2() {
        RandomNode n1 = new RandomNode(7);
        RandomNode n2 = new RandomNode(9);
       /* RandomNode n3 = new RandomNode(8);
        RandomNode n4 = new RandomNode(6);*/

        n1.next = n2;
        n2.next = null;
      /*  n3.next = n4;
        n4.next = null;*/

        return n1;
    }

    private static RandomNode getList1() {
        RandomNode n1 = new RandomNode(2);
        RandomNode n2 = new RandomNode(3);
        RandomNode n3 = new RandomNode(4);
        RandomNode n4 = new RandomNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        return n1;
    }
}
