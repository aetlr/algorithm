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
            graph.get(i).sort(Comparator.reverseOrder());
        }
        bfs(start);
        for (int i = 1; i <= nodeCnt; i++) {
            System.out.println(order[i]);
        }


    }

    public static void bfs(int n) {
        visited[n] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        order[n] = cnt++;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int node : graph.get(temp)) {
                if (!visited[node]) {
                    order[node] = cnt++;
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
    }

}
