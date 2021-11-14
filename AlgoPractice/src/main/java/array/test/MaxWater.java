package array.test;

public class MaxWater {
    public static void main(String[] args) {
        int heights[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int max = getMaxAreaBasic(heights);
        System.out.println(max);
        max = getMaxAreaOpt(heights);
        System.out.println(max);
    }

    private static int getMaxAreaOpt(int[] heights) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = heights.length - 1;
        while (start < end) {
            int height = Integer.min(heights[start], heights[end]);
            max = Integer.max(max, height * (end - start));
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    private static int getMaxAreaBasic(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int height = Integer.min(heights[i], heights[j]);
                max = Integer.max(max, height * (j - i));
            }
        }
        return max;
    }
}
