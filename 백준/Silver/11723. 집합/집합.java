

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {

		boolean[] check = new boolean[21];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for (int idx = 0; idx < M; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				check[num]=true;

			} else if (str.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				int result = check[num] ? 1 : 0;
				sb.append(result).append("\n");
				
			}else if(str.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				check[num]=false;
				
			}else if(str.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				check[num] = !check[num];
				
			}else if(str.equals("all")) {
				for(int i=1; i<=20; i++) {
					check[i]=true;
				}
			}else {
				check = new boolean[21];
			}

		}
		System.out.println(sb);

	}
}
