import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double height = sc.nextDouble();
        height = (height / 100) * (height / 100);
        double kg = sc.nextDouble();
        double bmi = kg / height;

        bmi = Math.round(bmi * 10.0) / 10.0;
        System.out.println(bmi);
        if (bmi < 18.5) {
            System.out.println("UW");
        } else if (bmi < 25) {
            System.out.println("N");
        } else if (bmi < 30) {
            System.out.println("OW");
        } else if (bmi < 35) {
            System.out.println("OB");
        } else {
            System.out.println("EO");
        }
    }
}
