
import java.sql.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCnt = sc.nextInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < caseCnt; i++) {
            int equalsCnt = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                list.add(sc.nextInt());
            }

            Collections.sort(list, Collections.reverseOrder());
            int compare = list.get(0);
            for (int j = 0; j < 3; j++) {
                if (list.get(j).equals(compare)) {
                    equalsCnt++;
                }
            }

            if (equalsCnt == 3) {
                answer.add(10000 + (compare * 1000));
            }
            else if (equalsCnt == 2) {
                answer.add(1000 + (compare * 100));
            }
            else {
                answer.add(list.get(0) * 100);
            }
        }

        Collections.sort(answer, Collections.reverseOrder());
        System.out.println(answer.get(0));
    }
}
