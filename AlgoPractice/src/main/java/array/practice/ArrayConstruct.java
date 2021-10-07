package array.practice;

import java.util.HashSet;
import java.util.Set;

public class ArrayConstruct {

    public static void main(String[] args) {
        int nums[] = {5, 4, 0, 1, 3, 1, 6, 2};
        //int nums[] = {0, 1, 2};
        int max = 1;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (!visited[i])
                max = Integer.max(max, getMaxSize(nums, i, visited));
        }
        System.out.println(max);
    }

    private static int getMaxSize(int[] nums, int index, boolean[] visited) {
        int next = index;
        int count = 0;
        while (!visited[nums[next]]) {
            next = nums[next];
            visited[next] = true;
            count++;
        }
        return count;
    }
}
