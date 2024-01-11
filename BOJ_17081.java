import java.util.*;
import java.util.stream.Collectors;

public class Main {
	static Player p;
	static int passedTurn = 0;
	static int N;
	static int M;
	static int firstPlayerX, firstPlayerY;
	static int monsterCnt = 0;
	static int boxCnt = 0;
	static List<Character> actionList;
	static HashMap<String, Monster> monsterList = new HashMap<>();
	static HashMap<String, Box> boxList = new HashMap<>();
	static List<String> spikeList = new ArrayList<>();
	static List<String> wallList = new ArrayList<>();
	static int bossX, bossY;
	static boolean bossClear = false;
	static String deathCause = "";
	static char[][] Grid;
	static boolean gameEnd = false;

	public static void BOJ_17081(String[] args) {
		p = null;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		Grid = new char[N][M]; // [상하][좌우]

		for (int i = 0; i < N; i++) { // 맵 생성
			String mapLow = sc.nextLine();
			Grid[i] = mapLow.toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Grid[i][j] == '&') {
					monsterCnt++;
				} else if (Grid[i][j] == 'M') {
					monsterCnt++;
					bossX = i;
					bossY = j;
				} else if (Grid[i][j] == 'B') {
					boxCnt++;
				} else if (Grid[i][j] == '@') {
					firstPlayerX = i;
					firstPlayerY = j;
					p = new Player(i, j);
				} else if (Grid[i][j] == '^') {
					spikeList.add(i + "|" + j);
				} else if (Grid[i][j] == '#') {
					wallList.add(i + "|" + j);
				}
			}
		}

		actionList = sc.nextLine().chars() // 명령 리스트
				.mapToObj(e -> (char) e).collect(Collectors.toList());
		for (int i = 0; i < monsterCnt; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			String name = sc.next();
			int atk = sc.nextInt();
			int def = sc.nextInt();
			int hp = sc.nextInt();
			int rewardExp = sc.nextInt();
			boolean isBoss;
			if (x == bossX && y == bossY) {
				isBoss = true;
			} else {
				isBoss = false;
			}
			monsterList.put(x + "|" + y, new Monster(name, atk, def, hp, rewardExp, isBoss, hp));
		}

		for (int i = 0; i < boxCnt; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			String type = sc.next();
			if (type.equals("W") || type.equals("A")) {
				int value = sc.nextInt();
				boxList.put(x + "|" + y, new Box(type, value));
			} else {
				String pendent = sc.next();
				boxList.put(x + "|" + y, new Box(type, pendent));
			}
		}

		for (int i = 0; i < actionList.size(); i++) {
			if (gameEnd) {
				break;
			}

			passedTurn++;
			p.move(actionList.get(i));
			if (p.getCurrentStuff().equals("Box")) {
				Box box = boxList.get(p.getIndex());
			}

			String index = p.getIndex();
			if (p.getCurrentStuff().equals("Box")) {
				Box currentBox = boxList.get(index);
				if (currentBox.type.equals("W")) {
					p.wep = currentBox.value;

				} else if (currentBox.type.equals("A")) {
					p.shd = currentBox.value;
				} else if (currentBox.type.equals("O")) {
					p.equipPendent(currentBox.pendentType);
				}

				Grid[p.x][p.y] = '.';
				boxList.remove(index);
			}

			else if (p.getCurrentStuff().equals("Spike")) {
				if (p.containsPendent("DX")) {
					p.hp -= 1;
				} else {
					p.hp -= 5;
				}
				if (p.deathCheck()) {
					deathCause = "SPIKE TRAP";
					endPhase();
					break;
				}
			}

			else if (p.getCurrentStuff().equals("Monster")) {
				Monster currentMonster = monsterList.get(index);
				boolean firstAttack = true;
				boolean firstHit = true;
				if (!currentMonster.isBoss) {
					while (true) {
						if (p.x == Main.firstPlayerX && p.y == Main.firstPlayerY) {
							currentMonster.hp = currentMonster.maxHp;

							break;
						}
						if (p.deathCheck() || currentMonster.hp <= 0) {

							break;
						}

						if (firstAttack && p.containsPendent("CO")) {
							if (p.containsPendent("DX")) {
								currentMonster.hp -= Math.max(1, (p.finalAtk * 3) - currentMonster.def);
							} else {
								currentMonster.hp -= Math.max(1, (p.finalAtk * 2) - currentMonster.def);
							}
						}

						else {
							currentMonster.hp -= Math.max(1, p.finalAtk - currentMonster.def);
						}
						firstAttack = false;

						if (p.x == Main.firstPlayerX && p.y == Main.firstPlayerY) {
							currentMonster.hp = currentMonster.maxHp;

							break;
						}
						if (p.deathCheck() || currentMonster.hp <= 0) {

							break;
						}

						p.hp -= Math.max(1, currentMonster.atk - p.finalDef);

					}

				} else { // 보스
					if (p.containsPendent("HU")) {
						p.hp = p.maxHp;
					}
					if (p.x == Main.firstPlayerX && p.y == Main.firstPlayerY) {
						currentMonster.hp = currentMonster.maxHp;

						break;
					}
					while (true) {

						if (p.deathCheck() || currentMonster.hp <= 0) {

							break;
						}

						if (firstAttack && p.containsPendent("CO")) {
							if (p.containsPendent("DX")) {
								currentMonster.hp -= Math.max(1, (p.finalAtk * 3) - currentMonster.def);
							} else {
								currentMonster.hp -= Math.max(1, (p.finalAtk * 2) - currentMonster.def);
							}
						}

						else {
							currentMonster.hp -= Math.max(1, p.finalAtk - currentMonster.def);
						}
						firstAttack = false;

						if (firstHit && p.containsPendent("HU")) {
							firstHit = false;
							continue;
						}
						if (p.x == Main.firstPlayerX && p.y == Main.firstPlayerY) {
							currentMonster.hp = currentMonster.maxHp;
							break;
						}
						if (p.deathCheck() || currentMonster.hp <= 0) {

							break;
						} else {
							p.hp -= Math.max(1, currentMonster.atk - p.finalDef);
						}

					}
				}

				if (p.deathCheck()) {
					deathCause = currentMonster.name;
					endPhase();
					break;
				} else {
					if (p.x == Main.firstPlayerX && p.y == Main.firstPlayerY) {
						currentMonster.hp = currentMonster.maxHp;
						continue;
					}
					if (p.containsPendent("HR")) {
						p.hp += 3;
						if (p.hp > p.maxHp) {
							p.hp = p.maxHp;
						}
					}
					Grid[p.x][p.y] = '.';
					if (p.containsPendent("EX")) {
						p.exp += Math.floor(currentMonster.rewardExp * 1.2);
					} else {
						p.exp += currentMonster.rewardExp;

					}

					monsterList.remove(p.getIndex());
					if (p.exp >= p.requireExp) {
						p.exp = 0;
						p.lvl++;
						p.maxHp += 5;
						p.atk += 2;
						p.def += 2;
						p.hp = p.maxHp;
						p.updateStat();
					}
					if (currentMonster.isBoss) {
						bossClear = true;

						endPhase();
					}
				}
			}

		}

		if (!bossClear && !p.deathCheck()) {
			endPhase();
		}

	}

	public static void endPhase() {
		Grid[Main.firstPlayerX][Main.firstPlayerY] = '.';
		Grid[p.x][p.y] = '@';
		if (!deathCause.equals("SPIKE TRAP") && !Main.bossClear && p.deathCheck()) {
			Grid[p.x][p.y] = '&';
		}
		if (!Main.bossClear) {
			Grid[bossX][bossY] = 'M';
		}
		if (Main.deathCause.equals("SPIKE TRAP")) {
			Grid[p.x][p.y] = '^';
		}

		for (int i = 0; i < N; i++) {
			String temp = "";
			for (int j = 0; j < M; j++) {
				temp += Grid[i][j];
			}
			System.out.println(temp);
		}
		if (p.hp < 0) {
			p.hp = 0;
		}
		System.out.println("Passed Turns : " + passedTurn);
		System.out.println("LV : " + p.lvl);
		System.out.println("HP : " + p.hp + "/" + p.maxHp);
		System.out.println("ATT : " + (p.atk) + "+" + p.wep);
		System.out.println("DEF : " + (p.def) + "+" + p.shd);
		System.out.println("EXP : " + p.exp + "/" + p.requireExp);
		if (p.deathCheck()) {
			System.out.println("YOU HAVE BEEN KILLED BY " + deathCause + "..");
		} else if (bossClear) {
			System.out.println("YOU WIN!");
		} else {
			System.out.println("Press any key to continue.");
		}
		gameEnd = true;
	}

}

