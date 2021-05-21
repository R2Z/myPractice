package array.math;

public class PrintDigits {
    public static void main(String[] args) {
        int number = 87;
        System.out.println("Number " + number);
        for (int digit = 1; number / digit > 0; digit *= 10) {
            printDigit(number, digit);
        }
    }

    private static void printDigit(int number, int position) {
        int digit = (number / position) % 10;
        System.out.println("position " + position + " digit " + digit);
    }

}
