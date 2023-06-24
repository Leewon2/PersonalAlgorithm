

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		long[][] arr = new long[N+1][N+1];
		for(int i=0; i<N+1; i++) {
			Arrays.fill(arr[i], 1500000000);
		}
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int depart = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			if(arr[start][depart]!=1500000000) {
				arr[start][depart]=Math.min(arr[start][depart], value);
			}else {
				arr[start][depart] = value;
			}
//			System.out.println("start : "+start + " depart : "+depart+" value :"+value);
//			System.out.println(arr[start][depart]);
		}
//		for(long[] list : arr) {
//			System.out.println(Arrays.toString(list));
//		}
//		System.out.println("");
  		
		
		// 경출도
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j || k==i || k==j) continue;
					
					arr[i][j]=Math.min(arr[k][j]+arr[i][k], arr[i][j]);
				}
			}
		}
//		for(int[] list : arr) {
//			System.out.println(Arrays.toString(list));
//		}
//		System.out.println("");
//  		
//		for(int[] list : result) {
//			System.out.println(Arrays.toString(list));
//		}
		StringBuilder sb = new StringBuilder();
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				if(arr[r][c]==1500000000)
					sb.append(0).append(" ");
				else
				sb.append(arr[r][c]).append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
