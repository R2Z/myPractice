package string;

public class PrintAllAbbreviations {
    public static void main(String[] args) {
        String str = "abc";
        printAbbr(str, "", 0, 0);
    }

    private static void printAbbr(String in, String out, int count, int index) {

        if (index == in.length()) {
            if (count > 0)
                System.out.println(out + count);
            else
                System.out.println(out);
            return;
        }
        // including char
        if (count > 0)
            printAbbr(in, out + count + in.charAt(index), 0, index + 1);
        else
            printAbbr(in, out + in.charAt(index), 0, index + 1);
        // not including char , incr count
        printAbbr(in, out, count + 1, index + 1);
    }
}
