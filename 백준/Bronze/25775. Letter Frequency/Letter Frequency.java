import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseCnt = Integer.parseInt(sc.nextLine());
        int listSize = 0;
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            list.add(new int[30]);
        }

        for (int i = 0; i < caseCnt; i++) {
            String line = sc.nextLine();
            listSize = Integer.max(listSize, line.length());
            for (int j = 0; j < line.length(); j++) {
                char curChar = line.charAt(j);
                list.get(j)[curChar - 97]++;
            }
        }

        main: for (int i = 0; i < listSize; i++) {
            int max = 0;
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < 26; j++) {
                max = Integer.max(list.get(i)[j], max);
            }

            for (int j = 0; j < 26; j++) {
                if (list.get(i)[j] == max && max > 0) {
                    System.out.print((char) (j + 97) + " ");
                }
                if (max <= 0) {
                    break;
                }
            }

            System.out.println();

        }






    }
}