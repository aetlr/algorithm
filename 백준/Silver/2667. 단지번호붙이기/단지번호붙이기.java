import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[][] direction = { {1, 0}, {-1, 0}, {0, -1}, {0, 1} }; // 상 하 좌 우
    static int[] countArray;
    static int cnt = 0;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        countArray = new int[(int) Math.pow(N, 2)];
        int[] answer;
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                int current = Integer.parseInt(String.valueOf(line.charAt(j)));
                graph[i][j] = current;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int current = graph[i][j];
                if (current != 0 && !visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }


        answer = new int[cnt + 1];
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int current = graph[i][j];
                if (current != 0) {
                    answer[current] += 1;
                }
            }
        }

        for (int i = 1; i <= cnt; i++) {
            answerList.add(answer[i]);
        }

        Collections.sort(answerList);

        System.out.println(answerList.size());
        answerList.forEach(System.out::println);

    }

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        graph[x][y] = cnt;
        countArray[cnt] += 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visited[nextX][nextY] && graph[nextX][nextY] != 0) {
                graph[nextX][nextY] = cnt;
                bfs(nextX, nextY);
            }
        }
    }
}
