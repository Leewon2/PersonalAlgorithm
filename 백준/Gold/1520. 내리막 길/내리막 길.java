
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static int[][] dp;

	static final int[] dr = { 1, 0, -1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(dfs(0, 0));
	}

	private static int dfs(int x, int y) {
		if (x == N - 1 && y == M - 1) {
			return 1;
		}

		if (dp[x][y] != -1) {
			return dp[x][y];
		}
		dp[x][y]=0;
		for (int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;

			if (arr[x][y] > arr[nr][nc]) {
				dp[x][y] += dfs(nr, nc);
			}
		}

		return dp[x][y];
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				dp[r][c] = -1;
			}
		}
	}
}
