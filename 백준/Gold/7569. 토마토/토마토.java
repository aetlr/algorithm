import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][][] matrix;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int N, M, H;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        int zeroCount = 0;

        matrix = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int temp = sc.nextInt();
                    matrix[i][j][k] = temp;

                    if (temp == 1) {
                        queue.add(new int[] {i, j, k, 0});
                    }
                    else if (temp == 0) {
                        zeroCount++;
                    }

                }
            }
        }

        if (zeroCount > 0) {
            bfs();
        }
        int answer = 0;
        boolean flag = false;


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    answer = Math.max(answer, matrix[i][j][k]);
                    if (matrix[i][j][k] == 0) {
                        flag = true;
                    }
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
        int[][] direction = { {1, 0, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, 1}, {0, 0, -1} }; // 상, 하, 좌, 우, 앞, 뒤

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int curH = temp[0];
            int curX = temp[1];
            int curY = temp[2];
            int depth = temp[3];
            visited[curH][curX][curY] = true;
            if (depth == 0) {
                matrix[curH][curX][curY] = 1;
            }
            else {
                matrix[curH][curX][curY] = depth;
            }
            for (int i = 0; i < 6; i++) {
                int nextH = curH + direction[i][0];
                int nextX = curX + direction[i][1];
                int nextY = curY + direction[i][2];

                if (nextH >= 0 && nextH < H && nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visited[nextH][nextX][nextY] && matrix[nextH][nextX][nextY] == 0) {
                    visited[nextH][nextX][nextY] = true;
                    queue.add(new int[] {nextH, nextX, nextY, depth + 1});
                }
            }
        }
    }
}