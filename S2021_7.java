import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        for (int i = 0; i < cnt; i++) {
            int target = sc.nextInt();
            int coinType = sc.nextInt();
            int[] coins = new int[coinType];
            for (int j = 0; j < coinType; j++) {
                coins[j] = sc.nextInt();
            }

            Arrays.sort(coins);
            int count = 0;
            int idx = coinType - 1;

            while (target > 0 && idx >= 0) {
                if (coins[idx] <= target) {
                    int num = target / coins[idx];
                    count += num;
                    target -= coins[idx] * num;
                }
                idx--;
            }

            if (target == 0) {
                System.out.println(count);
            } else {
                System.out.println(-1);
            }
        }
    }
}
