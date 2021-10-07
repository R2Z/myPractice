package test;

public class StrTransFormations {

    public static void main(String[] args) {
        String s = "baaca";
        int k = 3;
        //"aaabc"
        System.out.println(orderlyQueue(s, k));
    }

    public static String orderlyQueue(String s, int k) {
        int itrs = s.length() - k;
        String mod = s;
        String ans = s;
        for (int i = 0; i < itrs; i++) {
            mod = mod.substring(k)+mod.substring(0, k);
            if (mod.compareTo(ans) < 0) {
                ans = mod;
            }
        }
        return ans;
    }
}
