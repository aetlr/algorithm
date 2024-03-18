import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int bombCnt = sc.nextInt();

        sc.nextLine();
        String[][] map = new String[h][w];
        for (int i = 0; i < h; i++) { 
            for (int j = 0; j < w; j++) {
                map[i][j] = "0";
            }
        }
        int[][] dLoc = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int i = 0; i < bombCnt; i++) {
            char[] loc = sc.nextLine().toCharArray();
            int bombX = Integer.parseInt(String.valueOf(loc[1]));
            int bombY = Integer.parseInt(String.valueOf(loc[3]));
            map[bombY][bombX] = "X";
            for (int j = 0; j < 8; j++) {
                int moveX = bombX + dLoc[j][0];
                int moveY = bombY + dLoc[j][1];
                if (moveX >= 0 && moveX < w && moveY >= 0 && moveY < h) {
                    if (!"X".equals(map[moveY][moveX])) {
                        int update = Integer.parseInt(map[moveY][moveX]) + 1;
                        map[moveY][moveX] = String.valueOf(update);
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
