package list;

import java.util.HashMap;
import java.util.Map;

public class RandomPointerList {

    public static void main(String[] args) {
        RandomNode head = createRandomList();
        print(head);
        RandomNode cloned = copyRandomList(head);
        print(cloned);
    }

    /**
     * Using two pass algo create deep copy of list
     *
     * @param head
     */
    private static RandomNode copyRandomList(RandomNode head) {

        // pass 1 create node and store in in lookup array
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode curr = head;
        RandomNode newNode = null;
        while (curr != null) {
            newNode = new RandomNode(curr.val);
            map.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            newNode = map.get(curr);
            newNode.next = map.get(curr.next);
            newNode.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    private static RandomNode createRandomList() {
        RandomNode n1 = new RandomNode(7);
        RandomNode n2 = new RandomNode(13);
        RandomNode n3 = new RandomNode(11);
        RandomNode n4 = new RandomNode(10);
        RandomNode n5 = new RandomNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n2;
        n5.random = n1;
        return n1;
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
}
