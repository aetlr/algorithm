import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCnt = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < caseCnt; i++) {
            int round = Integer.parseInt(sc.nextLine());
            int x = 0;
            int y = 0;

            for (int j = 0; j < round; j++) {

                String[] game = sc.nextLine().split(" ");
                String k = game[0];
                String l = game[1];

                if (k.equals("R") && l.equals("S")) {
                    x++;
                }
                else if (k.equals("S") && l.equals("R")) {
                    y++;
                }

                if (k.equals("S") && l.equals("P")) {
                    x++;
                }
                else if (k.equals("P") && l.equals("S")) {
                    y++;
                }

                if (k.equals("P") && l.equals("R")) {
                    x++;
                }
                else if (k.equals("R") && l.equals("P")) {
                    y++;
                }
            }

            String answer = (x != y) ? ((x > y) ? "Player 1" : "Player 2") : "TIE";
            System.out.println(answer);
        }
    }
}