
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static List<List<Integer>> list;
	static int[] forget;
	static int[] result;
	static boolean[] forComb;
	static int res;
	static int[] forgetDay;

	public static void main(String[] args) throws IOException {
		input();
		perm(0);
		System.out.println(res);
	}

	private static int calculate() {
		forgetDay = new int[2000];
		int re = 0;
		for (int i = 0; i < M; i++) {
			int k = result[i];
			for (int j = 0; j < list.get(k).size(); j++) {
				int x = list.get(k).get(j);
				// x일에 끝나는 날은 i+forget[x]가 된다.
				if (forgetDay[x]>i) {
					continue;
				}else{
					re++;
					forgetDay[x]=i+forget[x];
				}
			}
		}
		return re;
	}

	private static void perm(int idx) {
		if (idx == M) {
			// 메서드 자리
			res = Math.min(res, calculate());
			return;
		}
		for (int i = 0; i < M; i++) {
			if (!forComb[i]) {
				result[idx] = i;
				forComb[i] = true;
				perm(idx + 1);
				forComb[i] = false;
			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		forComb = new boolean[M];
		list = new ArrayList<>();
		res = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			list.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		forget = new int[N + 1];
		for (int i = 0; i < N; i++) {
			forget[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			for (int j = 0; j < number; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		forgetDay = new int[2000];
	}
}
