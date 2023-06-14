

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int M = sc.nextInt();
		
		int[][] arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(arr[i], 500000);
			arr[i][i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N;j++) {
					arr[i][j]=Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		int min = 500000;
		int answer = 1;
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<N; j++) {
				sum = sum + arr[i][j];
			}
			if(min>sum) {
				min = sum;
				answer = i+1;
			}
		}
		System.out.println(answer);
	}
}
