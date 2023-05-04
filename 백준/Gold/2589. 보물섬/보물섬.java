

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int r;
	static int c;
	
	static char[][] arr;
	
	static boolean[][] visited;
	
	static int[][] count;
	
	static Queue<Node> q=new LinkedList<>();
	
	static int max;
	
	static final int[] dr = {1,0,-1,0};
	static final int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		
		visited = new boolean[r][c];
		
		
		
		max=0;
		
		for(int row=0; row<r; row++) {
			String str = br.readLine();
			for(int col=0; col<c; col++) {
				arr[row][col]=str.charAt(col);
			}
		}
		
		for(int row=0; row<r; row++) {
			for(int col=0; col<c; col++) {
				visited = new boolean[r][c];
				if(!visited[row][col] && arr[row][col]=='L') {
					q.offer(new Node(row, col));
					count = new int[r][c];
					visited[row][col]=true;
					bfs();
					for(int rrr=0; rrr<r; rrr++) {
						for(int ccc=0; ccc<c; ccc++) {
							max = Math.max(max, count[rrr][ccc]);
						}
					}
				}
				
			}
		}
		
		System.out.println(max);
//		for(int[] list : count) {
//			System.out.println(Arrays.toString(list));
//		}
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Node poll = q.poll();
			int rr = poll.row;
			int cc= poll.col;
			
			
			for(int i=0; i<dr.length; i++) {
				
				int newR = rr+dr[i];
				int newC = cc +dc[i];
				// 범위 벗어나는 경우
				if(newR<0 || newC<0 || newR>=r || newC>=c || visited[newR][newC] || arr[newR][newC]=='W') continue;
				
				visited[newR][newC]=true;
				q.offer(new Node(newR,newC));
				
				count[newR][newC]=count[rr][cc]+1;
				
				
			}
			
		}
		
		
		
	}
	
	private static class Node{
		int row;
		int col;
		public Node(int row, int col) {
			this.row=row;
			this.col=col;
		}
	}
	
}
