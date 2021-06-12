package dp;

import java.util.*;
import java.util.stream.Collectors;

public class AllConstruct {
    public static void main(String[] args) {

        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        //System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "ska", "sk", "boar"}));
        //System.out.println(allConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));

    }

    private static void addStrAtStartOfEachList(List<List<String>> finalResult, List<List<String>> subResult, String str) {

        if (finalResult == null) {
            finalResult = new ArrayList<>();
        }

        if (subResult.isEmpty()) {
            List<String> tmpList = new ArrayList<>();
            tmpList.add(str);
            subResult.add(tmpList);
            finalResult.addAll(subResult);
        } else {
            finalResult.addAll(subResult);

            finalResult.stream().map(r -> {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                strList.addAll(r);
                return strList;
            }).collect(Collectors.toList());
        }
    }

    private static List<List<String>> allConstruct(String targetStr, String[] arr) {

        if (targetStr.length() == 0) {
            return new ArrayList<>();
        }

        List<List<String>> finalResult = null;

        for (String str : arr) {
            if (targetStr.indexOf(str) == 0) {
                String subStr = targetStr.substring(str.length());
                List<List<String>> subResult = allConstruct(subStr, arr);
                if (subResult != null && !subStr.isEmpty()) {
                    addStrAtStartOfEachList(finalResult, subResult, subStr);
                }
            }
        }
        return finalResult;
    }


}
