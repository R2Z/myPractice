package dp;

public class FrogJump {
    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5}; //{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};////{1, 3, 6, 1, 0, 9};
        int min_jumps = minJump(arr, 0, arr.length - 1);
        System.out.println(min_jumps);
    }

    private static int minJump(int[] arr, int curr, int steps) {

        int minSteps = Integer.MAX_VALUE - 1;

        if (curr == steps || curr > steps) {
            return 0;
        }

        if (arr[curr] == 0) {
            return minSteps;
        }

        for (int j = curr + 1; j <= curr + arr[curr]; j++) {
            int curMin = 1 + minJump(arr, j, steps);
            minSteps = Integer.min(minSteps, curMin);
        }

        return minSteps;
    }
}
