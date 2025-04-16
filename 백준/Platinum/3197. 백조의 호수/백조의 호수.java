import java.util.*;

public class Main {
    static char[][] matrix;
    static int[][] meltTime;
    static int R, C;
    static int lastMelt = 0;
    static Point swanX, swanY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        matrix = new char[R][C];
        meltTime = new int[R][C];
        Queue<Point> waterQueue = new LinkedList<>();
        sc.nextLine();

        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                char cur = line.charAt(j);
                matrix[i][j] = cur;
                if (cur == '.') {
                    waterQueue.add(new Point(i, j));
                }
                if (cur == 'L') {
                    waterQueue.add(new Point(i, j));
                    if (swanX == null) {
                        swanX = new Point(i, j);
                    }
                    else {
                        swanY = new Point(i, j);
                    }
                }
            }
        }
        initMeltTime(waterQueue);

        int low = 0;
        int high = lastMelt;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (canMeet(mid)) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        System.out.println(low + 1);

    }

    static boolean canMeet(int time) {
        int[][] delta = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        boolean[][] visited = new boolean[R][C];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(swanX.x, swanX.y));
        visited[swanX.x][swanX.y] = true;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.x == swanY.x && cur.y == swanY.y) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + delta[i][0];
                int ny = cur.y + delta[i][1];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && meltTime[nx][ny] <= time && !visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }

            }
        }

        return false;

    }

    static void initMeltTime(Queue<Point> waterQueue) {
        int[][] delta = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

        while (!waterQueue.isEmpty()) {
            Point cur = waterQueue.poll();
            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && (matrix[nx][ny] == 'X')) {
                    meltTime[nx][ny] = meltTime[x][y] + 1;
                    lastMelt = Math.max(lastMelt, meltTime[nx][ny]);
                    matrix[nx][ny] = '.';
                    waterQueue.add(new Point(nx, ny));
                }
            }
        }
    }
}
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}