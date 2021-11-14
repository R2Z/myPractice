package array.test;

import java.util.HashMap;
import java.util.Map;

public class CodeSignal {
    public static void main(String[] args) {
        int[] soldsXp = {123, 9999, 19999, 23443, 343432, 333, 55343, 23232, 6644, 234, 555223, 55664, 6643, 6644};
        Map<String, Integer> optMap = new HashMap<>();
        for (int xp : soldsXp) {
            String title = solderType(xp);
            int count = optMap.getOrDefault(title, 0) + 1;
            optMap.put(title, count);
        }
        for (Map.Entry<String, Integer> entry : optMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static String solderType(int xp) {
        String op = "";
        if (xp >= 0 && xp <= 9999) {
            op = "Recruit";
        } else if (xp >= 1000 && xp <= 4999) {
            op = "solder";
        } else if (xp >= 5000 && xp <= 9999) {
            op = "warrior";
        } else if (xp >= 10000 && xp <= 49999) {
            op = "captain";
        } else if (xp >= 50000) {
            op = "Ninja";
        }
        return op;
    }
}
