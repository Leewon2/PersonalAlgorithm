

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{

	static int M;
	static int N;
	static int H;
	static int[][][] map;
	static boolean[][][] visited;
	static int result;
	static Queue<Node> q;
	static Queue<Node> q2;

	static final int[] dr = { 1, 0, -1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		q = new LinkedList<>();
		q2 = new LinkedList<>();

		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		result = -1;
		map = new int[N][M][H+1];
		visited = new boolean[N][M][H+1];
		for (int h = 1; h <= H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					map[r][c][h] = sc.nextInt();
				}
			}
		}
		
		for (int h = 1; h <= H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c][h] == 1) {
						q2.offer(new Node(r, c, h));
					}
				}
			}
		}
		bfs();
//		for

//		for(boolean[] list : visited) {
//		System.out.println(Arrays.toString(list));
//	}

		// for문 돌아서 -1존재하면 0출력
		for (int h = 1; h <= H; h++) {
			outer: for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c][h] == 0 && !visited[r][c][h]) {
						result = -1;
						break outer;
					}
				}
			}
		}

		System.out.println(result);

	}

	private static void bfs() {
		while (!q2.isEmpty()) {
//			System.out.println(1);
			while (!q2.isEmpty()) {
				q.offer(q2.poll());
			}

			while (!q.isEmpty()) {
				Node poll = q.poll();
				int row = poll.row;
				int col = poll.col;
				int h = poll.h;
				visited[row][col][h] = true;

				for (int d = 0; d < dr.length; d++) {
					int newR = row + dr[d];
					int newC = col + dc[d];
//					System.out.println("newR : " + newR + " newC : "+newC);
					if (newR < 0 || newC < 0 || newR >= N || newC >= M) {
						continue;
					}
					if (!visited[newR][newC][h] && map[newR][newC][h] == 0) {
						visited[newR][newC][h] = true;
						q2.offer(new Node(newR, newC, h));
					}
				}

				int newH = h + 1;
				if (newH <= H) {
					if (!visited[row][col][newH] && map[row][col][newH] == 0) {
						visited[row][col][newH] = true;
						q2.offer(new Node(row, col, newH));
					}
				}
				newH = h - 1;

				if (newH > 0) {
					if (!visited[row][col][newH] && map[row][col][newH] == 0) {
						visited[row][col][newH] = true;
						q2.offer(new Node(row, col, newH));
					}
				}
			}
//			for(boolean[] list : visited) {
//				System.out.println(Arrays.toString(list));
//			}
			result++;
		}
	}

	private static class Node {
		int row;
		int col;
		int h;

		public Node(int row, int col, int h) {
			this.row = row;
			this.col = col;
			this.h = h;
		}

	}
}
