import java.util.Scanner;

public class Main {
    static int multipilier[] = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cnt; i++) {
            String number = sc.nextLine();
            int check = getValidate(number);
            int lastNumber = Integer.parseInt(String.valueOf(number.charAt(12)));
            if (check == lastNumber) {
                System.out.println(check + " " + "O");
            } else {
                System.out.println(check + " " + "X");
            }
        }
    }

    static int getValidate(String number) {
        number = number.replace("-", "");
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int cur = Integer.parseInt(String.valueOf(number.charAt(i)));
            sum += cur * multipilier[i];
        }
        int check = 11 - (sum % 11);
        if (check == 10) { check = 0; } if (check == 11) { check = 1; }
        return check;
    }
}
