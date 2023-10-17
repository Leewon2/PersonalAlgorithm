/* 문제
 * 백준이는 퇴사하려고 한다.
 * 오늘부터 N+1일째 되는 날 퇴사하는데, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
 * 상담을 완료하는데 걸리는 기간 T와 받을 수 있는 금액 P가 주어졌을 때,
 * 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성해보자.
 * 
 * 
 * 문제 조건
 * N은 1이상 15 이하다.
 * 상담을 완료하는데 걸리는 기간 T는 1 이상 5 이하다.
 * 받을 수 있는 금액 P는 1 이상 1000 이하다.
 * 만약 마지막 날의 T가 2 라면, N+1일에 일이 끝이나므로, 마지막날의 일은 못한다.
 * 백준이는 N+1일에 퇴사해야 하기 때문에, N일째 되는날 까지만 일을 한다.
 * 1은 하루만에 끝나므로 가능하다
 * 
 * 
 * 문제 해결 방법
 * 부분집합을 이용하여 제한된 범위 내에서 가능한 모든 경우의 수를 확인해보자.
 * 
 * 
 */



import java.util.Scanner;

public class Main {

	static int[] workingDay;
	static int[] pay;
	static boolean[] check;
	static int day;
	static int sumDay;
	static int sumPay;
	static int maxPay;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// day일 까지만 일을 한다!
		day = sc.nextInt();

		// 방문체크를 하기 위해 boolean 배열을 만들자.
		check = new boolean[day];
		workingDay = new int[day];
		pay = new int[day];

		// 걸리는 일 수와 받을 수 있는 금액을 입력 받자.
		for (int i = 0; i < day; i++) {
			workingDay[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}
		
		recursion(0);
		System.out.println(maxPay);

	}

	// 부분 조합을 이용하여 workingDay가 day를 넘지 않도록 코드를 짜보자.
	public static void recursion(int idx) {

		// 기저조건
		if (idx == day) {
			for (int i = 0; i < day; i++) {
				// true로 올라온 것 들의 day와 pay를 더해야겠지??
				if (check[i]) {
					if (i+workingDay[i] - 1 >= day)
						break;
					sumPay += pay[i];
					sumDay += workingDay[i];
					i += workingDay[i] - 1;
				}

			}
			if (sumDay <= day) {
				maxPay = Math.max(maxPay, sumPay);
			}
			sumPay = sumDay = 0;
			return;
		}

		check[idx] = true;
		recursion(idx + 1);
		check[idx] = false;
		recursion(idx + 1);

	}
}
