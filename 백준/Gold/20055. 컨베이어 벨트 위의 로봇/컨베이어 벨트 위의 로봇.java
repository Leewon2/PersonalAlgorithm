import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int K = sc.nextInt();

		// 0번 인덱스를 저장하는 값으로 사용하기 위해 2*N+1 크기의 배열로 만든다.
		// conveyor은 내구도를 저장하는 배열이다.
		int[] conveyor = new int[2 * N + 1];

		// 해당 인덱스에 로봇이 있는지 체크하기 위한 boolean 배열을 선언한다.
		boolean[] check = new boolean[2 * N + 1];

		// 0의 갯수를 세기 위한 변수를 만든다.
		int zeroCnt = 0;

		// 조건 1~4이 모두 수행되면 1단계가 늘어난다.
		// 현재 단계를 저장할 변수를 만들자.
		int cnt = 1;

		for (int i = 1; i < 2 * N + 1; i++) {
			conveyor[i] = sc.nextInt();
			if (conveyor[i] == 0)
				zeroCnt++;
		}
		// K가 zeroCnt보다 작거나 같아진다면 그 즉시 종료한다.
		while (K > zeroCnt) {
			// 마지막에 zeroCnt를 세줄꺼기 때문에 초기화 시키자
			zeroCnt = 0;

			// 1단계 : 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			// 2N 값을 0번 인덱스에 저장하고, 값을 하나씩 뒤로 미뤄보자.
			conveyor[0] = conveyor[2 * N];
			for (int i = 2 * N; i > 1; i--) {
				// 먼저 옮기자.
				if(check[i-1]) {
					
					check[i-1]=false;
					check[i]=true;
				}
				conveyor[i] = conveyor[i - 1];
				
				// i-1번째에 로봇이 있고 다음은 비어있다면?
				// i번째로 옮기고 내구도를 하나 줄여주자.
//				if (check[i - 1] && !check[i]) {
//
//					// 로봇을 한칸 이동시키자.
//					check[i - 1] = false;
//					check[i] = true;
//					if (conveyor[i] != 0)
//						conveyor[i]--;
//					// 내구도가 0이 아니라면 내구도를 하나 줄이자.
//
//				}

			}
			// 값을 다 미뤘으면, 1번 인덱스에 2N이 저장되어 있는 값을 다시 넣자.
			conveyor[1] = conveyor[0];
			// 반복문이 끝나고, N에 로봇이 있다면 로봇을 꺼내주자.
			if (check[N])
				check[N] = false;

			// 2단계 : 가장 먼저 올라간 로봇이므로, N-1부터 확인하면 되겠다.
			// 다음 내구도를 확인하고, 다음 내구도가 0이 아닌 경우에만 옮기고
			// 내구도를 줄이자.
			// 다음에 로봇이 있어도 움직이지 못한다.
			// N-1에 로봇이 있다면 N으로 위치를 옮기고 로봇을 내보내자.

			for (int i = N - 1; i > 0; i--) {
				if (check[i] && !check[i + 1] && conveyor[i + 1] != 0) {
					// 현재 위치를 false로 바꾸고
					check[i] = false;
					// 다음 위치를 true로 바꾼다.
					check[i + 1] = true;
					// 바꿨으면 내구도도 하나 줄인다.
					conveyor[i + 1]--;
				} else {
					continue;
				}
			}
			// 반복문이 끝나고, N에 로봇이 있다면 로봇을 꺼내주자.
			if (check[N])
				check[N] = false;

			// 3단계 : 올리는 위치에 내구도가 0이 아니고 로봇이 없다면 로봇을 올리자.
			// 올리는 위치는 컨베이어 벨트의 1번 인덱스이다.
			if (conveyor[1] != 0 && !check[1]) {
				check[1] = true;
				conveyor[1]--;
			}

			// 반복문이 끝나고, N에 로봇이 있다면 로봇을 꺼내주자.
			if (check[N])
				check[N] = false;

			// 4단계 : 내구도가 0이 된 갯수를 세보자.
			for (int i = 1; i < 2 * N + 1; i++) {
				if (conveyor[i] == 0)
					zeroCnt++;
			}
//			System.out.println(Arrays.toString(conveyor));
//			System.out.println(Arrays.toString(check));
			if (zeroCnt >= K)
				break;

			// 단계를 하나 늘리자
			cnt++;
		}

		System.out.println(cnt);

	}
}
