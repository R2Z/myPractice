package array.recursion;

public class WordBreak {

    public static void main(String[] args) {
        String dictionary[] = {"castle", "land", "frog","cloud","cloud"};
        System.out.println(wordBreak(dictionary, "froglandfrogcloud", ""));
    }

    private static boolean wordBreak(String dictionary[], String ip, String op) {

        if (op.length() >= ip.length()) {
            if (op.equals(ip)) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < dictionary.length; i++) {
            String str = dictionary[i];
            if (wordBreak(dictionary, ip, op + str)) {
                return true;
            }
        }
        return false;
    }
}
