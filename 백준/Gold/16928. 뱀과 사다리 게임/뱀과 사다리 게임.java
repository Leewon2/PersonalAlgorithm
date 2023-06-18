
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 사다리 수
		int N = Integer.parseInt(st.nextToken());
		// 뱀의 수
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[101];
		boolean[] visited = new boolean[101];

		int start = 1;

		// 사다리와 뱀의정보 모두 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x] = y;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x] = y;
		}

		int result = 0;

		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		q.offer(1);

		outer: while (true) {

			while (!q.isEmpty()) {
				q2.offer(q.poll());
//				System.out.println(1);
			}

			while (!q2.isEmpty()) {

				int poll = q2.poll();
//				System.out.println(poll);

				if (poll == 100)
					break outer;
				if (poll > 100)
					continue;

				boolean[] check = new boolean[7];

				for (int j = 1; j <= 6; j++) {
					if (poll + j > 100)
						break;

					if (poll + j == 100) {
						break outer;
					}

					if (!visited[arr[poll + j]] && arr[poll + j] != 0) {
						check[j] = true;
						q.offer(arr[poll + j]);
						visited[arr[poll + j]] = true;
					}
					for (int k = 6; k >= 1; k--) {

						if (poll + k <= 100 && !visited[poll + k] && arr[poll + k] == 0) {

							q.offer(poll + k);
							visited[poll + k] = true;
							break;

						}
					}
				}
			}
			result++;
		}
		System.out.println(result + 1);

	}
}
