import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCnt = sc.nextInt();

        for (int i = 0; i < caseCnt; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();

            System.out.println(a * (x - 1) + b);
        }
    }
}