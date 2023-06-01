

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int M;
	static int N;
	static int result;

	static Queue<Node> q;

	static int[][] map;

	static boolean[][] visited;

	// 델타배열 선언
	static final int[] dr = { 1, 0, -1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {

			// 배추밭 가로 크기(열)
			M = sc.nextInt();

			// 배추밭 세로 크기(행)
			N = sc.nextInt();

			// 배추의 갯수
			int K = sc.nextInt();

			// 결과값 저장 변수
			result = 0;

			// map의 크기
			map = new int[N][M];
			// 방문여부 크기
			visited = new boolean[N][M];

			// map에 배추의 위치 입력
			for (int i = 0; i < K; i++) {
				int col = sc.nextInt();
				int row = sc.nextInt();
				map[row][col] = 1;
			}

			// 배열에 값이 잘 입력 되었는가
//			for (int[] list : map) {
//				System.out.println(Arrays.toString(list));
//			}

			// bfs로 해결해보자.
			q = new LinkedList<>();
			bfs();
			System.out.println(result);
//			for (boolean[] list : visited) {
//				System.out.println(Arrays.toString(list));
//			}
		}
	}

	public static void bfs() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				// 시작점 찾기
				if (!visited[row][col] && map[row][col] == 1) {
//					System.out.println(row+" "+col);
					// 시작점 q에 넣기
					q.offer(new Node(row, col));
					// 자기 자신 방문체크
					visited[row][col] = true;

					// q가 빌 때 까지 반복
					while (!q.isEmpty()) {
						// 꺼내기
						Node poll = q.poll();
						int r = poll.row;
						int c = poll.col;
//						System.out.println("나는 r : "+r+" 나는 c : " + c);

						// 델타배열 이용해서 인접 값 찾기
						for (int i = 0; i < dr.length; i++) {
							int newR = r + dr[i];
							int newC = c + dc[i];
//							System.out.println("나는 newR : " + newR+" 나는 newC : "+newC);
							// 범위 벗어나는지 확인
							if (newR < 0 || newC < 0 || newR >= N || newC >= M)
								continue;

							// 방문 안했고, 1인 녀석 찾으면 q에 넣기
							if (!visited[newR][newC] && map[newR][newC] == 1) {
//								System.out.println("q에 들어갔쇼");
								q.offer(new Node(newR, newC));
								// 방문체크도 해주기
								visited[newR][newC] = true;
							}
						}
					}
//					반복문 끝나면 result에 하나 더하기
					result += 1;
				}
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
