import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Queue<Integer> rowQ = new LinkedList<>();
		Queue<Integer> colQ = new LinkedList<>();
		int n = sc.nextInt();
		int[][] map = new int[n][n];

		int k = sc.nextInt();

		int[][] apple = new int[n][n];

		for (int i = 0; i < k; i++) {
			int appleRow = sc.nextInt();
			int appleCol = sc.nextInt();
			appleRow--;
			appleCol--;
			apple[appleRow][appleCol] = 2;
		}

		int move = sc.nextInt();
		int[] moveCnt = new int[move];
		char[] direction = new char[move];

		for (int i = 0; i < move; i++) {
			moveCnt[i] = sc.nextInt();
			direction[i] = sc.next().charAt(0);
		}

		int cnt = 0;

		// 우/좌/하/상/
		int[] dr = { 0, 0, 1, -1 };
		int[] dc = { 1, -1, 0, 0 };

		int startR = 0;
		int startC = 0;

		int dir = 0;

		int time = 0;
		int idx = 0;
		rowQ.add(startR);
		colQ.add(startC);
		map[startR][startC] = 1;
//		time++;

		outer: while (true) {

			startR += dr[dir];
			startC += dc[dir];
			cnt++;
			time++;

			if (startR < 0 || startC < 0 || startR >= n || startC >= n || map[startR][startC] == 1) {
				break outer;
			}
			map[startR][startC] = 1;

			rowQ.add(startR);
			colQ.add(startC);

			if (apple[startR][startC] != 2) {
				map[rowQ.poll()][colQ.poll()] = 0;
			} else if (apple[startR][startC] == 2) {
				apple[startR][startC] = 0;
			}

			if (idx != move) {
				if (time == moveCnt[idx]) {

					if (direction[idx] == 'D') {
						if (dir == 0)
							dir = 2;
						else if (dir == 1)
							dir = 3;
						else if (dir == 2)
							dir = 1;
						else
							dir = 0;

					} else {
						if (dir == 0)
							dir = 3;
						else if (dir == 1)
							dir = 2;
						else if (dir == 2)
							dir = 0;
						else
							dir = 1;
					}
					idx++;
				}

			}

		}
		System.out.println(cnt);

	}
}
