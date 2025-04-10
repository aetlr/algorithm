package _2023;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String two = Integer.toBinaryString(N);

        String three = Integer.toString(N, 3);

        String four = Integer.toString(N, 4);

        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
    }
}