class Player {
	Player(int x, int y) {
		this.x = x;
		this.y = y;
		for (int i = 0; i < 4; i++) {
			pendentList[i] = "Empty";
		}
	}

	void revive() {
		for (int i = 0; i < 4; i++) {
			if (pendentList[i].equals("RE")) {
				pendentList[i] = "Empty";
			}
		}
		Main.deathCause = "";
		revived = true;
		this.hp = this.maxHp;
		this.x = Main.firstPlayerX;
		this.y = Main.firstPlayerY;
		updateStat();
	}

	int x;
	int y;
	boolean revived = false;
	int wep = 0;
	int shd = 0;

	int maxHp = 20;
	int hp = 20;
	int atk = 2;
	int finalAtk = this.atk + this.wep;
	int def = 2;
	int finalDef = this.shd + this.def;

	int lvl = 1;
	int exp = 0;
	int requireExp = 5 * lvl;

	void updateStat() {
		this.finalAtk = this.atk + this.wep;
		this.finalDef = shd + def;
		this.requireExp = 5 * lvl;
	}

	String[] pendentList = new String[4];

	boolean containsPendent(String pendentType) {
		boolean isExist = false;
		for (int i = 0; i < 4; i++) {
			if (pendentList[i].equals(pendentType)) {
				isExist = true;
			}
		}
		return isExist;
	}

