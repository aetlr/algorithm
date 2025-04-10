import java.util.Scanner;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < cnt; i++) {
            int n = sc.nextInt();
            int[] numbers = new int[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = sc.nextInt();
            }
            sc.nextLine();

            calculate(numbers, n, 1, numbers[0]);
            System.out.println(max);
            System.out.println(min);
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }
    }

    static void calculate(int[] numbers, int n, int index, int result) {
        if (index == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        calculate(numbers, n, index + 1, result * numbers[index]);
        calculate(numbers, n, index + 1, result + numbers[index]);
        calculate(numbers, n, index + 1, result - numbers[index]);
    }
}
