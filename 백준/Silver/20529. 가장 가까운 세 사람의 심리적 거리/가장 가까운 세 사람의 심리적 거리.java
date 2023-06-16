

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<t; tc++) {
			int result=Integer.MAX_VALUE;
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n]; 
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i]=st.nextToken();
			}
			if(n>=48) sb.append(0).append("\n");
			else {
				
				for(int i=0; i<n-2; i++) {
					for(int j=i+1; j<n-1; j++) {
						for(int k=j+1;k<n; k++) {
							int res=0;
							for(int l=0; l<4; l++) {
								if(arr[i].charAt(l)!=arr[j].charAt(l)) res++;
								if(arr[i].charAt(l)!=arr[k].charAt(l)) res++;
								if(arr[j].charAt(l)!=arr[k].charAt(l)) res++;
							}
							result=Math.min(result, res);
						}
					}
				}
				sb.append(result).append("\n");
			}
		}
		System.out.println(sb);
	}
}
