package dp;

// Count Binary Strings | Binary Strings with no consecutive 0's
public class BinaryStrings {
    public static void main(String[] args) {
        int Max = 30;
        for (int i = 2; i <= Max; i++) {
            int strLength = i;
            getBinaryStringCount(strLength);
            getBinaryStringCount1(strLength);
        }
    }

    private static void getBinaryStringCount1(int strLength) {

        int zp = 1;
        int op = 1;

        for (int i = 2; i <= strLength; i++) {
            int cz = op;
            int co = zp + op;
            op = co;
            zp = cz;
        }
        System.out.println("strLength " + strLength + " " + (zp + op));
    }

    private static void getBinaryStringCount(int strLength) {
        int[] dp0 = new int[strLength + 1];
        int[] dp1 = new int[strLength + 1];

        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= strLength; i++) {
            dp0[i] = dp1[i - 1];
            dp1[i] = dp0[i - 1] + dp1[i - 1];
        }

        System.out.println("strLength " + strLength + " " + (dp0[strLength] + dp1[strLength]));
    }
}
