

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int[] dr = { 1, 0, -1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	static int N;
	static int M;
	static int[][] map;
	static int[][] compareMap;
	static Queue<Node> q;
	static int result;
	static int blockCnt;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		compareMap = new int[N][M];
		result = 0;
		blockCnt = 0;
		visited = new boolean[N][M];
		q= new LinkedList<>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		findBlock();
		// 블록이 2개가 될 때 까지 반복
		while (blockCnt < 2) {
//			System.out.println(blockCnt);
//			for(int[] list : map) {
//				System.out.println(Arrays.toString(list));
//			}
//			System.out.println("=================");
			if (checkEmpty()) {
				result = 0;
				break;
			}
			devide();
			copy();
			findBlock();
			result++;
		}
		System.out.println(result);

	}

	// 구한 값 복사
	private static void copy() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = compareMap[r][c];
			}
		}
		compareMap = new int[N][M];
	}

	private static boolean checkEmpty() {
		boolean check = true;
		outer: for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != 0) {
					check = false;
					break outer;
				}
			}
		}
		return check;
	}

	private static void devide() {
	    for (int r = 0; r < N; r++) {
	        Arrays.fill(compareMap[r], 0);
	    }

	    for (int r = 1; r < N - 1; r++) {
	        for (int c = 1; c < M - 1; c++) {
	            int idx = 0;
	            for (int i = 0; i < dr.length; i++) {
	                int nr = r + dr[i];
	                int nc = c + dc[i];
	                if (map[nr][nc] == 0)
	                    idx++;
	            }
	            compareMap[r][c] = Math.max(map[r][c] - idx, 0);
	        }
	    }

	    for (int r = 0; r < N; r++) {
	        for (int c = 0; c < M; c++) {
	            map[r][c] = compareMap[r][c];
	        }
	    }
	}
	private static void findBlock() {
	    visited = new boolean[N][M];
	    blockCnt = 0;
	    for (int r = 0; r < N; r++) {
	        for (int c = 0; c < M; c++) {
	            if (!visited[r][c] && map[r][c] != 0) {
	                dfs(r, c);
	                blockCnt++;
	            }
	        }
	    }
	}

	private static void dfs(int r, int c) {
	    visited[r][c] = true;
	    for (int i = 0; i < dr.length; i++) {
	        int nr = r + dr[i];
	        int nc = c + dc[i];
	        if (isInRange(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0) {
	            dfs(nr, nc);
	        }
	    }
	}

	private static boolean isInRange(int r, int c) {
	    return r >= 0 && r < N && c >= 0 && c < M;
	}



//	private static void findBlock() {
//		visited = new boolean[N][M];
//		blockCnt = 0;
//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < M; c++) {
//				if (!visited[r][c] && map[r][c] != 0) {
//					q.offer(new Node(r, c));
//					bfs();
//					blockCnt++;
//				}
//			}
//		}
//	}
//
//	private static void bfs() {
//		while (!q.isEmpty()) {
//			Node poll = q.poll();
//			int row = poll.row;
//			int col = poll.col;
//			visited[row][col] = true;
//			for (int i = 0; i < dr.length; i++) {
//				int nr = row + dr[i];
//				int nc = col + dc[i];
//				if (!visited[nr][nc] && map[nr][nc]!=0) {
//					q.offer(new Node(nr, nc));
//				}
//			}
//		}
//	}

	private static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
