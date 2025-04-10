import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solution(n, k));
	}
	
	public static int solution(int n, int k) {
		int cnt = 1;
		ArrayList<Integer> arr = new ArrayList<>();
		while (cnt <= n) {
			if ((n % cnt) == 0) {
				arr.add(cnt);
			}
			cnt++;
		}
		if (arr.size() >= k) {
			return arr.get(k - 1);
		}
		else {
			return 0;
		}
	}
}
