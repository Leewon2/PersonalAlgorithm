

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static boolean[] visited;
	static Queue<Integer> q;
	static Queue<String> q3;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			visited = new boolean[10001];
			q = new LinkedList<>();
			q3 = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.offer(x);
			String result = "";
			visited[x] = true;

			outer: while (true) {

				while (!q.isEmpty()) {
					int n = q.poll();

					String res = q3.isEmpty() ? "" : q3.poll();

					if (n == y) {
						result = res;
						break outer;
					}
					int d = D(n);
					int s = S(n);
					int l = L(n);
					int r = R(n);
					if(!visited[d]) {
						visited[d]=true;
						q.offer(d);
						q3.offer(res+"D");
					}
					if(!visited[s]) {
						visited[s]=true;
						q.offer(s);
						q3.offer(res+"S");
					}
					if(!visited[l]) {
						visited[l]=true;
						q.offer(l);
						q3.offer(res+"L");
					}
					if(!visited[r]) {
						visited[r]=true;
						q.offer(r);
						q3.offer(res+"R");
					}
				}

			}
			sb.append(result).append("\n");

		}
		System.out.println(sb);

//			x=D(x);
//			System.out.println(x);
	}

	public static int D(int x) {
		return x * 2 < 10000 ? x * 2 : x * 2 % 10000;
	}

	public static int S(int x) {
		return x - 1 != -1 ? x - 1 : 9999;
	}

	public static int L(int x) {
		int result = x * 10 + (x / 1000) - (x / 1000) * 10000;
		return result;

	}

	public static int R(int x) {
		int result = (x % 10) * 1000 + x / 10;
		return result;
	}

}
