import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseCnt = Integer.parseInt(br.readLine());
		int[] arr = new int[caseCnt];
		for (int i = 0; i < caseCnt; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int compare = 0;
		int cnt = 0;
		for (int i = arr.length; i > 0; i--) {
			if (arr[i - 1] > compare) {
				cnt++;
				compare = arr[i - 1];
			}
		}
		System.out.println(cnt);
	}
}