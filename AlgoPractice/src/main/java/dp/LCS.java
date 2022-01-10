package dp;

import java.util.HashMap;
import java.util.Map;

public class LCS {

    static class LC {
        @Override
        public String toString() {
            return "LC{" +
                    "c=" + c +
                    ", str='" + str + '\'' +
                    '}';
        }

        int c;
        String str;

        LC(int c, String str) {
            this.c = c;
            this.str = str;
        }
    }

    public static void main(String[] args) {
        String s1 = "familyone";
        String s2 = "emilyioe";
        LC lc = new LC(0, "");
        Map<String, LC> map = new HashMap<>();
        LC l = getLCS(s1.toCharArray(), s2.toCharArray(), s1.length() - 1, s2.length() - 1, lc, map);
        System.out.println(l.toString());
        System.out.println(getLCSubSeq(s1.toCharArray(), s2.toCharArray(), s1.length() - 1, s2.length() - 1));

    }

    private static LC getLCS(char[] s1, char[] s2, int m, int n, LC ans, Map<String, LC> map) {

        String key = m + "|" + n;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (m == 0 || n == 0) {
            return ans;
        }

        LC l1 = ans;
        if (s1[m] == s2[n]) {
            ans.str = ans.str + s1[m];
            ans.c = ans.c + 1;
            l1 = getLCS(s1, s2, m - 1, n - 1, ans, map);
        }

        LC l2 = getLCS(s1, s2, m, n - 1, new LC(0, ""), map);
        LC l3 = getLCS(s1, s2, m - 1, n, new LC(0, ""), map);

        LC lc = l1.c > l2.c ? l1 : l2.c > l3.c ? l2 : l3;
        map.put(key, lc);
        return map.get(key);
    }

    private static LC getLCS(char[] s1, char[] s2, int m, int n) {

        if (m == 0 || n == 0) {
            return new LC(0, "");
        }

        LC l1 = new LC(0, "");
        if (s1[m] == s2[n]) {
            l1 = getLCS(s1, s2, m - 1, n - 1);
            l1.c += 1;
        }

        LC l2 = getLCS(s1, s2, m, n - 1);
        LC l3 = getLCS(s1, s2, m - 1, n);

        return l1.c > l2.c ? l1 : l2.c > l3.c ? l2 : l3;
    }

    private static int getLCSubSeq(char[] s1, char[] s2, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1[m] == s2[n]) {
            return 1 + getLCSubSeq(s1, s2, m - 1, n - 1);
        }

        int l1 = getLCSubSeq(s1, s2, m, n - 1);
        int l2 = getLCSubSeq(s1, s2, m - 1, n);

        return Integer.max(l1, l2);
    }
}
