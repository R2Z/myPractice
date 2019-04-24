package string;

public class SubstringExample {
    public static void main(String[] args) {
        String str1 = "Hello, this is Java";
        for (int i = 0; i <1000 ; i++) {
        	String str2 = str1.substring(7, 11);
            System.out.println(str2);
		}
        System.out.println("");
    }
}