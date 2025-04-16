import java.util.*;

public class Main {
    static int N, M, firstX, firstY;
    static boolean[][] visited;
    static char[][] matrix;
    static int cnt = 0;
    static int[][] burnTime;
    static Queue<Point> fireQueue = new LinkedList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCnt = sc.nextInt();

        for (int i = 0; i < caseCnt; i++) {
            M = sc.nextInt();
            N = sc.nextInt();
            fireQueue = new LinkedList<>();
            firstX = 0;
            firstY = 0;
            matrix = new char[N][M];
            burnTime = new int[N][M];
            sc.nextLine();

            for (int j = 0; j < N; j++) {
                String line = sc.nextLine();
                for (int k = 0; k < line.length(); k++) {
                    char cur = line.charAt(k);
                    matrix[j][k] = cur;

                    if (cur == '*') {
                        fireQueue.add(new Point(j, k, 0));
                    }

                    if (cur == '@') {
                        firstX = j;
                        firstY = k;
                    }
                }


            }

            initBurnTime();
            int answer = bfs();
            System.out.println(answer != -1 ? answer + 1 : "IMPOSSIBLE");
        } // end


    }
    public static void initBurnTime() {
        visited = new boolean[N][M];
        burnTime = new int[N][M];
        int[][] delta = { {1, 0}, {-1, 0}, {0, -1}, {0, 1} };
        for (int i = 0; i < N; i++) {
            Arrays.fill(burnTime[i], -1);
        }

        while (!fireQueue.isEmpty()) {
            Point poll = fireQueue.poll();
            visited[poll.x][poll.y] = true;
            burnTime[poll.x][poll.y] = poll.depth;
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + delta[i][0];
                int ny = poll.y + delta[i][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && (matrix[nx][ny] == '.' || matrix[nx][ny] == '@') ) {
                    burnTime[nx][ny] = poll.depth + 1;
                    visited[nx][ny] = true;
                    fireQueue.add(new Point(nx, ny, burnTime[nx][ny]));
                }
            }
        }
    }

    public static int bfs() {
        visited = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(firstX, firstY, 0));
        visited[firstX][firstY] = true;
        int[][] delta = { {1, 0}, {-1, 0}, {0, -1}, {0, 1} };

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            visited[poll.x][poll.y] = true;

            if (poll.x == 0 || poll.x == N - 1 || poll.y == 0 || poll.y == M - 1) {
                return poll.depth;
            }
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + delta[i][0];
                int ny = poll.y + delta[i][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && (matrix[nx][ny] == '.' || matrix[nx][ny] == '@') && ( burnTime[nx][ny] > poll.depth + 1  || burnTime[nx][ny] == -1)) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, poll.depth + 1));
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

    Point(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}







