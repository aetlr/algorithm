package _2023;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float s = 0.0F;
        for (int i = 0; i < n; i++) {
            s += sc.nextFloat();
        }
        System.out.println(s);
        System.out.printf("%.1f", s / n);
    }
}
