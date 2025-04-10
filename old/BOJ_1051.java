import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		String[][] arr = new String[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine().split("");
		}
		
		int maxSize = Math.min(n, m) - 1;
		int max = Integer.MIN_VALUE;
		for (int x = maxSize; x >= 0; x--) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if ((i + x) >= n || (j + x) >= m ) break;
					if (arr[i][j].equals(arr[i][j + x]) && arr[i][j].equals(arr[i + x][j + x]) && arr[i][j].equals(arr[i + x][j])) {
						if ((x + 1) * (x + 1) > max) {
							max = (x + 1) * (x + 1);
						}
						break;

					}
				}
			}
		}		
		System.out.println(max);
	}
}