	boolean deathCheck() {
		if (hp <= 0) {
			if (containsPendent("RE")) {
				revive();
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}

	}

	void move(char dir) {
		updateStat();
		if (dir == 'U') {
			if (x != 0 && !Main.wallList.contains((x - 1) + "|" + y)) {
				x--;
			}
		}

		if (dir == 'R') {
			if (y != Main.M - 1 && !Main.wallList.contains(x + "|" + (y + 1))) {
				y++;
			}
		}
		if (dir == 'D') {
			if (x != (Main.N - 1) && !Main.wallList.contains((x + 1) + "|" + y)) {
				x++;
			}
		}

		if (dir == 'L') {
			if (y != 0 && !Main.wallList.contains(x + "|" + (y - 1))) {
				y--;
			}
		}

	}

	String getIndex() {
		return x + "|" + y;

	}

	String getCurrentStuff() {
		String index = x + "|" + y;
		if (Main.monsterList.containsKey(index)) {
			return "Monster";
		} else if (Main.boxList.containsKey(index)) {
			return "Box";
		} else if (Main.spikeList.contains(index)) {
			return "Spike";
		} else {
			return "None";
		}
	}

	void equipPendent(String pendentType) {
		boolean isExist = false;
		for (int i = 0; i < 4; i++) {
			if (pendentList[i].equals(pendentType)) {
				isExist = true;
			}
		}

		if (!isExist) {
			for (int i = 0; i < 4; i++) {
				if (pendentList[i].equals("Empty")) {
					pendentList[i] = pendentType;
					break;
				}
			}
		}
	}

}

class Monster {
	Monster(String name, int atk, int def, int hp, int rewardExp, boolean isBoss, int maxHp) {
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.hp = hp;
		this.rewardExp = rewardExp;
		this.isBoss = isBoss;
		this.maxHp = maxHp;
	}

	boolean isBoss;
	int maxHp;
	String name;
	int atk;
	int def;
	int hp;
	int rewardExp;
}

class Box {

	Box(String type, int value) {
		this.type = type;
		this.value = value;
	}

	Box(String type, String pendentType) {
		this.type = type;
		this.pendentType = pendentType;
	}

	String type;
	int value;

	String pendentType;

}
