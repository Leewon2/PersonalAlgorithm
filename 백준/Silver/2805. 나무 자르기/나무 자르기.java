
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 나무의 수
		int N = sc.nextInt();
		
		// 필요한 나무의 길이
		int M = sc.nextInt();
		
		long[] arr = new long[N];

		// 결과값 저장 변수
		long result=0;
		
		long min=0;
		
		// 최댓값 찾기
		long max=0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		
		while(min<=max) {
			// 중간값 찾기
			long mid=(min+max)/2;
			// 자른 나무 길이 저장할 변수
			long sum=0;
			
			for(int i=0; i<N; i++) {
				long tree = arr[i]-mid;
				// 자른 나무의 길이 구하기
				if(tree>0) {
					sum+=tree;
				}
			}
			// 필요한 나무의 길이보다 크거나 같으면?
			if(sum>=M) {
				// 절단기의 높이를 더 올릴 수 있다.
				min=mid+1;
				result=Math.max(result, mid);
			}
			// 필요한 나무를 얻지 못했다면?
			else {
				// 높이를 줄여보자.
				max=mid-1;
			}
		}
		System.out.println((int) result);
	}
}
