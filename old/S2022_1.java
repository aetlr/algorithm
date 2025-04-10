import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCnt = sc.nextInt();
        double totalDist = 0;
        int totalTime = 0;
        for (int i = 0; i < caseCnt; i++) {
            int speed = sc.nextInt();
            int time = strToSec(sc.next());
            totalDist += (double) speed * time / 3600.0; 
            totalTime += time;
        }
        System.out.printf("%.2f\n", totalDist / (totalTime / 3600.0));
    }

    public static int strToSec(String str) {
        int sec = 0;
        String[] times = str.split(":");
        sec += Integer.parseInt(times[0]) * 3600;
        sec += Integer.parseInt(times[1]) * 60;
        sec += Integer.parseInt(times[2]);
        return sec;
    }
}
