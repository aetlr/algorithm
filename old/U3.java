import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cardCnt = sc.nextInt();

        int case1Price = sc.nextInt();
        int case1Capaticy = sc.nextInt();
        int case2Price = sc.nextInt();
        int case2Capaticy = sc.nextInt();

        int case1Cnt = cardCnt / case1Capaticy;
        int remainCard = cardCnt % case1Capaticy;

        int case2Cnt = remainCard / case2Capaticy;
        remainCard = remainCard % case2Capaticy;

        if (remainCard == 0) {
            System.out.println(case1Cnt + " " + case2Cnt);
        }
        else {
            System.out.println("Not Full");
        }


    }
}
