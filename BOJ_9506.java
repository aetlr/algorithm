import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == -1) {
				break;
			}
			String exp = n + " = ";
			int sum = 0;
			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					exp += i + " + ";
					sum += i;
				}
			}
			
			
			if (n == sum) {
				System.out.println(exp.substring(0, exp.length() - 3));		
			}
			else {
				System.out.println(n + " is NOT perfect.");
			}
		
		}
	}
}
