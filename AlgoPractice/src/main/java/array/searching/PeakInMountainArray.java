package array.searching;

public class PeakInMountainArray {
    public static void main(String[] args) {
        int nums[] = {0, 2, 3, 5, 7, 6, 4, 3, 2};
        int ans = mountainPeak(nums);
        System.out.println(nums[ans]);
    }

    private static int mountainPeak(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid + 1] > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
