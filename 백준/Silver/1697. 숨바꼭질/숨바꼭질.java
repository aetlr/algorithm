import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static boolean[] visited = new boolean[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(bfs(N, K));
    }

    public static int bfs(int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0});
        visited[n] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curTime = cur[1];

            if (curX == k) {
                return curTime;
            }

            if ((curX + 1) <= 100000 && !visited[(curX + 1)]) {
                visited[curX + 1] = true;
                queue.add(new int[] {curX + 1, curTime + 1});
            }
            if ((curX - 1) >= 0 && !visited[(curX - 1)]) {
                visited[curX - 1] = true;
                queue.add(new int[] {curX -1, curTime + 1});
            }
            if ((2 * curX) <= 100000 && !visited[(2 * curX )]) {
                visited[2 * curX] = true;
                queue.add(new int[] {2 * curX, curTime + 1});
            }
        }
        return -1;
    }
}