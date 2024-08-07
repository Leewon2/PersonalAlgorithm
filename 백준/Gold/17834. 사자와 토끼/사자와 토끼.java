import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<List<Integer>> list;
	static int[] arr;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		arr = new int[N + 1];
		visited = new boolean[N + 1];
		cnt = 0;
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);

		}

		arr[1] = 1;
		DFS(1);
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 1)
				cnt++;
		}
		System.out.println(cnt * (N - cnt) * 2);
	}

	private static void DFS(int idx) {

		for (int i = 0; i < list.get(idx).size(); i++) {
			int x = list.get(idx).get(i);
			if (visited[x]) {
				if (arr[x] == arr[idx]) {
					System.out.println(0);
					System.exit(0);

				}
				continue;
			}
			arr[x] = arr[idx] * -1;
			visited[x] = true;
//			if(arr[x]==1) cnt++;
			DFS(x);
		}

	}
}
