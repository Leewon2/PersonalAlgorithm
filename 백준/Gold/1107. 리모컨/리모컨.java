
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 현재채널은 100

		// 이동하려고 하는 채널
		int N = sc.nextInt();

		int M = sc.nextInt();

		boolean[] use = new boolean[10];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			use[x] = true;
		}
		
		int result=Math.abs(N-100);
		
		for(int i=0; i<=999999; i++) {
			String check = Integer.toString(i);
			boolean containUse = false;
			
			for(int j=0; j<check.length(); j++) {
				if(use[check.charAt(j)-'0']) {
					containUse=true;
					break;
				}
			}
			
			if(!containUse) {
				int min = Math.abs(N-i) + check.length();
				result = Math.min(min,result);
			}
		}
		System.out.println(result);


	}
}
