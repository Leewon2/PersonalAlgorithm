

import java.util.Scanner;

public class Main {
	
	private static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int S = sc.nextInt();
		
		int[] arr =new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 최소 길이를 저장할 변수
		int max=INF;

		
		int start=0;
		int end=0;
		// start의 idx를 저장할 변수
		int sum=0;
		// start와 end가 끝 지점에 도달할 때 까지 반복해보자.
		while(end!=N) {
//			System.out.println(max);
			if(max==1) break;
//			System.out.println("start" + start);
//			System.out.println("end"+end);
			// end-start+1은 현재 최소 길이를 의미하는데,
			// 최소 길이가 max보다 크거나 같은 경우는 확인할 필요가 없다.
			// start를 하나 늘려주고 continue 하자.
			if(end-start+1 >=max) {
				sum-=arr[start];
				start++;
				continue;
			}
			// M보다 커지는 순간을 기록해보자.
			// 1. start와 end가 같은 경우
			if(start==end) {
				// sum에 arr[start]저장
				sum=arr[start];
				
				// sum이 S보다 크다면?
				if(sum>=S) {
					// 길이는 1이 되고, 1은 언제나 최소 길이기 때문에 break 하자.
					max=1;
				}
				// sum이 S보다 작다면?
				// 여기서 end는 끝점이 아니어야 늘릴 수 있다.
				else if(sum<S) {
					// 끝점만 하나 늘리자.
					end++;
				}
			}
			
			// 2. start와 end가 다른 경우
			else {
				// sum에는 start~end-1까지의 정보가 저장되어 있을테니
				// sum에 end값만 더해주자.
				if(end!=N) {
					sum+=arr[end];
//					System.out.println("sum : "+sum);
//					System.out.println("start : " + start);
//					System.out.println("end : " + end);
				}else {
					sum+=arr[end-1];
				}
				// S보다 크거나 같아진 경우
				if(sum>=S) {
					// 위의 조건에서 end-start+1이 max보다 크거나 같아지면
					// 여기까지 못온다. 여기까지 왔다는 것은 end-start+1이 최솟값이라는 것
					max=end-start+1;
					// sum이 S보다 커졌으니, start를 하나 늘려서 다시 비교해봐야겠다.
					sum-=arr[start];
					// 위 식에서 sum에 arr[end]를 더해주므로 end값도 빼주자.
					sum-=arr[end];
					start++;
				}
				// S보다 작은 경우
				else {
					// end가 N-1이라면 더이상 커질 수 없으므로 break
					if(end==N-1 || end==N) break;
					// end가 N-1이 아니면 끝점만 늘리자.
					end++;
				}
				
			}
			
		}
		
		System.out.println((max==INF) ? 0 : max);
	}
}
