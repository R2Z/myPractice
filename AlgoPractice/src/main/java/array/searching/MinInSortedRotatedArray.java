package array.searching;

public class MinInSortedRotatedArray {
    public static void main(String[] args) {
        /*int arr[] = {3, 4, 5, 6, 0, 1, 2};
        int ans = findMin(arr);
        System.out.println(ans);
        int arr2[] = {2, 3, 4, 5, 6, 0, 1};
        ans = findMin(arr2);
        System.out.println(ans);*/
        //int arr3[] = {5, 1, 2, 3, 4};
        int arr3[] = {7, 1, 2, 3, 4, 5, 6};
        int ans = findMin(arr3);
        System.out.println(ans);
    }

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];


        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[end]) {
                return nums[start];
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
