package dp;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {
    public static void main(String[] args) {
        int arr[] = {6, 34, 4, 12, 5, 2};
        int targetSum = 9;
        List<Integer> ans = getSubSetSum(arr, targetSum, -1);
        System.out.println(ans);
    }

    private static List<Integer> getSubSetSum(int[] arr, int targetSum, int ci) {

        if (targetSum == 0) {
            return new ArrayList<>();
        }

        List<Integer> currList = null;
        for (int i = ci + 1; i < arr.length; i++) {
            int new_targetSum = targetSum - arr[i];
            if (new_targetSum >= 0) {
                currList = getSubSetSum(arr, new_targetSum, i);
                if (currList != null) {
                    currList.add(arr[i]);
                    return currList;
                }
            }
        }
        return currList;
    }
}
