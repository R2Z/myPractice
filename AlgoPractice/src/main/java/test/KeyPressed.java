package test;

public class KeyPressed {

    public static void main(String[] args) {
        int releaseTimes[] = {12, 23, 36, 46, 62};
        String keysPressed = "spuda";
        /*int releaseTimes[] = {1,2};
        String keysPressed = "ba";*/
        System.out.println("maxChar " + slowestKey(releaseTimes, keysPressed));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        char chars[] = keysPressed.toCharArray();
        int maxTime = releaseTimes[0];
        char maxChar = chars[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time >= maxTime) {
                if(time == maxTime && maxChar < chars[i]){
                    maxChar = chars[i];
                }else if (time > maxTime){
                    maxChar = chars[i];
                }
                maxTime = time;
            }
        }
        return maxChar;
    }
}
