package list;

import java.util.Objects;

public class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
    }

    public RandomNode(int val, RandomNode next, RandomNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    public boolean equals(RandomNode o) {
        if (o == null) return false;
        else if (this.next == o.next && this.random == o.random) {
            return true;
        } else return false;
    }

    @Override
    public int hashCode() {
        return this.val;
    }
}
