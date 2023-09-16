

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		twoPointer();
	}

	private static void twoPointer() {
		int s = 0;
		int e = 0;
		int cnt = 0;
		int len = 0;
		int max = 0;
		while (e < N) {

			if (arr[e] % 2 == 1) {
				cnt++;
				if (cnt > K) {
					while (s < e) {
						if (arr[s] % 2 == 1) {
							cnt--;
							s++;
							break;
						} else {
							s++;
							len--;

						}
					}

				}

			} else {
				len++;

			}
			e++;

			max = Math.max(max, len);
		}
		System.out.println(max);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}
