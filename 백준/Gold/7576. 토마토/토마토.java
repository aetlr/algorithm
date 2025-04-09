import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][] matrix;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int N, M;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        int zeroCount = 0;

        matrix = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int temp = sc.nextInt();
                matrix[i][j] = temp;

                if (temp == 1) {
                    queue.add(new int[] {i, j, 0});
                }
                if (temp == 0) {
                    zeroCount++;

                }
            }
        }
        if (zeroCount > 0) {
            bfs();
        }
        int answer = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer = Math.max(answer, matrix[i][j]);
                if (matrix[i][j] == 0) {
                    flag = true;
                }
            }
        }
        if (flag) {
            System.out.println(-1);
        }
        else if (zeroCount == 0) {
            System.out.println(0);
        }
        else {
            System.out.println(answer);
        }
    }

    public static void bfs() {
        int[][] direction = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int curX = temp[0];
            int curY = temp[1];
            int depth = temp[2];
            visited[curX][curY] = true;
            if (depth == 0) {
                matrix[curX][curY] = 1;
            }
            else {
                matrix[curX][curY] = depth;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = curX + direction[i][0];
                int nextY = curY + direction[i][1];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextX][nextY] && matrix[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY, depth + 1});
                }
            }
        }
    }
}