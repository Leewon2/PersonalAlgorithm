
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		int N = sc.nextInt();
		
		long[] arr = new long[K];
		
		long max=0;
		
		long min=0;
		
		for(int i=0; i<K; i++) {
			arr[i]=sc.nextLong();
			max=Math.max(arr[i], max);
		}
		
		
		long result=0;
		
		while(min<=max) {
			long mid = (max+min)/2;
            if(mid==0) mid=1;
//			System.out.println(mid);
			int sum=0;
			for(int i=0; i<K; i++) {
				sum+=(int) arr[i]/mid;
			}
			// sum이 N보다 크거나 같아지는 경우
			if(sum>=N) {
				// 결과값이랑 mid중에 큰 값을 결과값에 저장
				result=Math.max(result, mid);
				min=mid+1;
			}else {
				max=mid-1;
			}
		}
		
		System.out.println((int) result);
		
		
		
		
	}
}
