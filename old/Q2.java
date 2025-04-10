package _2023;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] fib = new long[91];
        fib[0] = 1;
        fib[1] = 1;

        for (int i = 2; i <= N; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println(fib[N]);
    }
}
