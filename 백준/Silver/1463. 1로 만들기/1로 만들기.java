import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] d = new int[1000001];

        d[1] = 0;

        for (int i = 2; i <= 1000000; i++) {
            d[i] = d[i-1] + 1;
            if (i % 3 == 0) {
                d[i] = Integer.min(d[i / 3] + 1, d[i]);
            }
            if (i % 2 == 0) {
                d[i] = Integer.min(d[i / 2] + 1, d[i]);
            }
        }

        System.out.println(d[sc.nextInt()]);

    }


}