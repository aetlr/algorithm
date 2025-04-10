import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();	
		int q = 25; 
		int d = 10; 
		int n = 5; 
		int p = 1; 
		
		for (int i = 0; i < t; i++) {
			String ans = "";
			int x = sc.nextInt();
			ans += (x / q) + " ";
			x %= q;
			
			ans += (x / d) + " ";
			x %= d;
			
			ans += (x / n) + " ";
			x %= n;
			
			ans += (x / p) + " ";
			System.out.println(ans);
		}

	}
}
