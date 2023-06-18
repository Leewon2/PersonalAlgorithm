

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(arr[i], 500000);
			
		}
		
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				arr[r][c]=Integer.parseInt(st.nextToken());
				if(arr[r][c]==0) arr[r][c]=500;
			}
		}
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N;j++) {
					
					arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(arr[r][c]==500) arr[r][c]=0;
				else arr[r][c]=1;
			}
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.print(arr[r][c]+" ");
			}
			System.out.println();
		}
	}
}
