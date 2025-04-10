package _2023;

import java.util.*;

public class Q7 {
    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] grid = new int[N][N];
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, grid[0][0]));
        dist[0][0] = grid[0][0];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int x = current.x;
            int y = current.y;
            int currentCost = current.cost;

            if (x == N - 1 && y == N - 1) {
                System.out.println(currentCost);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int newCost = currentCost + grid[nx][ny];

                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.add(new Node(nx, ny, newCost));
                    }
                }
            }
        }
    }
}
