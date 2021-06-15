package dp;

import array.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class JumpingStaircase {

    public static void main(String[] args) {

        int nofStairs = 21;
        int[] steps = {1, 11,10};
       /* List<String> possibleWays = howSum(steps, nofStairs);
        if (possibleWays != null)
            System.out.println(possibleWays.size());

        int size = 20;
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int val = Math.abs(r.nextInt(size));
            if (val == 0) {
                arr[i] = 1;
            } else {
                arr[i] = val;
            }
        }*/

        long t1 = System.currentTimeMillis();
        List<String> possibleWays = howSum(steps, nofStairs);
        long t2 = System.currentTimeMillis();
        long diff = (t2 - t1) / 1000;
        System.out.println(" time(s) " + diff);
        if (possibleWays != null) {
            System.out.println("possibleWays " + possibleWays);
        }

        t1 = System.currentTimeMillis();
        String result = howSumMinMovesMemo(steps, nofStairs, new HashMap<>());
        t2 = System.currentTimeMillis();
        diff = (t2 - t1) / 1000;
        System.out.println(" time(s) " + diff);
        if (possibleWays != null) {
            System.out.println("possibleWays " + result);
        }
    }

    private static List<String> copyVal(int val, List<String> currList) {
        return currList.stream().map(curr -> curr + "," + val).collect(Collectors.toList());
    }

    private static String howSumMinMovesMemo(int[] arr, int sum, Map<Integer, String> map) {

        if (map.containsKey(sum)) return map.get(sum);

        if (sum == 0) {
            return "0";
        }
        if (sum < 0) {
            return null;
        }

        String possibleWays = null;
        String minMoves = null;

        for (int val : arr) {
            int diff = sum - val;
            String currMove = howSumMinMovesMemo(arr, diff, map);
            if (currMove != null) {
                currMove += "," + val;
                if (minMoves == null || currMove.length() < minMoves.length()) {
                    minMoves = currMove;
                }
            }
        }
        map.put(sum, minMoves);
        return map.get(sum);
    }

    private static List<String> howSumMemo(int[] arr, int sum, Map<Integer, List<String>> map) {

        if (map.containsKey(sum)) return map.get(sum);

        if (sum == 0) {
            List<String> dummyList = new ArrayList<>();
            dummyList.add("0");
            return dummyList;
        }
        if (sum < 0) {
            return null;
        }

        List<String> possibleWays = null;

        for (int val : arr) {
            int diff = sum - val;
            List<String> currList = howSumMemo(arr, diff, map);
            if (currList != null) {
                // add val in all elements of list
                List<String> newList = copyVal(val, currList);
                if (possibleWays == null) {
                    possibleWays = new ArrayList<>();
                }
                possibleWays.addAll(newList);
            }
        }
        map.put(sum, possibleWays);
        return possibleWays;
    }

    private static List<String> howSum(int[] arr, int sum) {

        if (sum == 0) {
            List<String> dummyList = new ArrayList<>();
            dummyList.add("0");
            return dummyList;
        }
        if (sum < 0) {
            return null;
        }

        List<String> possibleWays = null;

        for (int val : arr) {
            int diff = sum - val;
            List<String> currList = howSum(arr, diff);
            if (currList != null) {
                // add val in all elements of list
                List<String> newList = copyVal(val, currList);
                if (possibleWays == null) {
                    possibleWays = new ArrayList<>();
                }
                possibleWays.addAll(newList);
            }
        }
        return possibleWays;
    }


}
