

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int sr;
	static int sc;
	static int dir;

	static int result;
	static boolean[][] visited;

	// 북, 동, 남, 서
	// 북 서 남 동
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		// 시작 행, 열, 방향
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		result = 0;

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			// 현재 칸이 아직 청소되지 않았으면 청소한다.
			if(!visited[sr][sc] && map[sr][sc]==0) {
				visited[sr][sc]=true;
				result++;
			}
			// 주변 4칸 중 청소되지 않은 빈칸이 있는지 없는지 확인
			boolean check = false;
			for(int i =0; i<dr.length; i++) {
				int newR = sr+dr[i];
				int newC = sc+dc[i];
				// 청소되지 않은곳이 있다면, true로 바꾼다.
				if(!visited[newR][newC] && map[newR][newC]==0) check=true;
			}
			
			// 빈칸이 없는 경우
			if(!check) {
				// 현재 보고있는 방향으로 백
				sr-=dr[dir];
				sc-=dc[dir];
				// 뒤가 벽이면 break
				if(map[sr][sc]==1) break;
			}
			// 빈칸이 있는 경우 반시계 방향으로 회전
			// => 북 -> 서 -> 남 -> 동
			else {
				dir= (dir+3) %4;
				int newR = sr+dr[dir];
				int newC = sc+dc[dir];
				// 바라보는 방향으로 한칸 전진할 수 있으면 전진
				if(!visited[newR][newC] && map[newR][newC]==0) {
					sr = newR;
					sc = newC;
				}
			}
			
		}
		System.out.println(result);
	}


	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
