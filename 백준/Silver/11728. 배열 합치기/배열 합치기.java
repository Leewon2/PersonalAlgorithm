

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static int[] result;
	static StringBuilder sb ;

	public static void main(String[] args) throws IOException {
		input();
		res();
	}

	private static void res(){
		sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}


	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[N+M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = N; i < N+M; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(result);
	}
}
