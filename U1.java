import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        BigInteger y = BigInteger.valueOf(2);
        System.out.println(y.pow(x).subtract(new BigInteger(String.valueOf(1))));

    }
}
