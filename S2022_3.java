import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCnt = sc.nextInt();
        int cnt = 0;
        int[] arr = new int[numCnt];
        for (int i = 0; i < numCnt; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < numCnt - 3; i++) {
            int[] copyArray = Arrays.copyOfRange(arr, i, i + 4);
            if (isContinues(copyArray)) {
                Loop1:
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (isPrime(copyArray[j] + copyArray[k])) {
                            cnt++;
                            break Loop1;
                        }
                    }
                }

            }
        }

        System.out.println(cnt);

    }

    public static boolean isContinues ( int[] array){
        int gap = array[1] - array[0];
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] != gap) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
