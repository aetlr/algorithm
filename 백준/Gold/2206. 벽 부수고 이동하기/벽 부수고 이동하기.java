import java.util.LinkedList;
import java.util.*;

public class Main {
    public static boolean[][][] visited;
    public static int[][] matrix;
    public static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        matrix = new int[N][M];
        visited = new boolean[2][N][M];
        sc.nextLine();


        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                int cur = Integer.parseInt(String.valueOf(line.charAt(j)));
                matrix[i][j] = cur;
            }
        }
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        int[][] delta = { {1, 0}, {-1, 0}, {0, -1}, {0, 1} };
        Queue<Point> queue = new LinkedList<>();
        
        queue.add(new Point(x, y, 1, 0));

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            visited[poll.destroyed][poll.x][poll.y] = true;
            if (poll.x == (N - 1) && poll.y == (M - 1)) {
                return poll.depth;
            }
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + delta[i][0];
                int ny = poll.y + delta[i][1];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (poll.destroyed == 0) { 
                    if (matrix[nx][ny] == 1 && !visited[1][nx][ny]) { 
                        visited[1][nx][ny] = true;
                        queue.add(new Point(nx, ny, poll.depth + 1, 1));
                    }
                    else if (matrix[nx][ny] == 0 && !visited[0][nx][ny]) {
                        visited[0][nx][ny] = true;
                        queue.add(new Point(nx, ny, poll.depth + 1, 0));
                    }
                }
                else if (poll.destroyed == 1) {
                    if (matrix[nx][ny] == 0 && !visited[1][nx][ny]) {
                        visited[1][nx][ny] = true;
                        queue.add(new Point(nx, ny, poll.depth + 1, 1));
                    }
                }
            }
        }
        return -1;

    }
}

class Point {
    int x;
    int y;
    int depth;
    int destroyed;
    
    Point(int x, int y, int depth, int destroyed) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.destroyed = destroyed;
    }
}