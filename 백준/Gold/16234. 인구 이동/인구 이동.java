

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	
	static int N;
	static int L;
	static int R;
	static int[][] map;
	static Queue<Node> q;
	static int result;
	static boolean[][] visited;
	static final int[] dr = {-1,0,1,0};
	static final int[] dc = {0,-1,0,1};
	static boolean[][] used;
	static boolean check;
	
	static boolean goon;
	
	static int sum;
	
	static int len;
	
	static int checkidx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		L = sc.nextInt();
		
		R = sc.nextInt();
		
		result = 0;
		
		map = new int[N][N];
		
		
		
		
		
		for(int row=0; row<N; row++) {
			for(int col=0; col<N; col++) {
				map[row][col] = sc.nextInt();
			}
		}
		
		q= new LinkedList<>();
		check = true;
		while(check) {
			check=false;
			visited = new boolean[N][N];
			used = new boolean[N][N];
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					if(!visited[row][col]) {
//						goon=false;
						bfs(row, col);
						
//						System.out.println("###visit");
//						for(boolean[] list : visited) {
//							System.out.println(Arrays.toString(list));
//						}
						
						if(checkidx>0)
							circulate();
//						System.out.println("##");
//						for(int[] list : map) {
//							System.out.println(Arrays.toString(list));
//						}
						
//						circulate();
						
					}
					
				}
			}
			result++;
		}
		System.out.println(result-1);
			
	}
	private static void circulate() {
		sum=0;
		len=0;
		
		for(int row=0; row<N; row++) {
			for(int col=0; col<N; col++) {
				if(!used[row][col] && visited[row][col]) {
					sum+=map[row][col];
					len++;
				}
			}
		}
		
		for(int row=0; row<N; row++) {
			for(int col=0; col<N; col++) {
				if(!used[row][col] && visited[row][col]) {
					map[row][col] = sum/len;
					used[row][col]=true;
				}
			}
		}
	}
	
	
	private static void bfs(int r, int c) {
		q.offer(new Node(r,c));
//		visited[r][c]=true;
		checkidx=-1;
		while(!q.isEmpty()) {
			checkidx++;
			Node poll = q.poll();
			
			int row = poll.row;
			int col = poll.col;
			for(int i=0; i<dr.length; i++) {
				int newR = row+dr[i];
				int newC = col+dc[i];
				if(newR<0 || newC<0 || newR>=N || newC>=N || visited[newR][newC]) continue;
				if(Math.abs(map[row][col]-map[newR][newC])>=L && Math.abs(map[row][col]-map[newR][newC])<=R) {
					check=true;
//					goon=true;
					visited[newR][newC] = true;
					q.offer(new Node(newR,newC));
				}
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
