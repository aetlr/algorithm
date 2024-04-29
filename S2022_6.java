import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.offer(sc.nextInt());
        }

        int comp = 0;
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            comp += sum;
            pq.offer(sum);
        }

        System.out.println(comp);
    }
}
