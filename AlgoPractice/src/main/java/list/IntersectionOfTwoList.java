package list;

public class IntersectionOfTwoList {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 3, 8, 9};

        RandomLinked ll1 = createLinkList(arr1);
        RandomLinked ll2 = createLinkList(arr2);

        //ll1.print();
        //ll2.print();
        findIntersectionPoint(ll1, ll2);
        //ll1.print();

    }

    private static void findIntersectionPoint(RandomLinked ll1, RandomLinked ll2) {

        // attach tail of one list to head of other list
        ll1.tail.next = ll2.head;
        ll2.tail.next = ll1.head;

        // detect meeting point using floyd cycle rule
        RandomNode meetNode = detectCycle(ll1.head, ll2.head);
        System.out.println(meetNode.val);

    }

    private static RandomNode detectCycle(RandomNode head, RandomNode head2) {
        RandomNode slow = head;
        RandomNode fast = head;
        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) {
                break;
            }
        }
        RandomNode meetNode = head2;
        while (meetNode.val != slow.val) {
            meetNode = meetNode.next;
            slow = slow.next;
        }
        return meetNode;
    }

    private static RandomLinked createLinkList(int[] arr1) {
        RandomLinked ll = new RandomLinked();
        for (int val : arr1) {
            ll.addNodeAtEnd(new RandomNode(val));
        }
        return ll;
    }
}
