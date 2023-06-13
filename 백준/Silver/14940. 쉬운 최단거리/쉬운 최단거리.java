

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{

	static int n;
	static int m;
	static int[][] map;
	static int[][] moveMap;
	static boolean[][] visited;
	static final int[] dr = {1,0,-1,0};
	static final int[] dc = {0,1,0,-1};
	static Queue<Node> q;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		q = new LinkedList<>();
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		moveMap = new int[n][m];
		visited= new boolean[n][m];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 2) {
					q.offer(new Node(r,c));
					visited[r][c]=true;
				}
			}
		}
		
		bfs();
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if(map[r][c]==1 && moveMap[r][c]==0) {
					moveMap[r][c]=-1;
				}
			}
		}
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				System.out.print(moveMap[r][c]+" ");
			}
			System.out.println();
		}

	}
	public static void bfs() {
		while(!q.isEmpty()) {

			Node poll = q.poll();
			int row = poll.row;
			int col = poll.col;
			
			for(int d=0; d<dr.length; d++) {
				int newRow = row+dr[d];
				int newCol = col+dc[d];
				if(newRow<0 || newCol<0 || newRow>=n || newCol>=m) continue;
				
				if(!visited[newRow][newCol] && map[newRow][newCol]==1) {
					visited[newRow][newCol]=true;
					moveMap[newRow][newCol]=moveMap[row][col]+1;
					q.offer(new Node(newRow,newCol));
				}
			}
		}
	}
	
	public static class Node{
		int row;
		int col;
		public Node(int row, int col) {
			this.row=row;
			this.col=col;
		}
	}
}
