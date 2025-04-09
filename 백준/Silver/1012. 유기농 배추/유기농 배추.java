import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static boolean[][] visited;
    public static int[][] graph;
    public static int[][] direction = { {1, 0}, {-1, 0}, {0, -1}, {0, 1} }; // 상 하 좌 우
    public static int height;
    public static int width;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCnt = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < caseCnt; i++) {
            width = sc.nextInt();
            height = sc.nextInt();
            int cabbageCnt = sc.nextInt();
            graph = new int[height][width];
            visited = new boolean[height][width];
            int unionCnt = 0;
            for (int j = 0; j < cabbageCnt; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                graph[y][x] = 1;
            }


            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    if (graph[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        unionCnt++;

                    }
                }
            }
            System.out.println(unionCnt);
        }


    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            if (nextX >= 0 && nextX < height && nextY >= 0 && nextY < width && !visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                dfs(nextX, nextY);
            }
        }
    }
}

