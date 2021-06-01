package array.recursion;

public class TowerOfHannoi {
    public static void main(String[] args) {
        TOH(10, "A", "B", "C");
    }

    private static void TOH(int disc, String src, String dest, String helper) {

        if (disc == 0) {
            return;
        }
        TOH(disc - 1, src, helper, dest);
        System.out.println("Move " + disc + " from " + src + " to " + dest);
        TOH(disc - 1, helper, dest, src);
    }
}
