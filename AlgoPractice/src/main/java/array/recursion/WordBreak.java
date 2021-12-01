package array.recursion;

public class WordBreak {

    public static void main(String[] args) {
        String dictionary[] = {"i", "like", "samsung"};
        System.out.println(wordBreak(dictionary, "ilikesamsung", "", 0));
    }

    private static boolean wordBreak(String dictionary[], String ip, String op, int index) {

        if (ip.equals(op)) {
            return true;
        }

        for (int i = index; i < dictionary.length; i++) {
            String str = dictionary[i];
            if (wordBreak(dictionary, ip, op + str, i + 1)) {
                return true;
            }
        }
        return false;
    }
}
