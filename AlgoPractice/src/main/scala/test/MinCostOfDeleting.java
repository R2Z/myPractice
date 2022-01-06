package test;

public class MinCostOfDeleting {

    public static void main(String[] args) {
        String str = "aabbcc";
        int[] cost = {1, 2, 1, 2, 1, 2};
        int i = 0;
        int minWeight = 0;
        while (i < str.length() - 1) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                minWeight += Integer.min(cost[i], cost[i + 1]);
            }
            i++;
        }
        System.out.println(minWeight);
    }
}
