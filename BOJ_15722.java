import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dX = {1, -1};
        int[] dY = {1, -1};
        int x = 0;
        int y = 0;
        int time = sc.nextInt();
        int multi = 1;
        int dir = 0;
        
        while (true) {

            for (int i = 0; i < multi; i++) {
                if (time > 0) {
                    time--;
                    y += dX[dir];

                }
                else {
                    break;
                }
            }
            for (int i = 0; i < multi; i++) {
                if (time > 0) {
                    time--;
                    x += dY[dir];

                }
                else {
                    break;
                }
            }
            
            if (time > 0) {
                dir++;
                multi++;
            }
            else {
                break;
            }
            if (dir >= 2) {
                dir = 0;
            }

        }
        
        System.out.println(x + " " + y);
    }
}
