package dp;

import array.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class EnvelopsPacking {

    static class Pair implements Comparable<Pair> {
        int width;
        int height;

        @Override
        public String toString() {
            return "Pair{" +
                    "width=" + width +
                    ", height=" + height +
                    '}';
        }

        public Pair(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.width == o.width)
                return 0;
            else if (this.width > o.width) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] envs0 = {{5, 5}, {6, 4}, {6, 8}, {2, 3}};
        int[][] envs1 = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] envs2 = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        List<int[][]> input = new ArrayList<>();
        input.add(envs0);
        input.add(envs1);
        input.add(envs2);
        for (int[][] envs : input) {
            List<Pair> pairList = new ArrayList<>();
            for (int i = 0; i < envs.length; i++) {
                int[] pair = envs[i];
                Pair p = new Pair(pair[0], pair[1]);
                pairList.add(p);
            }
            Collections.sort(pairList);
            System.out.println(pairList);
            List heightList = pairList.stream().map(p -> p.height).collect(Collectors.toList());
            System.out.println(heightList);

            int maxEnvs = LIS(heightList);
            System.out.println(maxEnvs);
        }
    }

    private static int LIS(List<Integer> heightList) {
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer e : heightList) {
            Integer currmax = set.ceiling(e);
            if (currmax != null) {
                set.remove(currmax);
            }
            set.add(e);
        }
        return set.size();
    }
}
