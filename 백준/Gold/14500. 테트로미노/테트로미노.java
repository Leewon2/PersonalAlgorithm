

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		result = 0;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				square1(r,c);
				square2(r,c);
				square3(r,c);
				square4(r,c);
				square5(r,c);
			}
		}
		System.out.println(result);

	}
	
	private static void square5(int r, int c) {
		if(r+2<N && c+1<M) {
			int compare = map[r][c] + map[r+1][c] +
					map[r+1][c+1] + map[r+2][c];
			result = Math.max(compare, result);
		}
		
		if(r+2<N && c-1>=0) {
			int compare = map[r][c] + map[r+1][c] +
					map[r+1][c-1] + map[r+2][c];
			result = Math.max(compare, result);
		}
		
		if(r+1<N && c+2<M) {
			int compare = map[r][c] + map[r][c+1] +
					map[r+1][c+1] + map[r][c+2];
			result = Math.max(compare, result);
		}
		
		if(r-1>=0 && c+2<M) {
			int compare = map[r][c] + map[r][c+1] +
					map[r-1][c+1] + map[r][c+2];
			result = Math.max(compare, result);
		}
	}
	
	private static void square4(int r, int c) {
		if(r+2<N && c+1<M) {
			int compare = map[r][c] + map[r+1][c] +
					map[r+1][c+1] + map[r+2][c+1];
			result = Math.max(compare, result);
		}
		
		if(r+2<N && c-1>=0) {
			int compare = map[r][c] + map[r+1][c] +
					map[r+1][c-1] + map[r+2][c-1];
			result = Math.max(compare, result);
		}
		
		if(r-1>=0 && c+2<M) {
			int compare = map[r][c] + map[r][c+1] +
					map[r-1][c+1] + map[r-1][c+2];
			result = Math.max(compare, result);
		}
		
		if(r+1<N && c+2<M) {
			int compare = map[r][c] + map[r][c+1] +
					map[r+1][c+1] + map[r+1][c+2];
			result = Math.max(compare, result);
		}
	}
	
	private static void square3(int r, int c) {
		if(r+2<N && c+1<M) {
			int compare = map[r][c] + map[r+1][c] +
					map[r+2][c] + map[r+2][c+1];
			result = Math.max(compare, result);
		}
		
		if(r+2<N && c+1<M) {
			int compare = map[r][c] + map[r][c+1] +
					map[r+1][c+1] + map[r+2][c+1];
			result = Math.max(compare, result);
		}
		
		if(r+1<N && c+2<M) {
			int compare = map[r][c] + map[r+1][c] +
					map[r+1][c+1] + map[r+1][c+2];
			result = Math.max(compare, result);
		}
		
		if(r+1<N && c+2<M) {
			int compare = map[r][c] + map[r][c+1] +
					map[r+1][c+2] + map[r][c+2];
			result = Math.max(compare, result);
		}
		//##
		if(r-1>=0 && c+2<M) {
			int compare = map[r][c] + map[r][c+1] +
					map[r][c+2] + map[r-1][c+2];
			result = Math.max(compare, result);
		}
		
		if(r-1>=0 && c+2<M) {
			int compare = map[r][c] + map[r-1][c] +
					map[r-1][c+1] + map[r-1][c+2];
			result = Math.max(compare, result);
		}
		
		if(r+2<N && c-1>=0) {
			int compare = map[r][c] + map[r][c-1] +
					map[r+1][c-1] + map[r+2][c-1];
			result = Math.max(compare, result);
		}
		
		if(r+2<N && c-1>=0) {
			int compare = map[r][c] + map[r+1][c] +
					map[r+2][c] + map[r+2][c-1];
			result = Math.max(compare, result);
		}
	}
	
	private static void square2(int r, int c) {
		if(r+1<N && c+1<M) {
			int compare = map[r][c] + map[r+1][c] +
					map[r][c+1] + map[r+1][c+1];
			result = Math.max(compare, result);
		}
	}

	private static void square1(int r, int c) {
		int compare = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + i;
			if (nr >= N) {
				compare=0;
				break;
			}else
			compare += map[nr][c];
		}
		result = Math.max(compare, result);
		
		compare=0;
		for (int i = 0; i < 4; i++) {
			int nc = c + i;
			if (nc >= M) {
				compare=0;
				break;
			}else
			compare += map[r][nc];
		}
		result = Math.max(compare, result);
	}
}
