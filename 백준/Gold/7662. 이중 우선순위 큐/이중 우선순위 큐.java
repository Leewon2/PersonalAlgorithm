

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static Map<Integer, Integer> map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t =0; t<tc ;t++) {
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());
			int k = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			
			for(int i=0; i<k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String calculation = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(calculation.equals("I")) {
					pq.offer(num);
					reversePq.offer(num);
					map.put(num, map.getOrDefault(num,0)+1);
				}else {
					if(map.size()!=0) {
						// 앞에서 빼기
						if(num==-1) {
							del(pq);
						}else {
							del(reversePq);
						}
					}
				}
			}
			if(map.size()==0) {
				System.out.println("EMPTY");
			}else {
				int res = del(reversePq);
	        	System.out.print(res+" "); // 최댓값 
	        	if(map.size()>0) res = del(pq);
	        	System.out.print(res+"\n"); // 최소
			}
		}
	}
	
	private static int del(PriorityQueue<Integer> q) {
		
		int result =0;
		while(true) {
			
			result=q.poll();
			int cnt = map.getOrDefault(result,0);
			if(cnt==0) continue;
			
			if(cnt==1) map.remove(result);
			else {
				map.put(result,cnt-1);
			}
			break;
		}
		return result;
		
	}
	
}
