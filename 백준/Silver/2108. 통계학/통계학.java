

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		double sum=0;
		
		int[] cnt = new int[8001];
		
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
			cnt[arr[i]+4000]++;
		}
		
		int max=0;
		
		int maxCnt=0;
		
		Arrays.sort(arr);
		

		
		double avg = Math.round(sum/N);

		
		int mid = arr[N/2];
		
		int range = arr[N-1]-arr[0];
		
		int idx=1;
		
		for(int i=0; i<=8000; i++) {
			if(cnt[i]>= max) {
				if(cnt[i]==max) {
					idx++;
					
					if(idx==1 || idx==2) {
						max=cnt[i];
						maxCnt=i;
					}
				}else {
					idx=1;
					max=cnt[i];
					maxCnt=i;
				}
			}
		}

		System.out.println((int)avg);
		System.out.println(mid);
		System.out.println(maxCnt-4000);
		System.out.println(range);
		
	}
}
