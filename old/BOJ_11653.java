import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] prime = new boolean[10001];
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i <= Math.sqrt(10001); i++) {
			int j = 2;
			while (i * j <= 10000) {
				prime[i * j] = true;
				j += 1;
			}
		}
		
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = M; i <= N; i++) {
			if (!prime[i]) {
				sum += i;
				if (i < min) {
					min = i;
				}
			}
		}
		
		
		if (sum != 0) {
			System.out.println(sum);
			System.out.println(min);
		}
		else {
			System.out.println(-1);
		}
	}
}
