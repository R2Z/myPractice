package list;

public class DetectCycle {

    public static void main(String[] args) {
        RandomNode n1 = new RandomNode(1);
        RandomNode n2 = new RandomNode(2);
        RandomNode n3 = new RandomNode(3);
        RandomNode n4 = new RandomNode(4);
        RandomNode n5 = new RandomNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;

        RandomNode head = n1;

        detectCycle(head);
        print(head);

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

    private static void detectCycle(RandomNode head) {

        RandomNode n1 = head;
        RandomNode n2 = head;
        boolean bool = false;

        while (n2 != null || n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2) {
                bool = true;
                break;
            }
        }
        if (bool) {
            System.out.println("Cycle detected");
            while (n1.next != n2.next) {
                n1 = n1.next;
                n2 = n2.next;
            }
            n2.next = null;
            System.out.println("Cycle at node " + n1.val);
        }
    }
}
