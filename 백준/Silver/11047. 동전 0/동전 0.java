

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K =Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		int result = 999999999;
		
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		
		
		for(int i=N-1; i>=0; i--) {
			int compare = K;
			int calculate=0;
			if(arr[i]>K) continue;
			for(int j=i; j>=0; j--) {
				
				if(compare-arr[j]<0) continue;
				else {
					calculate+=compare/arr[j];
					compare%=arr[j];
				}
				if(compare==0) {
					result=Math.min(result, calculate);
					break;
				}
			}
		}
		System.out.println(result);
		
	}
}
