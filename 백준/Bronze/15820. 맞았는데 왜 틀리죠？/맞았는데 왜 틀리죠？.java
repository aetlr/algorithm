import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cnt = sc.nextLine();

        int sample = Integer.parseInt(cnt.split(" ")[0]);
        int system = Integer.parseInt(cnt.split(" ")[1]);
        boolean sampleAnswer = true;
        boolean systemAnswer = true;

        for (int i = 0; i < sample; i++) {
            String line = sc.nextLine();
            if (!line.split(" ")[0].equals(line.split(" ")[1])) {
                sampleAnswer = false;
            }
        }
        for (int i = 0; i < system; i++) {
            String line = sc.nextLine();
            if (!line.split(" ")[0].equals(line.split(" ")[1])) {
                systemAnswer = false;
            }
        }

        if (sampleAnswer && systemAnswer) {
            System.out.println("Accepted");
        }
        else if (!sampleAnswer) {
            System.out.println("Wrong Answer");
        }
        else if (sampleAnswer && !systemAnswer) {
            System.out.println("Why Wrong!!!");
        }

    }
}