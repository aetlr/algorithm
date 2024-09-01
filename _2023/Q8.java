package _2023;

import java.util.*;

public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] blocks = new int[N][2];

        for (int i = 0; i < N; i++) {
            blocks[i][0] = sc.nextInt();
            blocks[i][1] = sc.nextInt(); 
        }

        Arrays.sort(blocks, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        long widthSum = 0;
        long minArea = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int width = blocks[i][0];
            int height = blocks[i][1];

            minHeap.offer(height);
            widthSum += width;

            if (minHeap.size() > K) {
                widthSum -= blocks[i - K][0];
                minHeap.poll();
            }

            if (minHeap.size() == K) {
                int maxHeight = minHeap.peek();
                minArea = Math.min(minArea, widthSum * maxHeight);
            }
        }

        System.out.println(minArea);
    }
}
