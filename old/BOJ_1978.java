import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		int prime = 0;
		for (int i = 0; i < loop; i++) {
			if (prime(sc.nextInt())) {
				prime++;
			}
		}
		System.out.println(prime);
	}
	
	public static boolean prime(int x) {
		if (x == 1 ) {
			return false;
		}
		for (int i = 2; i < x; i++) {
			if ((x % i) == 0) {
				return false;
			}
		}
		return true;
	}
}
