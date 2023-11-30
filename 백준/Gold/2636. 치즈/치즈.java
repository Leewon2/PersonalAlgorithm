import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] visited;
	static boolean[][] visit;
	static Queue<Node> q;
	static int cnt;

	public static void main(String[] args) throws IOException {
		input();
		int res = cheese();
		System.out.println(cnt);
		System.out.println(res);

	}

	private static int cheese(){
		int res=0;
		int beforeRes=0;
		while(true){
			// System.out.println("야호");
			bfs();
			findCheese();
			beforeRes = res;
			res = calculate();
			if(res==0){
				break;
			}
			cnt++;
		}
		return beforeRes;
	}

	private static int calculate(){
		int res=0;
		for(int r=0; r<N; r++){
			for(int c=0; c<M; c++){
				if(visited[r][c]) {
					arr[r][c] =0;
					res++;
				}
			}
		}
		visited = new boolean[N][M];
		return res;
	}

	private static void bfs() {
		visit = new boolean[N][M];
		q.offer(new Node(0,0));
		while (!q.isEmpty()) {
			// System.out.println("야호");
			Node poll = q.poll();
			int r = poll.r;
			int c = poll.c;
			visit[r][c] = true;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr<0 || nc<0 || nr>=N || nc>=M || visit[nr][nc]) continue;
				if(arr[nr][nc]==1) continue;
				arr[nr][nc]=-1;
				visit[nr][nc] = true;
				q.offer(new Node(nr,nc));
			}
		}
	}

	private static void findCheese() {
		// 1이면 q에 넣고, bfs를 이용하여, 1을 만나면 q에 넣지 않는다.
		// 0을 만나면 q에 넣는다.
		// 2를 만나면 res를 하나 늘리고, boolean 값을 true로 시킨다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					for(int k=0; k<4; k++){
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(arr[nr][nc]==-1){
							visited[i][j] = true;
							break;
						}
					}
				}
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// for (int i = 0; i < M; i++) {
		// 	arr[0][i] = 2;
		// 	arr[N - 1][i] = 2;
		// }
		// for (int i = 0; i < N; i++) {
		// 	arr[i][0] = 2;
		// 	arr[i][M - 1] = 2;
		// }

		q = new ArrayDeque<>();
		visited = new boolean[N][M];
	}

	private static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
