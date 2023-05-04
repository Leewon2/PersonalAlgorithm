import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int n;
	static char[][] arr;
	static char[][] arr2;

	static boolean[][] visitedG;
	static boolean[][] visitedC;

	static int generalCnt;
	static int colorWeaknessCnt;

	static final int[] dr = { 1, 0, -1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	static Queue<Node> generalQ;
	static Queue<Node> colorQ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n 입력
		n = Integer.parseInt(br.readLine());

		// 배열의 크기 정하기
		arr = new char[n][n];
		arr2 = new char[n][n];

		// 방문여부 초기화
		visitedC = new boolean[n][n];
		visitedG = new boolean[n][n];

		// Cnt 초기화
		generalCnt = colorWeaknessCnt = 0;

		// q 초기화
		generalQ = new LinkedList<>();
		colorQ = new LinkedList<>();

		// 값 입력 받기
		for (int row = 0; row < n; row++) {
			String str = br.readLine();
			for (int col = 0; col < n; col++) {
				arr[row][col] = str.charAt(col);
			}
		}

		// 깊은복사 하나 하자.
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				// G는 다 빨강으로 만들어버리기
				if (arr[row][col] == 'G') {
					arr2[row][col] = 'R';
				} else {
					arr2[row][col] = arr[row][col];
				}
			}
		}

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {

				// 방문체크 안된곳은 시작 가능
				// 일반인 버전
				if (!visitedG[row][col]) {
					generalQ.offer(new Node(row, col));
					visitedG[row][col] = true;
					// 큐에 넣고 메서드 수행
					// 인자로 row,col 주면 될듯
					general(row, col);
				}

				if (!visitedC[row][col]) {
					colorQ.offer(new Node(row, col));
					visitedC[row][col] = true;
					colorWeakness(row, col);
				}
			}
		}

		System.out.println(generalCnt + " " + colorWeaknessCnt);

	}

	public static void general(int row, int col) {
		// 큐가 빌 때 까지 반복
		while (!generalQ.isEmpty()) {
			Node poll = generalQ.poll();
			
			for (int i = 0; i < dr.length; i++) {
				int newR = poll.row + dr[i];
				int newC = poll.col + dc[i];
				// 방문했거나 범위 벗어나면 cotinue
				if (newR < 0 || newC < 0 || newR >= n || newC >= n)
					continue;

				// 위에서 안걸렸으면 갈 수 있는 곳
				// 같은 색갈만 q에 넣자.
				if (!visitedG[newR][newC] && arr[newR][newC] == arr[poll.row][poll.col]) {
					generalQ.offer(new Node(newR, newC));
					// 방문체크
					visitedG[newR][newC] = true;
				}
			}
		}
		// 끝났으면 카운트 하나 늘리기
		generalCnt++;

	}

	public static void colorWeakness(int row, int col) {

		// 큐가 빌 때 까지 반복
		while (!colorQ.isEmpty()) {
			Node poll = colorQ.poll();
			for (int i = 0; i < dr.length; i++) {
				int newR = poll.row + dr[i];
				int newC = poll.col + dc[i];
				// 방문했거나 범위 벗어나면 cotinue
				if ( newR < 0 || newC < 0 || newR >= n || newC >= n)
					continue;

				// 위에서 안걸렸으면 갈 수 있는 곳
				// 같은 색갈만 q에 넣자.
				if (!visitedC[newR][newC] && arr2[newR][newC] == arr2[poll.row][poll.col]) {
					colorQ.offer(new Node(newR, newC));
					// 방문체크
					visitedC[newR][newC] = true;
				}
			}
		}
		// 끝났으면 카운트 하나 늘리기
		colorWeaknessCnt++;
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