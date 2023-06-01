

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// DP 0,1 나눠서 배열로 만들기
		// 범위는 0부터 40이니까 41로 설정
		int[] dpZero = new int[41];
		int[] dpOne = new int[41];
		
		// 0번째 값 저장
		dpZero[0]=1;
		dpOne[0]=0;
		
		// dp배열 채우기
		for(int i=1; i<=40; i++) {
			// 0의 갯수는 이전의 1의 갯수와 동일
			dpZero[i]=dpOne[i-1];
			// 1의 갯수는 (이전의 0의 갯수 + 이전의 1의 갯수)
			dpOne[i]=dpZero[i-1]+dpOne[i-1];
		}
		
		for(int i=0; i<T; i++) {
			int num = sc.nextInt();
			System.out.println(dpZero[num]+" "+dpOne[num]);
		}
		
		
	}
}
