

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for (int j = 0; j <= K; j++) {
				
				// 담을 수 없는경우 그대로 가져오기
				if(j<w) {
					arr[i][j] = arr[i-1][j];
				}else {
					arr[i][j]=Math.max(arr[i-1][j], arr[i-1][j-w]+c);
				}
				
			}
		}
		System.out.println(arr[N][K]);
	}
}
