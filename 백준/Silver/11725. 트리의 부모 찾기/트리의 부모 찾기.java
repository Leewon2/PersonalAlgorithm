
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static boolean[] visited;
	static int[] result;
	static int N;
	static ArrayList<Integer>[] list;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		q= new LinkedList<>();
		result = new int[N+1];
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		q.offer(1);
		visited[1]=true;
		bfs();
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<N+1; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
		
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			int x = q.poll();
			visited[x]=true;
			for(int i=0; i<list[x].size(); i++) {
				int y = list[x].get(i);
				if(!visited[y]) {
					result[y]=x;
					q.offer(y);
				}
			}
		}
	}
}
