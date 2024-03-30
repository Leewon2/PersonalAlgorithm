import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] map;
	static int S,X,Y;
	static final int[] dr = { 1, -1, 0, 0 };
	static final int[] dc = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		pq = new PriorityQueue<>((o1,o2)->{
			if(o1.order != o2.order) {
				return o1.order-o2.order;
			}
			return o1.num-o2.num;
		});
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				pq.offer(new Node(i,j,num,0));
			}
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		Y = Integer.parseInt(st.nextToken())-1;
		BFS();
		

		System.out.println(map[X][Y]);

	}
	private static void BFS() {
		while(!pq.isEmpty()) {
			Node poll = pq.poll();
			int r = poll.r;
			int c = poll.c;
			int num=poll.num;
			int order = poll.order;
			if(order>=S) continue;
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc]!=0) continue;
				map[nr][nc]=num;
				pq.offer(new Node(nr,nc,num,order+1));
			}
		}
	}

	private static class Node {
		int r;
		int c;
		int num;
		int order;
		public Node(int r, int c, int num, int order) {
			this.r = r;
			this.c = c;
			this.num=num;
			this.order=order;
		}
	}
}
