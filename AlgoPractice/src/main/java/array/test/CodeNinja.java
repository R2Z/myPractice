package array.test;

public class CodeNinja {
    public static void main(String[] args) {
        String str = "almonds";
        char[] chrs = str.toCharArray();
        StringBuilder outputString = new StringBuilder();
        for (char ch : chrs) {
            int opInt = Integer.valueOf('z') == Integer.valueOf(ch) ? Integer.valueOf('a') : Integer.valueOf(ch) + 1;
            char opChar = (char) (opInt);
            outputString.append(opChar);
        }
        System.out.println(outputString);
    }
}
