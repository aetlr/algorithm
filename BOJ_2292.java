import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int cnt = 1;
		int sum = 1;
		
		while (x > sum) {
			sum += cnt * 6;
			cnt++;
		}
		System.out.println(cnt);
	}
}
