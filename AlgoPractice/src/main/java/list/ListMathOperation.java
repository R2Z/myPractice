package list;

public class ListMathOperation {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {6, 7};

        RandomLinked ll1 = createLinkList(arr1);
        RandomLinked ll2 = createLinkList(arr2);
        RandomLinked ll3 = new RandomLinked();
        RandomLinked ll4 = new RandomLinked();

        ll1.print();
        ll2.print();

        int carry = add(ll1.head, ll1.size, ll2.head, ll2.size, ll3);
        if (carry > 0) {
            ll3.addNodeAtFirst(new RandomNode(carry));
        }
        ll3.print();
        /*int nodediffs = Math.subtractExact(ll1.size, ll2.size);
        for (int i = 0; i < nodediffs; i++) {
            ll2.addNodeAtFirst(new RandomNode(0));
        }*/
        int borrow = sub(ll1.head, ll1.size, ll2.head, ll2.size, ll4);
        ll4.print();
    }

    private static int sub(RandomNode n1, int s1, RandomNode n2, int s2, RandomLinked ll3) {

        int borrow = 0;
        int diff = 0;
        if (s1 == 0 & s2 == 0) {
            return 0;
        }

        if (s1 > s2) {
            borrow = sub(n1.next, s1 - 1, n2, s2, ll3);
            diff = n1.val - borrow;
            borrow = 0;
        } else {
            borrow = sub(n1.next, s1 - 1, n2.next, s2 - 1, ll3);
            int num = n1.val - borrow;
            if (num > n2.val) {
                diff = num - n2.val;
                borrow = 0;
            } else {
                borrow = 1;
                diff = (num + 10) - n2.val;
            }
        }
        ll3.addNodeAtFirst(new RandomNode(diff));
        return borrow;
    }

    private static int add(RandomNode n1, int s1, RandomNode n2, int s2, RandomLinked ll3) {

        int carry = 0;
        int sum = 0;

        if (s1 == 0 && s2 == 0) {
            return 0;
        }

        if (s1 > s2) {
            carry = add(n1.next, s1 - 1, n2, s2, ll3);
            sum = carry + n1.val;
        } else if (s2 > s1) {
            carry = add(n1, s1, n2.next, s2 - 1, ll3);
            sum = carry + n2.val;
        } else {
            carry = add(n1.next, s1 - 1, n2.next, s2 - 1, ll3);
            sum = carry + n1.val + n2.val;
        }
        ll3.addNodeAtFirst(new RandomNode(sum % 10));
        return sum / 10;
    }


    private static RandomLinked createLinkList(int[] arr1) {
        RandomLinked ll = new RandomLinked();
        for (int val : arr1) {
            ll.addNodeAtEnd(new RandomNode(val));
        }
        return ll;
    }
}
