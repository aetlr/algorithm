import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < 6; j++) {
                String start = sc.next();
                String end = sc.next();

                int startHour = Integer.parseInt(start.split(":")[0]);
                int startMinute = Integer.parseInt(start.split(":")[1]);
                int startSecond = Integer.parseInt(start.split(":")[2]);

                int endHour = Integer.parseInt(end.split(":")[0]);
                int endMinute = Integer.parseInt(end.split(":")[1]);
                int endSecond = Integer.parseInt(end.split(":")[2]);

                int remainHour = 24 - startHour + endHour;
                int remainMinute = Math.abs(startMinute - endMinute);
                int remainSecond = Math.abs(startSecond - endSecond);

                System.out.println(remainHour + ":" + remainMinute + ":" + remainSecond);

            }
        }
    }
}
