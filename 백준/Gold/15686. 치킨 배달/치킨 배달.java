
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int[][] compare;
	static List<Node> chicken;
	static int result;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 원본배열
		map = new int[N][N];
		// 짧은거리 저장할 배열
		compare = new int[N][N];
		// 치킨집 정보 저장
		chicken = new ArrayList<>();
		result =Integer.MAX_VALUE;
		
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==2) {
					// 치킨집 정보 저장
					chicken.add(new Node(r,c));
				}
			}
		}
		visited = new boolean[chicken.size()];
		backtracking(0, 0);
		System.out.println(result);

	}
	private static void backtracking(int idx, int start) {
		// 기저조건
		if(idx==M) {
			compare = new int[N][N];
			for(int i=0; i<chicken.size(); i++) {
				if(visited[i]) {
					int r = chicken.get(i).r;
					int c = chicken.get(i).c;
					find(r,c);
				}
			}
			sum();
//			for(int[] list : compare) {
//				System.out.println(Arrays.toString(list));
//			}
			return;
		}
		
		// 재귀조건
		for(int i=start; i<chicken.size(); i++) {
//			System.out.println("스타트"+i);
			visited[i]=true;
			backtracking(idx+1, i+1);
			visited[i]=false;
		}
	}
	private static void find(int row, int col) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]==1) {
					if(compare[r][c]==0) {
						compare[r][c]=Math.abs(row-r)+Math.abs(col-c);
					}else {
						compare[r][c]=Math.min(compare[r][c], Math.abs(row-r)+Math.abs(col-c)) ;
					}
				}
			}
		}
	}
	
	private static void sum() {
		int tmp=0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				tmp+=compare[r][c];
			}
		}
		result = Math.min(tmp, result);
		
	}
	
	public static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
}
