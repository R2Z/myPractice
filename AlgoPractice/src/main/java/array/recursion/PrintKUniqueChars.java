package array.recursion;

import java.util.HashMap;
import java.util.Map;

public class PrintKUniqueChars {
    public static void main(String[] args) {
        String str = "aabbbccdde";
        int k = 3;
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (!map.containsKey(ch)) {
                sb.append(ch);
            }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        String uStr = sb.toString();
        //printKUnqChars(uStr, "", k, 0, 0);
        //printKStrs(uStr, "", k,-1);
        printKStrsWithRep(map, "", k);
    }

    static void printKUnqChars(String str, String ans, int k, int ci, int ssf) {

        if (ci == str.length()) {
            if (ssf == k) {
                System.out.println(ans);
            }
            return;
        }

        char ch = str.charAt(ci);
        printKUnqChars(str, ans + ch, k, ci + 1, ssf + 1);
        printKUnqChars(str, ans, k, ci + 1, ssf);
    }

    static void printKStrs(String str, String ans, int k, int ci) {

        if (ans.length() == k) {
            System.out.println(ans);
            return;
        }

        for (int i = ci + 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            printKStrs(str, ans + ch, k, i);
        }
    }

    static void printKStrsWithRep(Map<Character, Integer> map, String ans, int k) {

        if (ans.length() == k) {
            System.out.println(ans);
            return;
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
                printKStrsWithRep(map, ans + ch, k);
                map.put(ch, map.get(ch) + 1);
            }
        }
    }
}
