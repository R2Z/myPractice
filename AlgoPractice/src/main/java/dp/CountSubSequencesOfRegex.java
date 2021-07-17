package dp;

public class CountSubSequencesOfRegex {
    public static void main(String[] args) {
        String str = "abcabcabc";

        int a = 0;
        int ab = 0;
        int abc = 0;

        for (Character ch : str.toCharArray()) {
            if (ch == 'a') {
                a = 2 * a + 1;
            } else if (ch == 'b') {
                ab = 2 * ab + a;
            } else if (ch == 'c') {
                abc = 2 * abc + ab;
            }
        }
        System.out.println(abc);
    }
}
