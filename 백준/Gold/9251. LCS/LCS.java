

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		// 무조건 1이 더 길게 만들기
		if(str1.length()<str2.length()) {
			String str = str2;
			str2 = str1;
			str1 = str;
		}
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		
		for(int i=1; i<=str1.length(); i++) {
			char x=str1.charAt(i-1);
			for(int j=1; j<=str2.length(); j++) {
				char y = str2.charAt(j-1);
				if(x==y) {
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[str1.length()][str2.length()]);
	}
}
