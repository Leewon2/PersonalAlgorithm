// 문제
// 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점 까지 가야한다.
// 각각의 계단에는 일정한 점수가 쓰여있고, 계단을 밟으면 그 계단의 점수를 얻는다.
// 한번에 한 계단 혹은 두 계단씩 오를 수 있고, 연속된 세개의 계단을 모두 밟을수는 없다.
// 시작점은 계단에 포함되지 않고, 마지막 도착 계단은 반드시 밟아야 한다.
// 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구해보자.

// 문제 조건
// 시작점은 계단에 포함되지 않고, 마지막 도착 계단은 반드시 밟아야 한다.
// 계단의 개수는 300 이하의 자연수이고, 계단에 쓰여있는 점수는 10,000 이하의 자연수이다.

// 문제 해결 방법
// 1. n개의 숫자를 입력 받아 배열에 저장한다.
// 2. 점화식을 세워 최댓값을 출력해보자.
// 2-1. 계단의 마지막은 무조건 밟아야 하므로, 마지막을 기준으로 점화식을 세워보자.
// 2-2. 마지막 계단이 x라고 할 때, 마지막 계단은 무조건 밟으므로,
// x-1 혹은 x-2를 밟았다는 소리다. 만약 x-2


import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];

		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			switch (i) {
			case 0:
				dp[0] = arr[0];
				break;
			case 1:
				dp[1] = Math.max(arr[1], arr[0] + arr[1]);
				break;
			case 2:
				dp[2] = Math.max(arr[1] + arr[2], arr[0] + arr[2]);
				break;
			}
		}

		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2])+arr[i];
		}

		System.out.println(dp[n-1]);

	}

}
