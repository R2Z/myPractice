package test;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {11, 15, 2, 7};
        int target = 9;
        int[] res = findTwoSum_Sorting(nums, target);
        System.out.println(res[0] + " - " + res[1]);
    }

    private static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[] {};
    }

    private static int[] findTwoSum_Sorting(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if(nums[left] + nums[right] == target) {
                return new int[] {nums[left], nums[right]};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }

    // requires sorted array
    public static int[] onePass(int[] nums, int target) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int s = 0;
        int e = nums.length - 1;
        while (s < e) {
            int sum = nums[s] + nums[e];
            if (sum == target) {
                ans[0] = s;
                ans[1] = e;
                break;
            }

            if (sum > target) {
                e--;
            } else {
                s++;
            }

        }

        return ans;
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        /*for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            map.put(y, i);
        }*/

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                ans[0] = map.get(diff);
                ans[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
