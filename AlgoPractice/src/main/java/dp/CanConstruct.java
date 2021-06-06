package dp;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public static void main(String[] args) {
        String str = "abcdef";
        String st = "ab";
        System.out.println(str.indexOf("ab"));
        System.out.println(str.substring(st.length()));
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "ska", "sk", "boar"}));
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        //System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeeee"}));

        System.out.println("DP solution ");
        System.out.println(canConstructDP("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, null));
        System.out.println(canConstructDP("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "ska", "sk", "boar"}, null));
        System.out.println(canConstructDP("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, null));
        System.out.println(canConstructDP("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeeee"}, null));

    }

    // m = length of target string
    // n = size of array
    // time => O(height of tree ^ num of decisions at each node * num of operations at each decision
    // time => O(m^n*m)
    // stace => height of tree * storage at each height => O(m*m)
    private static boolean canConstruct(String targetStr, String[] arr) {

        if (targetStr.length() == 0) return true;

        for (String str : arr) {
            if (targetStr.indexOf(str) == 0) {
                String subStr = targetStr.substring(str.length());
                if (canConstruct(subStr, arr))
                    return true;
            }
        }
        return false;
    }

    private static boolean canConstructDP(String targetStr, String[] arr, Map<String, Boolean> map) {

        if (map == null) {
            map = new HashMap<>();
        }
        if (map.containsKey(targetStr)) {
            return map.get(targetStr);
        }

        if (targetStr.length() == 0) return true;

        for (String str : arr) {
            if (targetStr.indexOf(str) == 0) {
                String subStr = targetStr.substring(str.length());
                Boolean result = canConstructDP(subStr, arr, map);
                if (result) {
                    map.put(targetStr, result);
                    return result;
                }
            }
        }
        map.put(targetStr, false);
        return false;
    }

}
