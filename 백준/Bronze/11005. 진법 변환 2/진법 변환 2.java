import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        ArrayList<Character> lit = new ArrayList<>();

        while (N > 0) {
            if (N % B < 10) { 
            	lit.add( (char) (N % B + '0') ); 
            }
            else { 
            	lit.add( (char) (N % B - 10 + 'A') ); 
            }
            N /= B; 
        }

        for (int i = lit.size() - 1; i >= 0; i--) { 
            System.out.print(lit.get(i));
        }
    }
}