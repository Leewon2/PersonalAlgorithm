

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int number = Integer.parseInt(st.nextToken());
			if(map.containsKey(number)) {
				int x = map.get(number);
				map.remove(number);
				map.put(number, x+1);
			}else {
				map.put(number, 1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int M =Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int number = Integer.parseInt(st.nextToken());
			if(map.get(number)==null) {
				sb.append(0).append(" ");
			}else {
				sb.append(map.get(number)).append(" ");
			}
		}
		System.out.println(sb);
	
		
		
	}
}
