import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (true) {
            int x = sc.nextInt();

            if (x == 0) break;
            list.add(x);
        }


        int beforeNumber = list.get(0);
        int cnt = 1;

        for (int i = 1; i < list.size(); i++) {
            int curNumber = list.get(i);

            if (curNumber != beforeNumber) {
                System.out.print(cnt + " " + beforeNumber + " ");
                cnt = 1;
            }
            else {
                cnt++;
            }

            if (i == list.size() - 1) {
                System.out.print(cnt + " " + curNumber + " ");
            }

            beforeNumber = curNumber;
        }
    }
}
