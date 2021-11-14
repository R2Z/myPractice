package array.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        // print all permutations
        String str = "123";
        // printAllPermutation(str, "");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        printAllPermutationOfNumber(list, "");
    }

    private static void printAllPermutation(String str, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            printAllPermutation(left + right, ans + ch);
        }

    }

    private static void printAllPermutationOfNumber(List<Integer> nums, String ans) {
        if (nums.isEmpty()) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> left = nums.subList(0, i);
            List<Integer> right = nums.subList(i + 1, nums.size());
            List<Integer> tmpList = new ArrayList();
            tmpList.addAll(left);
            tmpList.addAll(right);
            printAllPermutationOfNumber(tmpList, ans + nums.get(i));
        }

    }
}
