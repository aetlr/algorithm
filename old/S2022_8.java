import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int line = (x * (x + 1)) / 2 + 1;
        System.out.println(line);
    }
}
