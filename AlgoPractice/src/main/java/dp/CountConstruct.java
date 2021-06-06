package dp;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {
    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "ska", "sk", "boar"}));
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        //System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeeee"}));

        System.out.println("DP begins");

        System.out.println(countConstructDP("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, null));
        System.out.println(countConstructDP("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "ska", "sk", "boar"}, null));
        System.out.println(countConstructDP("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, null));
        System.out.println(countConstructDP("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeeee"}, null));

    }

    private static int countConstruct(String targetString, String[] arr) {

        if (targetString.length() == 0) return 1;
        int numOfSubStrs = 0;
        for (String str : arr) {
            if (targetString.indexOf(str) == 0) {
                int result = countConstruct(targetString.substring(str.length()), arr);
                if (result > 0) {
                    numOfSubStrs += result;
                }
            }
        }
        return numOfSubStrs;
    }

    private static int countConstructDP(String targetString, String[] arr, Map<String, Integer> map) {

        if (map == null) {
            map = new HashMap<>();
        }
        if (map.containsKey(targetString)) {
            return map.get(targetString);
        }
        if (targetString.length() == 0) return 1;

        int numOfSubStrs = 0;

        for (String str : arr) {
            if (targetString.indexOf(str) == 0) {
                int result = countConstructDP(targetString.substring(str.length()), arr, map);
                if (result > 0) {
                    numOfSubStrs += result;
                }
            }
        }
        map.put(targetString, numOfSubStrs);
        return numOfSubStrs;
    }

}
