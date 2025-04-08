import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static StringBuilder dfsSb = new StringBuilder();
    static StringBuilder bfsSb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCnt = sc.nextInt();
        int edgeCnt = sc.nextInt();
        int start = sc.nextInt();
        dfsVisited = new boolean[nodeCnt + 1];
        bfsVisited = new boolean[nodeCnt + 1];

        for (int i = 0; i <= nodeCnt; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCnt; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; i <= nodeCnt ; i++) {
            graph.get(i).sort(Integer::compareTo);
        }
        dfs(start);
        bfs(start);
        System.out.println(dfsSb.toString());
        System.out.println(bfsSb.toString());

    }

    public static void dfs(int n) {
        dfsVisited[n] = true;
        dfsSb.append(n + " ");
        for (int node : graph.get(n)) {
            if (!dfsVisited[node]) {
                dfs(node);
            }
        }
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        bfsVisited[n] = true;
        bfsSb.append(n).append(" ");
        queue.add(n);

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int node : graph.get(temp)) {
                if (!bfsVisited[node]) {
                    queue.add(node);
                    bfsVisited[node] = true;
                    bfsSb.append(node).append(" ");
                }
            }
        }

    }
}
