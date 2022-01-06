package array.recursion;

import java.util.HashMap;
import java.util.Map;

public class WordPermutate {

    public static void main(String[] args) {
        String str = "aabbbccdde";
        int k = 3;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        printAllString("", k, 0, map);
    }

    static void printAllString(String ans, int ts, int cs, Map<Character, Integer> map) {

        if (cs == ts) {
            System.out.println(ans);
            return;
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
                printAllString(ans + ch, ts, cs + 1, map);
                map.put(ch, map.get(ch) + 1);
            }
        }

    }

}
