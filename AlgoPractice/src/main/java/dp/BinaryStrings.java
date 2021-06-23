package dp;

import java.util.HashMap;
import java.util.Map;

// Count Binary Strings | Binary Strings with no consecutive 0's
public class BinaryStrings {
    public static void main(String[] args) {
        int Max = 5;
        /*for (int i = 2; i <= Max; i++) {
            int strLength = i;
            getBinaryStringCount(strLength);
            getBinaryStringCount1(strLength);
        }*/
        int size = 6;
        System.out.println(binaryStringCount("", size, new HashMap<>(size)));
        getBinaryStringCount1(size);
    }

    private static long binaryStringCount(String str, int n, Map<String, Long> map) {

        if (map.containsKey(str)) {
            return map.get(str);
        }
        if (str.length() == n) {
            return 1;
        }

        long binCount = 0;
        String str0 = str + 0;
        String str1 = str + 1;
        if (str.isEmpty()) {
            binCount += binaryStringCount(str0, n, map);
            binCount += binaryStringCount(str1, n, map);
        } else {
            char ch = str.charAt(str.length() - 1);
            if (ch == '0') {
                binCount += binaryStringCount(str1, n, map);
            } else {
                binCount += binaryStringCount(str0, n, map);
                binCount += binaryStringCount(str1, n, map);
            }
        }
        map.put(str, binCount);
        return binCount;
    }

    private static void getBinaryStringCount1(int strLength) {

        long zp = 1;
        long op = 1;

        for (int i = 2; i <= strLength; i++) {
            long cz = op;
            long co = zp + op;
            op = co;
            zp = cz;
        }
        System.out.println("strLength " + strLength + " " + (zp + op));
    }

    private static void getBinaryStringCount(int strLength) {
        long[] dp0 = new long[strLength + 1];
        long[] dp1 = new long[strLength + 1];

        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= strLength; i++) {
            dp0[i] = dp1[i - 1];
            dp1[i] = dp0[i - 1] + dp1[i - 1];
        }

        System.out.println("strLength " + strLength + " " + (dp0[strLength] + dp1[strLength]));
    }
}
