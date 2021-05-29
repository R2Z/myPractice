package string;

public class PrintAllSubsequence {
    public static void main(String[] args) {
        String qus = "abc";
        printSS(qus, "");
    }

    private static void printSS(String qus, String ans) {
        if (qus.length() == 0) {
            if(ans.length() == 0 ) System.out.println("EMPTY");
            System.out.println(ans);
            return;
        }
        char ch = qus.charAt(0);
        String ros = qus.substring(1);
        printSS(ros, ans + ch);
        printSS(ros, ans + "");
    }
}
