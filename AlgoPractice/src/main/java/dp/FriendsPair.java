package dp;

public class FriendsPair {

    public static void main(String[] args) {
        int k = 3;

        getFriendsPairCount(k, 1, "");
    }

    private static void getFriendsPairCount(int k, int ci, String pairs) {

        if (k == 0) {
            System.out.println(pairs);
            return;
        }
        getFriendsPairCount(k - 1, ci + 1, pairs + ci);
        for (int i = ci + 1; i <= k; i++) {
            getFriendsPairCount(k - 2, i+1, pairs + ci + i);
        }
    }

}
