import java.util.Queue;
import java.util.*;

public class Main {
    static long from, to;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        from = sc.nextInt();
        to = sc.nextInt();

        long answer = bfs();
        System.out.println(answer != -1 ? answer + 1 : -1);
    }

    static long bfs() {
        Queue<long[]> queue = new LinkedList<>();

        queue.add(new long[] {from, 0});

        while (!queue.isEmpty()) {
            long[] poll = queue.poll();
            if (poll[0] == to) {
                return poll[1];
            }
            if ((poll[0] * 2) <= to) {
                queue.add(new long[] {poll[0] * 2, poll[1] + 1});
            }
            long nx = poll[0] * 10 + 1;
            if (nx <= to) {
                queue.add(new long[] {nx, poll[1] + 1});
            }
        }
    return -1;
    }
}
