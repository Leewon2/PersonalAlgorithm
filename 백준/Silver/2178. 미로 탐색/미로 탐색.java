import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();

		int[][] arr = new int[R][C];
		boolean[][] check = new boolean[R][C];
		
		// 입력받기
		for (int row = 0; row < R; row++) {
			String str = sc.next();
			for(int col=0; col<C; col++) {
				arr[row][col]=str.charAt(col)-48;
			}
		}
		
		// row와 col값을 저장할 q배열 2개를 만들어 보자.
		Queue<Integer> rowQ = new LinkedList<>();
		Queue<Integer> colQ = new LinkedList<>();
		
		// rowQ와 colQ에 1을 저장하고, 시작점 (1,1)은 방문체크를 해놓자.
		rowQ.offer(0);
		colQ.offer(0);
		check[0][0]=true;
		
		// 델타배열을 만들어보자.
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		
//		// 입력을 char형으로 받아 왔으므로 첫 시작점에 숫자 1을 대입하자.
//		arr[][1] = 1;
		
	
		
		while(!rowQ.isEmpty()) {
			int nextRow = rowQ.poll();
			int nextCol = colQ.poll();
			
			// 델타배열을 이용하여 현재 위치에서 4방탐색을 해보자
			for(int i=0; i<dr.length; i++) {
				int newRow=nextRow+dr[i];
				int newCol=nextCol+dc[i];
				
				// 배열의 범위 밖으로 벗어나는 경우, 확인한 값이 0인 경우, 
				// 방문체크가 true인  경우엔 continue 하자.
				
				if(newRow<0 || newCol<0 || newRow>=R || newCol>=C 
						|| arr[newRow][newCol]==0 || check[newRow][newCol]==true) {
					continue;
				}
				
				rowQ.offer(newRow);
				colQ.offer(newCol);
				check[newRow][newCol]=true;
				arr[newRow][newCol] = arr[nextRow][nextCol]+1;
			}
			
		}
		
		System.out.println(arr[R-1][C-1]);
		
		
	}
}