package array.test;

public class AddBitwise {
    public static void main(String[] args) {
        int num1 = 2;
        int num2 = 3;
        int ans = sum(num1, num2);
        System.out.println(ans);
        System.out.println(countOneBit(num2));
        int arr[] = countBits(num1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " , ");
        }
    }

    private static int countOneBit(int n) {
        int count = 0;
        int bits = 32;
        int mask = 1;
        while (bits > 0) {
            bits--;
            if ((n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }

    public static int[] countBits(int n) {
        int arr[] = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = countOnes(i);
        }
        return arr;
    }

    private static int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    private static int sum(int num1, int num2) {

        while (num2 != 0) {
            int carry = num1 & num2;
            num1 = num1 ^ num2;
            num2 = carry << 1;
        }
        return num1;
    }
}
