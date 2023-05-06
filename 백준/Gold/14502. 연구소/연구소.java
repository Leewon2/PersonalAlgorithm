

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int n;
	static int m;

	static int[][] arr;
	static int[][] arr2;

	static int max = 0;

	static boolean[][] check;

	static int cnt;

	static Queue<Node> q;

	static final int[] dr = { 1, 0, -1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 행 열 크기 입력
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 최대값 찾아서 저장할 변수 생성
		max = 0;

		// 배열 크기 정하기
		arr = new int[n][m];
		arr2 = new int[n][m];
		check = new boolean[n][m];

		// 배열에 값 입력
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		copyArr();
		permutation(0);
		System.out.println(max);
		

	}

	// 순열로 0인 곳 1로 바꾸기
	public static void permutation(int idx) {
		// 기저조건
		if (idx == 3) {
			infect();
			findMax();
//			copyArr();
			return;
		}

		// 재귀조건
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (arr2[r][c] == 0) {
					arr2[r][c] = 1;
					permutation(idx + 1);
					arr2[r][c] = 0;
				}
			}
		}
	}

	// 감염시키기
	public static void infect() {
		check=new boolean[n][m];
		// 방문여부 초기화
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (arr2[r][c] == 2) {
					check[r][c]=true;
					// ############시간초과나면 방문체크 만들기
					q = new LinkedList<>();
					// 큐에 넣기
					q.offer(new Node(r, c));
					while (!q.isEmpty()) {
						// 하나 꺼내서 확인하기
						Node poll = q.poll();
						int pr = poll.row;
						int pc = poll.col;

						for (int i = 0; i < dr.length; i++) {
							int newR = pr + dr[i];
							int newC = pc + dc[i];

							// 범위 벗어나면 안봄
							// 방문체크 된 곳도 안봄
							if (newR < 0 || newC < 0 || newR >= n || newC >= m || check[newR][newC])
								continue;

							// 0인 곳 감염시키기
							if (arr2[newR][newC] == 0 && !check[newR][newC]) {
								check[newR][newC] = true;
//								arr2[newR][newC] = 2;
								q.offer(new Node(newR, newC));
							}
						}

					}
				}

			}
		}
	}

	// 감염되지 않은 곳 찾기
	public static void findMax() {
		cnt = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				// 0인곳 발견하면 cnt++
				if (arr2[r][c] == 0 && !check[r][c])
					cnt++;
			}
		}
		max = Math.max(max, cnt);

	}

	// 깊은복사
	public static void copyArr() {
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				arr2[r][c] = arr[r][c];
			}
		}
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
