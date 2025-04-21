import java.util.*;

public class Main {
    static int n, m;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] matrix;
    static int[][] dist;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        matrix = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            line = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                if (line[j].equals("2")) {
                    queue.add(new int[] {i, j, 0});
                }
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    System.out.print(dist[i][j] + " ");
                }
                else if (!visited[i][j] && matrix[i][j] == 1) {
                    System.out.print(-1 + " ");
                }
                else {
                    System.out.print(dist[i][j] + " ");

                }

            }
            System.out.println();
        }

    }

    static void bfs() {
        int[][] delta = { {1, 0}, {-1, 0}, {0, -1}, {0, 1} };

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            visited[poll[0]][poll[1]] = true;
            dist[poll[0]][poll[1]] = poll[2];

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + delta[i][0];
                int ny = poll[1] + delta[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && matrix[nx][ny] == 1) {
                    queue.add(new int[] {nx, ny, poll[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}