import java.util.*;

public class Main {
    static long m, max;
    static int n;
    static long[] stick;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextLong();
        max = Long.MIN_VALUE;
        stick = new long[n];

        for (int i = 0; i < n; i++) {
            stick[i] = sc.nextLong();
            max = Math.max(stick[i], max);
        }



        long low = 0;
        long hi = max;
        while (low + 1 < hi) {
            long mid = (low + hi) / 2;
            if (check(mid)) {
                low = mid;
            }
            else {
                hi = mid;
            }
        }

        System.out.println(low);
    }

    static boolean check(long height) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max((stick[(int) i] - height), 0);
        }
        return sum >= m;
    }
}