package dp;

//Arrange Buildings Dynamic Programming
public class ArrangeBuildings {
    public static void main(String[] args) {
        int plots = 5;
        int count = buildColoney(plots);
        System.out.println(count);
    }

    private static int buildColoney(int plots) {

        int b_arr[] = new int[plots + 1];
        int s_arr[] = new int[plots + 1];

        b_arr[1] = 1;
        s_arr[1] = 1;

        for (int i = 2; i <= plots; i++) {
            b_arr[i] = s_arr[i - 1];
            s_arr[i] = s_arr[i - 1] + b_arr[i - 1];
        }

        int count = b_arr[plots] + s_arr[plots];

        return count * count;
    }
}
