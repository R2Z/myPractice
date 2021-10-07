package tree;

public class MAxProduct {
    public static void main(String[] args) {
        //int[] nums = {-2, 0, -1};/*{2, 3, -2, 4};{-2, 0, -1};*/
        //int[] nums = {2, 3, -2, 4};
        int[] nums = {-2, 0};
        int ans = maxProduct(nums);
        System.out.println(ans);
    }

    private static int maxProduct(int[] nums) {
        int currMinP = nums[0];
        int currMaxP = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int prevMinP = currMinP;
            int curr = nums[i];
            if (curr == 0) {
                currMinP = currMaxP = 0;
            } else {
                currMinP = Integer.min(Integer.min(curr, curr * prevMinP), curr * currMaxP);
                currMaxP = Integer.max(Integer.max(curr, curr * prevMinP), curr * currMaxP);
            }
            max = Integer.max(max, Integer.max(currMinP, currMaxP));
        }
        return max;
    }

}
