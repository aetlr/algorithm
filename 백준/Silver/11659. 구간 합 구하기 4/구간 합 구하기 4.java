import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberCnt = Integer.parseInt(st.nextToken());
        int caseCnt = Integer.parseInt(st.nextToken());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] prefixSum = new int[numberCnt + 1];


        for (int i = 1; i <= numberCnt; i++) {
            prefixSum[i] = prefixSum[i - 1] + numbers[i - 1];
        }

        for (int i = 0; i < caseCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(prefixSum[end] - prefixSum[start - 1]).append("\n");

        }

        System.out.println(sb);
    }
}