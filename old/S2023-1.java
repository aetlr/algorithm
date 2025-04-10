import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] fraction = sc.nextLine().split("/");
        int n = sc.nextInt();
        double x = (double) Integer.parseInt(fraction[0]) / Integer.parseInt(fraction[1]);
        System.out.printf("%." + (n - 1) + "f", x);
    }
}
