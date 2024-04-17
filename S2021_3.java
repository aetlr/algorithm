import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int xArr[] = new int[cnt];
        int yArr[] = new int[cnt];
        int score = 0;
        for (int i = 0; i < cnt; i++) {
            xArr[i] = sc.nextInt();
        }
        for (int i = 0; i < cnt; i++) {
            yArr[i] = sc.nextInt();
        }
        for (int i = 0; i < cnt; i++) {
            int x = xArr[i];
            int y = yArr[i];
            int area = Math.abs(x) * Math.abs(y);

            if (x >= 0 && y >= 0 || x <= 0 && y <= 0) {
                score += area;
            } else {
                score -= area;
            }
            System.out.println(score);
        }
    }
}
