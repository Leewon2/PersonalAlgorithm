

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R;
	static int C;
	static char[][] arr;
	static final int[] dr = { 1, 0, -1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	static int result;

	static boolean[][] visited;

	static String x;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];

		result = 0;

		// 입력받기
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		// String을 넣어서 결과 합치고 컨테인으로 확인하기

		x = Character.toString(arr[0][0]);
		dfs(new Node(0, 0),x);
		System.out.println(result);

	}

	private static void dfs(Node data, String str) {
//		for(boolean[] list : visited) {
//			System.out.println(Arrays.toString(list));
//		}
//		System.out.println("========================");
		
		result = Math.max(result, str.length());
		int row = data.row;
		int col = data.col;
		for (int i = 0; i < dr.length; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			String compare = Character.toString(arr[nr][nc]);
			if(!visited[nr][nc] && !str.contains(compare)) {
				visited[nr][nc]=true;
				dfs(new Node(nr,nc),str+compare);
				visited[nr][nc]=false;
			}
		}
	}

	private static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
