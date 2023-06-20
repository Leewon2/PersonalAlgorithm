

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();

		System.out.println(conquer(A, B, C));

	}

	public static long conquer(long A, long B, long C) {
		if (B == 1)
			return A % C;

		if (B % 2 == 0) {
			long res = conquer(A, B/2, C);
			return res*res%C;
		} else {
			long res = conquer(A, B-1, C);
			return A*res%C;
		}
		
//		return 0;

	}
}
