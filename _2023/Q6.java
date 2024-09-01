package _2023;

import java.util.ArrayList;
import java.util.Scanner;

public class Q6 {
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> network;
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = sc.nextInt();

        network = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            network.add(new ArrayList<>());
        }

        for (int i = 0; i < P; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            network.get(a).add(b);
            network.get(b).add(a);
        }

        int T = sc.nextInt();

        visited = new boolean[N + 1];

        dfs(T);

        System.out.println(cnt - 1);

        sc.close();
    }

    private static void dfs(int computer) {
        visited[computer] = true;
        cnt++;

        for (int x : network.get(computer)) {
            if (!visited[x]) {
                dfs(x);
            }
        }
    }
}
