import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int ln = 1;

		while (x > ln) {
			x -= ln;
			ln++;
		}
		if (ln % 2 == 0) {
			System.out.println(x + "/" + (ln - x + 1));
		}
		else {
			System.out.println(ln - x + 1 + "/" + x);
		}

	}
}
