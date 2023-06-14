

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int S = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		int result=0;
		boolean[] visit = new boolean[str.length()+1];
		
		for(int i=0; i<str.length();i++) {
			boolean check = true;
			// true일 때 I가 나와야함
			
			if(str.charAt(i)=='I') {
//				System.out.println(i);
				for(int j=i+1; j<=i+2*N; j++) {
					if(visit[j]) 
						continue;
//					System.out.println(j);
					if(str.length()<=i+2*N) {
						check=false;
						break;
					}
					
					if(str.charAt(j-1)!=str.charAt(j)) {
						visit[j]=true;
					}else {
						check=false;
						break;
					}
				}
				if(check) {
//					System.out.println(i);
					result++;
				
				}
			}
		}
		System.out.println(result);
//		System.out.println(Arrays.toString(visit));
	}
}
