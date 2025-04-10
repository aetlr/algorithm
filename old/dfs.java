import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	static List<Integer> times = new ArrayList<>();
	static int max = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Node>> graph = new ArrayList<>();
		
		int cityCnt = sc.nextInt();
		int edgeCnt = sc.nextInt();
		int startCity = sc.nextInt();
		sc.nextLine();
		boolean visited[] = new boolean[cityCnt + 1];
				
		for (int i = 0; i <= cityCnt; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for (int i = 0; i < edgeCnt; i++) {
			int departCity = sc.nextInt();
			int arriveCity = sc.nextInt();
			int time = sc.nextInt();
			graph.get(departCity).add(new Node(time, arriveCity));
		}
		
		DFS(startCity, graph, visited, 0);
		System.out.println();
		System.out.println(max);
	}
	
	static void DFS(int n, ArrayList<ArrayList<Node>> graph, boolean[] visited, int time) {
		visited[n] = true;
//		System.out.print(n + " => ");
		Iterator<Node> iter = graph.get(n).listIterator();
		while (iter.hasNext()) {
			Node curNode = iter.next();
			if (!visited[curNode.idx]) {
				n = curNode.idx;
				time += curNode.time;
				curNode.time = time;
				if (curNode.time > max) {
					max = curNode.time;
				}
				DFS(n, graph, visited, time);
				
			}
		}
		
		times.add(time);
		System.out.println(time + " node: " + n);
		
	}
	
	for (Node curNode : graph) {
		
	}
}

class Node {
	int time;
	boolean visited;
	int idx;
	
	Node(int time, int idx) {
		this.time = time;
		this.idx = idx;
		this.visited = false;
	}

}


