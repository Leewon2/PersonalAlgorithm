
import java.io.*;
import java.util.Arrays;
import java.util.*;
public class Main {

	static	List<Point>[] adjList;
	static public class Point implements Comparable<Point>{
		int to;
		int weight;
		Point(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
		public int compareTo(Point o) {
			return this.weight-o.weight;
		}
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		str = new StringTokenizer(br.readLine()," ");
		int E = Integer.parseInt(str.nextToken());
		
		adjList = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		for(int i=0; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i = 1; i<=M; i++) {
			str = new StringTokenizer(br.readLine()," ");
			adjList[Integer.parseInt(str.nextToken())].add(new Point(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken())));
		}
		
		int[] dist = new int[N+1];
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.offer(new Point(E,0));
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[E] = 0;
		while(!q.isEmpty()) {
			Point current = q.poll();
			if(visited[current.to]) {
				continue;
			}
			visited[current.to] = true;

			int size = adjList[current.to].size();
			for (int j = 0; j < size; j++) {
				Point i =adjList[current.to].get(j);
				if (!visited[i.to]
						&& dist[i.to] > dist[current.to] + i.weight) {
					dist[i.to] = i.weight + dist[current.to];
					q.offer(new Point(i.to,dist[i.to]));
				}
			}
			
		}
		for(int i=1; i<=N; i++) {
			if(dist[i]!=Integer.MAX_VALUE) {
				sb.append(dist[i]+"\n");
			}
			else {
				sb.append("INF"+"\n");
			}
		}
		System.out.println(sb.toString());
	}

}