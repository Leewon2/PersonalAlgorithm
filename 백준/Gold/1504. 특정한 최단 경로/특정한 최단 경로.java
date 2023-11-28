
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE;

	static int N;
	static int E;
	static List<Node>[] arr;
	static int must1;
	static int must2;
	static int[] compare;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws IOException {
		input();
		dijkstra(1);
		long toMust1 = compare[must1];
		long toMust2 = compare[must2];
		dijkstra(must1);
		long toNFromMust1 = compare[N];
		long Must2FromMust1 = compare[must2];
		dijkstra(must2);
		long toNFromMust2 = compare[N];
		long result = Math.min(toMust1+toNFromMust2,toMust2+toNFromMust1) + Must2FromMust1;
		if(result>=INF)
			System.out.println(-1);
		else
			System.out.println(result);

	}

	private static void dijkstra(int start) {
		// 1에서 N으로 이동하는데, must1, must 2는 반드시 들린다.
		// 1 -> must1 -> must2 -> N
		// 1 -> must2 -> must1 -> N 으로 가는 경우를 나누어서 계산해보자.
		// 생각해보니 1-> must 1 -> N or 1-> must 2-> N 으로 가는 길이 짧은걸 선택
		// 1에서 must1, must2로 가는 최단 경로를 구함
		// must1에서는 N, must2로 가는 최단 경로를 구함
		// msut2에서는 N으로 가는 최단 경로를 구함
		compare = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(compare, INF);
		compare[start] = 0;
		pq.offer(new Node(0, start));

		while (!pq.isEmpty()) {
			Node poll = pq.poll();
			int dist = poll.dist;
			int edge = poll.edge;
			visited[edge] = true;
			for (int i = 0; i < arr[edge].size(); i++) {
				if (compare[arr[edge].get(i).edge] > dist + arr[edge].get(i).dist) {
					pq.offer(new Node(arr[edge].get(i).dist + dist, arr[edge].get(i).edge));
					compare[arr[edge].get(i).edge] = dist + arr[edge].get(i).dist;
				}
			}
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr = new List[N + 1];
		pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
		compare = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			arr[x].add(new Node(dist, y));
			arr[y].add(new Node(dist, x));
		}
		// for (int i = 0; i < N + 1; i++) {
		// 	Collections.sort(arr[i],(o1,o2)-> o1.dist-o2.dist);
		// }
		st = new StringTokenizer(br.readLine());
		must1 = Integer.parseInt(st.nextToken());
		must2 = Integer.parseInt(st.nextToken());

	}

	private static class Node {
		int dist;
		int edge;

		public Node(int dist, int edge) {
			this.dist = dist;
			this.edge = edge;
		}
	}
}
