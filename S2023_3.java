import java.util.Scanner;

class Main {
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] numbers = new long[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextLong();
        }

        long result = numbers[0];
        for (int i = 1; i < N; i++) {
            result = gcd(result, numbers[i]);
        }

        System.out.println(result);
    }
}
