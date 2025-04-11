import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseCnt = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < caseCnt; i++) {
            String[] cmd = br.readLine().split(" ");
            String op = cmd[0];
            int operand = 0;
            if (cmd.length == 2) {
                operand = Integer.parseInt(cmd[1]);
            }

            if (op.equals("add")) {
                set.add(operand);
            }

            if (op.equals("remove")) {
                set.remove(operand);
            }

            if (op.equals("check")) {
                sb.append(set.contains(operand) ? 1 : 0).append("\n");
            }

            if (op.equals("toggle")) {
                if (set.contains(operand)) {
                    set.remove(operand);
                }
                else {
                    set.add(operand);
                }
            }

            if (op.equals("all")) {
                set.clear();

                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            }

            if (op.equals("empty")) {
                set.clear();
            }

        }
        System.out.println(sb.toString());;
    }
}