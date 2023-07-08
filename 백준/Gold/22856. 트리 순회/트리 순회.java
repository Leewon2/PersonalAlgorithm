

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	
	static List<Node>[] arr;
	static List<Integer> inorder;
	static int cnt;
	static int N;
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}

		// 배열에 값 입력
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int leftChild = Integer.parseInt(st.nextToken());
			int rightChild = Integer.parseInt(st.nextToken());
			arr[parent].add(new Node(leftChild,rightChild));
		}
		inorder = new ArrayList<>();
		dfs(1,0,true);
		dfs(1,0,false);
	}

	private static void dfs(int now, int parent, boolean check) {
		for(Node node : arr[now]) {
			if(node.l != -1) {
				dfs(node.l, now, check);	
				if(!check) cnt++;
			}
			if(check) {
				inorder.add(now);
			} else {
				if(inorder.get(inorder.size()-1) == now) {
					System.out.println(cnt);
					return;
				}
				cnt++;
			}
			if(node.r != -1) {
				dfs(node.r, now, check);	
				if(!check) cnt++;
			}
		}
		
		
	}
	private static class Node{
		int l;
		int r;
		public Node(int l, int r) {
			this.r=r;
			this.l=l;
		}
	}
}
