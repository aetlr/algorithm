import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BOJ_17081 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 행
		int M = sc.nextInt(); // 열
		int normalMonsCnt = 0;
		int treasureBoxCnt = 0;
		
		char[][] map = new char[N][M];
		sc.nextLine(); 
		for (int i = 0; i < N; i++) {
			String mapLow = sc.nextLine();
			map[i] = mapLow.toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '&' || map[i][j] == 'M') {
					normalMonsCnt++;
				}
				if (map[i][j] == 'B') {
					treasureBoxCnt++;
				}
			}
		}
		
		List<Character> actionList = sc.nextLine().chars()
			    .mapToObj(e->(char)e).collect(Collectors.toList());
		HashMap<Pair, Monster> monsterMap = new HashMap<>();
		for (int i = 0; i < normalMonsCnt + 1; i++) {
			int dY = sc.nextInt() - 1;
			int dX = sc.nextInt() - 1;
			String name = sc.next();
			int atk = sc.nextInt();
			int def = sc.nextInt();
			int hp = sc.nextInt();
			int rewardExp = sc.nextInt();
			System.out.println(dX + " " + dY);
			monsterMap.put(new Pair(dX, dY), new Monster(dX, dY, name, atk, def, hp, rewardExp));
		}
		

	}
}
class Player {
	private int hp = 20; // 체력
	private int atk = 2; // 공격력
	private int def = 2; // 방어력
	
	
	private int level = 1; // 레벨
	private int exp = 0; // 경험치
	private int nextExp = 5 * this.level;
	
	private int weapon = 0; // 무기 (공격력)
	private int armor = 0; // 방어구
	private String[] slots = new String[4];
	
	
	void getNextExp() {
		System.out.println(nextExp);
	}
	
	
}


class Monster {	
	Monster(int x, int y, String name, int atk, int def, int maxHp, int rewardXp) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.maxHp = maxHp;
		this.rewardXp = rewardXp;
	}
	
	private int x;
	private int y;
	private String name;
	private int atk;
	private int def;
	private int maxHp;
	private int rewardXp;
}

class Box {
	private int x;
	private int y;
	
}

class Pair {
    int key1;
    int key2;

    public Pair(int i, int j) {
        this.key1 = i;
        this.key2 = j;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return key1 == pair.key1 && key2 == pair.key2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key1, key2);
    }
}
