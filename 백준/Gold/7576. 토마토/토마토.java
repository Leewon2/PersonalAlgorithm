/* 문제
* 토마토 농장에 M*N 크기의 창고가 있다.
* 창고에 보관되는 토마토 중에는 잘 익은 토마토도 있지만 익지 않은 토마토도 있다.
* 익지 않은 토마토는 익은 토마토의 영향을 받아 익게되는데
* 하루가 지나면 익은 토마토 상하좌우에 토마토들은 익게된다.
* 몇일이 지나면 창고의 토마토들이 모두 익는지 구해보자.
* 
* 
* 문제 조건
* 창고의 칸에는 토마토가 들어있지 않을수도 있다.
* 상자의 가로 칸의 수 N, 세로 칸의 수 M은 2 이상 1000 이하다.
* 정수 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 들어있지 않은 칸이다. 
* 저장될 때 부터 모든 토마토가 익어있는 상태이면 0을 출력하고, 모두 익지 못하면 -1을 출력하자.
* 
* 
* 문제 해결 방법
* BFS와 델타배열을 이용해보자.
* 배열에서 1인 값을 모두 큐에 넣자.
* 큐가 빌 때 까지 델타배열을 이용해 1의 범위를 넓혀간다.
* 큐가 비면 카운트를 하나 늘리고
* 다시 다음 큐가 빌 때 까지 델타배열을 이용해 1의 범위를 넓혀가보자.
* 
* 1인 값을 찾고 1 상하좌우가 0이라면 1로 바꾸자.
* 
* 
*/



import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<Integer> rowQ = new LinkedList<>();
	static Queue<Integer> colQ = new LinkedList<>();

	static Queue<Integer> newRowQ = new LinkedList<>();
	static Queue<Integer> newColQ = new LinkedList<>();

	static int width;
	static int height;
	static int cnt=0;
	static int[][] arr;

	public static void bfs() {

		// 델타배열을 이용하기 위해 델타배열을 만들자.
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		// 새로운 큐 배열을 만들어 저장하자.
		// 새로운 큐 배열이 빌 때 까지 반복하는데, 이는
		// q에 저장된 요소들만 사용하는 것 이므로
		// 한번만 탐색하는 것이다.
		// rowQ에 있는 요소들은 모두 빼내고

		while (!rowQ.isEmpty()) {
			
			// rowQ와 colQ에 있는 값들을 
			while(!rowQ.isEmpty()) {
				newRowQ.offer(rowQ.poll());
				newColQ.offer(colQ.poll());
			}

			// 큐가 한번 빌 때 까지 반복하자.
			int doit =0;
			while (!newRowQ.isEmpty()) {
				int rowPoll = newRowQ.poll();
				int colPoll = newColQ.poll();
				// 델타 배열을 이용하여 상하좌우를 탐색해보자.
				for (int i = 0; i < dr.length; i++) {
					// 상하좌우를 탐색하자.
					int newRowPoll = rowPoll + dr[i];
					int newColPoll = colPoll + dc[i];

					// 배열의 범위를 벗어나면 continue를 해주자.
					if (newRowPoll < 0 || newColPoll < 0 || newRowPoll >= width || newColPoll >= height)
						continue;

					// 상하좌우를 확인했는데 0 값이 있다면?
					// 그 값을 q에 다시 넣고, 값은 1로 바꿔주자.
					if (arr[newRowPoll][newColPoll] == 0) {
						// 값은 rowQ, colQ에 넣는다.
						rowQ.offer(newRowPoll);
						colQ.offer(newColPoll);
						arr[newRowPoll][newColPoll] = 1;
						doit++;
					}
				}
			}
			if(doit>0) cnt++;
		}
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				if(arr[i][j]==0) cnt=-1;
			}
		}
			
		System.out.println(cnt);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		height = sc.nextInt();
		width = sc.nextInt();

		// 가로 세로 크기의 배열을 만들어보자
		arr = new int[width][height];

		// 배열에 값을 입력 받자.
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height; col++) {
				arr[row][col] = sc.nextInt();
				if (arr[row][col] == 1) {
					// 배열의 값이 1이라면 q에 저장하자.
					rowQ.offer(row);
					colQ.offer(col);
				}
			}
		}

		bfs();

	}

}
