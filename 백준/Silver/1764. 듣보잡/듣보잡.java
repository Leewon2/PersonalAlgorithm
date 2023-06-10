

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=1; i<=n; i++) {
			map.put(br.readLine(), i);
		}
		for(int i=0; i<m; i++) {
			String str = br.readLine();
//			System.out.println(i);
			Integer x = map.get(str);
			if(x!=null) {
				pq.offer(str);
			}
		}
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
