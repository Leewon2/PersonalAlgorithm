/* 인접 메서드를 만들어보자
 * 인접한다면 true를 리턴하도록 하자.
 * 인접하고 수가 같은 경우가 존재한다면 cnt를 늘려주고,
 * cnt가 0이라면 인접이 존재하지 않는 것이므로 평균을 구한다.
 * 평균보다 큰 값은 -1, 작은 값은 +1 하자.
 */



import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int T;
	static int arr[][];

	static int sum;

	static boolean[][] check;

	static int cnt;

	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		arr = new int[N][M];

		// 배열에 값 입력 받기
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				arr[row][col] = sc.nextInt();
			}
		}

		for (int i = 0; i < T; i++) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();
			// 회전 하자
			check = new boolean[N][M];
			for(int sp = x-1 ; sp<N; sp=sp+x) {
//				System.out.println(sp);
//				System.out.println("sp : "+sp);
				spin(sp, d, k);
			}
			
			
//			System.out.println("회전 후 배열");
//			for(int[] list : arr) {
//				System.out.println(Arrays.toString(list));
//			}

			// 브루트포스로 인접행렬과 값이 같다면 삭제해보자.
			// 1회 검사할 때마다 boolean 값을 바꿔줘야겠다.
			cnt = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < M; col++) {
					closeI(row, col);
					closeJ(row, col);

				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (check[r][c] && arr[r][c]!=0) {
						arr[r][c] = 0;
						cnt++;
					}
				}
			}
//			System.out.println("cnt : " +cnt);
			

			if (cnt == 0) {
//				System.out.println("실행됐나?");
				doSum();
			}
//			System.out.println("인접값을 0으로 바꾼 후 배열");
//			for(int[] list : arr) {
//				System.out.println(Arrays.toString(list));
//			}
		}
//		
////		for(boolean[] list : check) {
////			System.out.println(Arrays.toString(list));
////		}

		result = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				result += arr[row][col];
			}
		}
		System.out.println(result);

	}

	// 회전 후 인접한 것이 없다면 sum 메서드 수행
	public static void doSum() {
		// 합을 먼저 구해보자.
		int sumCnt = 0;
		sum=0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (arr[row][col] != 0) {
					sum += arr[row][col];
					sumCnt++;
				}
			}
		}
//		System.out.println("sum : "+sum);
		double avg = 0;
		if(sumCnt!=0) {
			avg = (double) sum /(double) sumCnt;
//			System.out.println("avg : "+avg);
			
		}

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (arr[row][col] != 0) {

// 틀린다면 여기 확인 ##############################################
					// 크거나 같다 부분 확인
					if (arr[row][col] > avg) {
						arr[row][col]--;
					} else if(arr[row][col]<avg){
						arr[row][col]++;
					}
				}
			}
		}
	}

	public static void closeI(int row, int col) {
		// 같은 원판에서 인접한 경우를 구현해보자.
		// 원판에 들어올 수 있는 수는 M개이다.
		// 3가지 경우로 나눠서 생각해보자.
		// 들어오는 값이 0인경우, 들어오는 값이 M인 경우, 그 외

		// 들어오는 값이 M-1인 경우
		if (col == M - 1) {
			if (arr[row][M - 1] == arr[row][M - 2]) {
				check[row][M - 1] = check[row][M - 2] = true;
			}
			if (arr[row][M - 1] == arr[row][0]) {
				check[row][M - 1] = check[row][0] = true;
			}
		} else if (col == 0) {
			if (arr[row][0] == arr[row][M - 1]) {
				check[row][0] = check[row][M - 1] = true;
			}
			if (arr[row][0] == arr[row][1]) {
				check[row][0] = check[row][1] = true;
			}
		}

		else {
			if (arr[row][col] == arr[row][col - 1]) {
				check[row][col] = check[row][col - 1] = true;
			}
			if (arr[row][col] == arr[row][col + 1]) {
				check[row][col] = check[row][col + 1] = true;
			}
		}

		// 값을 한번에 갱신하자.
//		for(int i = 0; i<M; i++) {
//			if(check[row][i]) {
//				arr[row][i]=0;
//				cnt++;
//			}
//		}

	}

	public static void closeJ(int row, int col) {
		// 3가지로 나누어서 생각해보자.
		// col은 같으니,,, 행 값만 확인하면 되겠다.
		
		if (row == N - 1) {
			if (arr[N - 1][col] == arr[N - 2][col]) {
				check[N - 1][col] = check[N - 2][col] = true;
			}
		} else if (row == 0) {
			if (arr[0][col] == arr[1][col]) {
				check[0][col] = check[1][col] = true;
			}
		} else {
			if (arr[row][col] == arr[row + 1][col]) {
				check[row][col] = check[row + 1][col] = true;
			}
			if (arr[row][col] == arr[row - 1][col]) {
				check[row][col] = check[row - 1][col] = true;
			}
		}
		
//		for(int i = 0; i<N; i++) {
//			if(check[i][col]) {
//				arr[i][col]=0;
//				cnt++;
//			}
//		}

		// 원판은 다르지만 순서는 같은 경우를 구현해보자.
	}

	// 회전하는 메서드 만들어보자.
	// 방향과 횟수, row를 파라미터로 받자.
	// row는 고정이고 col이 움직일꺼기 때문
	public static void spin(int row, int dir, int n) {

		// 회전 방향이 시계방향인 경우
		if (dir == 0) {
			for (int i = 0; i < n; i++) {
				// 끝에 번호 저장해놓고
				int temp = arr[row][M - 1];
				for (int j = M - 1; j >= 1; j--) {
					arr[row][j] = arr[row][j - 1];
				}
				arr[row][0] = temp;
			}
		}
		// 반시계인 경우
		else {
//			System.out.println(" 나 수행중");
			for (int i = 0; i < n; i++) {
				// 0 번호 저장해놓고
//				System.out.println(arr[row][0]);
				int temp = arr[row][0];
				for (int j = 1; j < M ; j++) {
					arr[row][j-1] = arr[row][j];
				}
				arr[row][M - 1] = temp;
//				System.out.println(Arrays.toString(arr[row]));
			}
//			System.out.println("여기 수행한 결과");
		}
//		System.out.println("ed");
	}
}
