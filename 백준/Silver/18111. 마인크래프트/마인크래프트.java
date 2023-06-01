

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		int B = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];


		int max = 0;

		int min = 999999999;
		
		int result=0;
		
		int time=999999999;
		
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[row][col]);
				max = Math.max(max, map[row][col]);
			}
		}
		
		for (int i = min; i <= max; i++) {
			int sum=0;
			int inven = B;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < M; col++) {
					int check = map[row][col]-i;
					
					if(check>0) {
						sum+=check*2;
						inven+=check;
					}
					else if(check<0) {
						sum+=Math.abs(check);
						inven+=check;
					}
				}
			}
			if(inven>=0) {
				if(time>=sum) {
					time=sum;
					result=i;
				}
			}
		}
		if(time==999999999) {
			time=0;
			result=min;
		}
		
		System.out.println(time +" "+result);

	}
}
