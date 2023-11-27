

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedMap;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][]visited;
	static boolean[][][] visit;
	static Queue<Node> q;
	// 동서남북 방향
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int endX;
	static int endY;
	static int endDir;
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(bfs());
		// for (boolean[] list : visited) {
		// 	System.out.println(Arrays.toString(list));
		// }
	}

	private static int bfs(){
		while (!q.isEmpty()) {
			Node poll = q.poll();
			int r = poll.r;
			int c = poll.c;
			int dir = poll.dir;
			int cnt = poll.cnt;
			if(visit[r][c][dir-1]) continue;
			// System.out.println("r:"+r+" "+" c:"+c+" "+" dir : "+dir+ " cnt : "+poll.cnt);
			if (r == endX && c == endY && dir == endDir) {;
				return cnt;
			}
			// 1,2,3칸 가는 것 확인
			for (int i = 1; i <= 3; i++) {

				int nr = r + dr[dir - 1] * i;
				int nc = c + dc[dir - 1] * i;
				if(nr<0 || nc<0 || nr>=N || nc>=M || visited[nr][nc]) continue;
				if(arr[nr][nc]==1) break;
				// System.out.println("이동했니? 이동한 좌표 : "+nr+" "+nc);
				visited[nr][nc]=true;
				q.offer(new Node(nr,nc,dir,cnt+1));
			}

			// 동쪽인 경우
			if(dir==1){
				q.offer(new Node(r,c,3,cnt+1));
				q.offer(new Node(r,c,4,cnt+1));
				q.offer(new Node(r,c,2,cnt+2));
				// System.out.println("동쪽인 경우 : 서, 남 북 으로 방향 전환");

			}
			// 서쪽인 경우
			else if(dir==2){
				q.offer(new Node(r,c,3,cnt+1));
				q.offer(new Node(r,c,4,cnt+1));
				q.offer(new Node(r,c,1,cnt+2));
				// System.out.println("서쪽인 경우 : 동, 남 북 으로 방향 전환");
			}
			// 남쪽인 경우
			else if (dir == 3) {
				q.offer(new Node(r,c,1,cnt+1));
				q.offer(new Node(r,c,2,cnt+1));
				q.offer(new Node(r,c,4,cnt+2));
				// System.out.println("남쪽인 경우 : 동, 서 북 으로 방향 전환");
			}
			// 북쪽인 경우
			else if (dir == 4) {
				q.offer(new Node(r,c,1,cnt+1));
				q.offer(new Node(r,c,2,cnt+1));
				q.offer(new Node(r,c,3,cnt+2));
				// System.out.println("북쪽인 경우 : 동, 남 서 으로 방향 전환");
			}
			visit[r][c][dir-1]=true;

		}
		return -1;
		// 총 6가지의 경우의 수를 모두 q에 넣는다.

	}

	private static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited =new boolean[N][M];
		visit = new boolean[N][M][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		int startX= Integer.parseInt(st.nextToken())-1;
		int startY = Integer.parseInt(st.nextToken())-1;
		int startDir = Integer.parseInt(st.nextToken());
		q.offer(new Node(startX, startY, startDir,0));
		visited[startX][startY]=true;
		st = new StringTokenizer(br.readLine());
		 endX = Integer.parseInt(st.nextToken())-1;
		 endY = Integer.parseInt(st.nextToken())-1;
		 endDir = Integer.parseInt(st.nextToken());

	}

	private static class Node{
		int r;
		int c;
		int dir;
		int cnt;

		public Node(int r, int c, int dir, int cnt) {
			this.r=r;
			this.c=c;
			this.dir=dir;
			this.cnt=cnt;
		}
	}
}
