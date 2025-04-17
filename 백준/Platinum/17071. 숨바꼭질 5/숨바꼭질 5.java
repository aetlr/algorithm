import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        System.out.println(bfs());
        
    }

    public static int getBrotherPos(int time) {
        return K + (time * (time + 1) / 2);
    }

    public static int bfs() {
        if (N == K) {
            return 0;
        }
        boolean[][] visited = new boolean[2][500000 + 1];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (getBrotherPos((poll.depth)) > 500000) {
                return -1;
            }
            if (visited[poll.depth % 2][getBrotherPos(poll.depth)]) {
                return poll.depth;
            }
            int nx = poll.x + 1;

            if (nx >= 0 && nx <= 500000 && !visited[(poll.depth + 1) % 2][nx]) {
                queue.add(new Point(nx, poll.depth + 1));
                visited[(poll.depth + 1) % 2][nx] = true;
            }

            nx = poll.x - 1;
        
            if (nx >= 0 && nx <= 500000 && !visited[(poll.depth + 1) % 2][nx]) {
                queue.add(new Point(nx, poll.depth + 1));
                visited[(poll.depth + 1) % 2][nx] = true;
            }
        
            nx = poll.x * 2;

            if (nx >= 0 && nx <= 500000 && !visited[(poll.depth + 1) % 2][nx]) {
                queue.add(new Point(nx, poll.depth + 1));
                visited[(poll.depth + 1) % 2][nx] = true;
            }

        };

        return -1;
    }
}

class Point {
    int x;
    int depth;

    Point(int x, int depth) {
        this.x = x;
        this.depth = depth;
    }
}