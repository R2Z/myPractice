package array.searching;

public class SearchFirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 7, 7, 8, 8, 9};
        int tgt = 7;
        int ans = findFirstOccurrence(nums, tgt, 0, nums.length - 1, true);
        System.out.println(ans);
        ans = findFirstOccurrence(nums, tgt, 0, nums.length - 1, false);
        System.out.println(ans);
    }

    static int findFirstOccurrence(int[] nums, int tgt, int st, int ed, boolean findFirst) {
        int ans = -1;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (tgt < nums[mid]) {
                ed = mid - 1;
            } else if (tgt > nums[mid]) {
                st = mid + 1;
            } else {
                ans = mid;
                if (findFirst) {
                    ed = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
        }
        return ans;
    }
}
