

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int rr;
	static int cc;

	static final int[] dr = { 1, 0, -1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static Queue<Node> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		rr = Integer.parseInt(st.nextToken());
		cc = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();

		char[][] map = new char[rr][cc];
		boolean[][] visited = new boolean[rr][cc];

		for (int r = 0; r < rr; r++) {
			String str = br.readLine();
			for (int c = 0; c < cc; c++) {
				map[r][c] = str.charAt(c);
				if (map[r][c] == 'I') {
					q.offer(new Node(r, c));
					visited[r][c]=true;
				}
			}
		}
		int result = bfs(map, visited);
		if(result==0) System.out.println("TT");
		else System.out.println(result);
		

//		for(char[] list : map) {
//			System.out.println(Arrays.toString(list));
//		}

	}

	public static int bfs(char[][] arr,boolean[][] visit) {
		int res = 0;
		while (!q.isEmpty()) {
			Node poll = q.poll();
			int row = poll.row;
			int col = poll.col;
			for (int i = 0; i < dr.length; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr < 0 || nc < 0 || nr >= rr || nc >= cc)
					continue;
				if (!visit[nr][nc] && arr[nr][nc] != 'X') {
					if (arr[nr][nc] == 'P') {
						res++;
						q.offer(new Node(nr, nc));
						visit[nr][nc]=true;
					} else {
						q.offer(new Node(nr, nc));
						visit[nr][nc]=true;
					}
				}
			}
		}
		return res;
	}

	public static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
