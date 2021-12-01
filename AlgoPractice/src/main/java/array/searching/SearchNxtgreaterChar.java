package array.searching;

public class SearchNxtgreaterChar {
    public static void main(String[] args) {
        char[] chars = {'d', 'e', 'f'};
        char tgt = 'h';
        char ans = searchNxtGreater(chars, tgt, 0, chars.length - 1);
        System.out.println(ans);
    }

    private static char searchNxtGreater(char[] chars, char tgt, int st, int ed) {

        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (tgt > chars[mid]) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }

        }
        return chars[st % chars.length];
    }
}
