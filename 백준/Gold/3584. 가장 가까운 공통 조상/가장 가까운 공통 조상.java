

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	static int n;

	static Queue<Integer> q;

	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < t; tc++) {
			q = new LinkedList<>();

			
			n = Integer.parseInt(br.readLine());

			arr = new int[n + 1];

			for (int i = 0; i < n - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				// 반대로 넣어야지

				// 자식인덱스에 부모 번호를 넣자.
				arr[child]=parent;
			}
			

			StringTokenizer st = new StringTokenizer(br.readLine());

			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			while (true) {
				if(left!=0 && q.contains(left)) {
					sb.append(left).append("\n");
					break;
				}
				q.offer(left);
				left=arr[left];
				if(right!=0 && q.contains(right)) {
					sb.append(right).append("\n");
					break;
				}
//				System.out.print("left : "+left);
//				System.out.println(" right : "+right);
				q.offer(right);
				right=arr[right];
				
				
				
			}
		}
		
		System.out.println(sb);
	}

}
