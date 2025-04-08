import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCnt = sc.nextInt();
        int edgeCnt = sc.nextInt();
        int start = sc.nextInt();
        visited = new boolean[nodeCnt + 1];
        order = new int[nodeCnt + 1];
        Arrays.fill(order, 0);
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
        for (int i = 1; i <= nodeCnt; i++) {
            System.out.print(order[i] + " ");
        }


    }

    public static void dfs(int n) {
        visited[n] = true;
        order[n] = cnt++;
        for (int node : graph.get(n)) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

}
