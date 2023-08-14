

import java.util.Scanner;

public class Main{
	
	public static final int num = 10007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println((factorial(N) * reverse((factorial(N - K) * factorial(K)) % num, num - 2)) % num);
	}

	static int factorial(int N) {

		if (N == 0) {
			return 1;
		}
		return (N * factorial(N - 1)) % num;
	}
 

	static int reverse(int a, int p) {
		int res = 1;
		while(p > 0) {
			if(p % 2 == 1) {
				res *= a;
				p--;
				res %= num;
			}
			a *= a;
			a %= num;
			p/=2;	// p = p/2 랑 동치 
		}
		return res;
	}
}
