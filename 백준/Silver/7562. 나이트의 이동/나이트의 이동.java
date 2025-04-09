import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][] delta = { {2, -1}, {2, 1}, {1, -2}, {-1, -2}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1} };
    public static boolean[][] visited;
    public static int l;

    public static int targetX, targetY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCnt = sc.nextInt();
        for (int i = 0; i < caseCnt; i++) {
            l = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            visited = new boolean[l][l];
            targetX = sc.nextInt();
            targetY = sc.nextInt();
            System.out.println(bfs(x, y));
        }
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {x, y, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int dist = cur[2];
            if (curX == targetX && curY == targetY) {
                return dist;
            }
            for (int i = 0; i < 8; i++) {
                int nextX = curX + delta[i][0];
                int nextY = curY + delta[i][1];

                if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY, dist + 1});
                }
            }
        }
        return -1;
    }

}