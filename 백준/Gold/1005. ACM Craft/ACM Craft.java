

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 건물의 갯수
			int N = Integer.parseInt(st.nextToken());
			// 건물 순서 규칙의 갯수
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N + 1];
			
			int[] res = new int[N+1];

			int[] indegree = new int[N + 1];

			List<List<Integer>> list = new LinkedList<>();
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[][] map = new int[N + 1][N + 1];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				// x에 y값 저장
				list.get(x).add(y);
				indegree[y]++;
			}

			int W = Integer.parseInt(br.readLine());

			// q 선언
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[N + 1];

			for (int i = 1; i < indegree.length; i++) {
				if (indegree[i] == 0) {
					q.offer(i);
					visited[i] = true;
					res[i]=arr[i];
				}
			}

			while (!q.isEmpty()) {
				int poll = q.poll();
				if (poll == W)
					break;
				int max = 0;
				for (int j = 0; j < list.get(poll).size(); j++) {
					// 저장된 y값 확인
					int y = list.get(poll).get(j);
					res[y]=Math.max(res[y], arr[y]+res[poll]);
					// degree빼주고
					indegree[y]--;
					if (indegree[y] == 0) {
						// 방문체크 안되어 있다면??
						// 방문체크 먼저하자
						visited[y] = true;
						// q에 넣어주기
						q.offer(y);
						max = Math.max(max, arr[y]);
					}

				}
			}
			sb.append(res[W]).append("\n");

		}
		System.out.println(sb);

	}
}
