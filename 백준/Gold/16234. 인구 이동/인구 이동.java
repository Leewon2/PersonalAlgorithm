

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int N;
	static int L;
	static int R;

	static int[][] map;
	static boolean[][] visited;

	static final int[] dr = { 1, 0, -1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	static Queue<Node> q;

	static boolean stop;

	static int[][] check;
	static int idx;
	static int[] move;

	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();

		result = 0;

		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		stop = true;
		while (stop) {
			stop = false;
			visited = new boolean[N][N];
			check = new int[N][N];
			idx = 1;
			// 인구이동 정보를 move에 저장해놓자
			// 예를 들어, check[0][0]이 1 이라면, move[1] 값을 넣어준다
			move = new int[N * N + 1];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visited[r][c]) {
						bfs(r, c);
					}
				}
			}
			// 반복문 전부 끝나면 map 값 갱신
			updateMap();
			result++;
		}
		System.out.println(result-1);
	}

	static void updateMap() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {

				// map 값을, 인구이동한 녀석으로 이동
				map[r][c] = move[check[r][c]];

			}
		}
	}

	static void bfs(int row, int col) {
		// q에 몇개나 담길까 세기
		int num = 0;
		int sum = map[row][col];

		// q에 담기
		q.offer(new Node(row, col));
		// 방문체크
		visited[row][col] = true;
		// q가 빌 때 까지 반복
		while (!q.isEmpty()) {
			// 하나 꺼내서 4방 탐색
			num++;
			Node poll = q.poll();
			int r = poll.r;
			int c = poll.c;
			// 꺼낸값의 check 값은 idx
			check[r][c] = idx;
			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (!visited[nr][nc]) {
					if ((Math.abs(map[r][c] - map[nr][nc]) >= L) && (Math.abs(map[r][c] - map[nr][nc]) <= R)) {
						// 방문체크
						visited[nr][nc] = true;
						// q에 넣기
						q.offer(new Node(nr,nc));
						// sum 늘리기
						sum += map[nr][nc];
						stop = true;
					}
					// 하나라도 연결되어 있다는 것
				}
			}
		}
		// 반복문 끝나면 move의 idx에 sum/num값 저장
		move[idx] = sum / num;
		idx++;
//		System.out.println(idx);
	}

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
