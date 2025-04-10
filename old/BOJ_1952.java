import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[][] visited = new boolean[M][N];
		int[] dX = {0, 1, 0, -1};
		int[] dY = {1, 0, -1, 0};
		int curX = 0, curY = 0;
		int tempX, tempY;
		int sum = 1, turnCnt = 0, dir = 0;

		
		while (true) {
		    
		    if (sum == M * N) {
                System.out.println(turnCnt);
		        break;
		    }
		    
		    tempX = curX + dX[dir];
		    tempY = curY + dY[dir];
		    
		    if (tempX >=0 && tempX < M && tempY >= 0 && tempY < N && !visited[tempX][tempY]) {
		        sum++;
		        visited[curX][curY] = true;

		        curX = tempX;
		        curY = tempY;
		    }
		    else {
		        dir++;
		        turnCnt++;
		    }
		    if (dir >= 4) {
		        dir = 0;
		    }
		}		
	}
}
