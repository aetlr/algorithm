import java.util.*;

public class Main {
    static boolean[][] visited;
    static char[][] matrix;
    static char[][] blindMatrix;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new char[n][n];
        visited = new boolean[n][n];
        int normalCnt = 0;
        int blindCnt = 0;

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                char cur = line.charAt(j);
                matrix[i][j] = cur;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, matrix[i][j]);
                    normalCnt++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'G') {
                    matrix[i][j] = 'R';
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, matrix[i][j]);
                    blindCnt++;
                }
            }
        }

        System.out.println(normalCnt);
        System.out.println(blindCnt);

    }

    public static void bfs(int x, int y, char ch) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] delta = { {1, 0}, {-1, 0}, {0, -1}, {0, 1} };
        visited[x][y] = true;
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int curX = temp[0];
            int curY = temp[1];

            for (int i = 0; i < 4; i++) {
                int nextX = curX + delta[i][0];
                int nextY = curY + delta[i][1];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY] && matrix[nextX][nextY] == ch) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

    }

}