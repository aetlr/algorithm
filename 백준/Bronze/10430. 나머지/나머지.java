import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String str = sc.nextLine();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // int tmp = 10;
        // int sum = 0;
        // int shift = 1;

        // for(int i = 0; i < 3; i++) {
        //     System.out.println(a*(b%tmp));
            
        //     sum += a*(b%tmp) * shift;
        //     // System.out.println("합: "+sum);

        //     b = b/tmp;
        //     shift *= 10;
        // }
        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C) * (B%C))%C);
    }
}