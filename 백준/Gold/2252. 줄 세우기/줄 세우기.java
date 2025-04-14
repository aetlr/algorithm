import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) dfs(i);
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop()).append(" ");
        }
        System.out.println(answer);



    }

    static void dfs(int n) {
        visited[n] = true;

        for (int neighbor : graph.get(n)) {
            if (!visited[neighbor]) dfs(neighbor);
        }

        stack.add(n);
    }
}