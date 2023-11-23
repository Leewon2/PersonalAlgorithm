
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int X;
	static int[][] arr;
	static int[] visited;
	static int[] toX;
	static int[] fromX;

	public static void main(String[] args) throws IOException{
		input();
		shortDis();
		disFromX();
		// System.out.println(Arrays.toString(toX));
		int max=0;
		for (int i = 1; i < fromX.length; i++) {
			max =Math.max(max, toX[i]+fromX[i]);
		}
		System.out.println(max);
	}


	// 각 숫자에서 X까지 가는 최소 거리 구하기
	private static void shortDis(){
		for (int i = 1; i <= N; i++) {
			int[] number = new int[N + 1];
			Arrays.fill(number, Integer.MAX_VALUE);
			PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.road, o2.road));
			visited = new int[N+1];
			number[i]=0;
			// 시작점 pq에 넣기
			for (int j = 1; j <= N; j++) {
				if(arr[i][j]!=0){
					pq.offer(new Node(i, j, arr[i][j]));
					number[j]=arr[i][j];
				}
			}
			while (!pq.isEmpty()) {
				Node poll = pq.poll();
				int start = poll.start;
				int end = poll.end;
				int road = poll.road;
				// road가 가장 작은게 뽑혀있을 테니,,,
				// 이 end랑 연결되어 있는 애를 찾고 pq에 넣는다.
				// 그럼 다시 뽑혔을 때, road가 가장 작은애가 뽑힐꺼고,
				// pq에 넣을 때, 저장되어 있는 값이랑, 새로 생성된 값이랑 비교해서 넣는다.
				for(int j=1; j<=N; j++){
					if(arr[end][j]!=0){
						// 0이 아니라면, 연결되어 있다는 소리
						// 연결되어 있으니, 값을 비교해보자.
						// 만약 현재 저장되어 있는 값 보다 새로운 값이 작다면 갱신한다.
						if(number[j]>number[end]+arr[end][j]){
							number[j] = number[end]+arr[end][j];
							pq.offer(new Node(end, j, arr[end][j]));
						}
					}
				}
			}
			toX[i] = number[X];
		}
	}
	private static void disFromX(){

			Arrays.fill(fromX, Integer.MAX_VALUE);
			PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.road, o2.road));
			visited = new int[N+1];
		fromX[X]=0;
			// 시작점 pq에 넣기
			for (int j = 1; j <= N; j++) {
				if(arr[X][j]!=0){
					pq.offer(new Node(X, j, arr[X][j]));
					fromX[j]=arr[X][j];
				}
			}
			while (!pq.isEmpty()) {
				Node poll = pq.poll();
				int start = poll.start;
				int end = poll.end;
				int road = poll.road;
				// road가 가장 작은게 뽑혀있을 테니,,,
				// 이 end랑 연결되어 있는 애를 찾고 pq에 넣는다.
				// 그럼 다시 뽑혔을 때, road가 가장 작은애가 뽑힐꺼고,
				// pq에 넣을 때, 저장되어 있는 값이랑, 새로 생성된 값이랑 비교해서 넣는다.
				for(int j=1; j<=N; j++){
					if(arr[end][j]!=0){
						// 0이 아니라면, 연결되어 있다는 소리
						// 연결되어 있으니, 값을 비교해보자.
						// 만약 현재 저장되어 있는 값 보다 새로운 값이 작다면 갱신한다.
						if(fromX[j]>fromX[end]+arr[end][j]){
							fromX[j] = fromX[end]+arr[end][j];
							pq.offer(new Node(end, j, arr[end][j]));
						}
					}
				}
			}

	}
	// X에서 각 번호로 가는 최소 거리 구하기
	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int road = Integer.parseInt(st.nextToken());
			arr[start][end] = road;
		}
		toX = new int[N+1];
		fromX = new int[N+1];

	}
	private static class Node {
		int start;
		int end;
		int road;
		public Node(int start, int end, int road){
			this.start=start;
			this.end=end;
			this.road=road;
		}
	}
}
