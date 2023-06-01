

import java.util.Scanner;

public class Main {
	
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		result=0;

		// 찾을 r, c
		int r = sc.nextInt();
		int c = sc.nextInt();

		int len = (int) Math.pow(2, N);
		
		find(len,r,c);
		
		System.out.println(result);

	}

	public static void find(int len, int r, int c) {
		
		if(len==1) return;
		
		// 1사분면
		if(len/2 >r && len/2 <=c) {
			// result에 뭘 더해야할까?
			// 8*8 예시를 보니까, 1사분면 시작은 16이다. 16은 8*2이고,
			// 이거는 4*4가 되네 4는 8/2니까 len/2가 되겠다.
			result += len/2 * len/2;
			// 보낼 때 column은 len/2를 빼줘야 그 사각형 안에서 다시 탐색 가능
			find(len/2, r, c-len/2);
		}
		
		// 2사분면
		else if(len/2>r && len/2>c) {
			// 이건 시작이 0이니까 result에 뭐 추가할게 없네
			find(len/2, r,c);
		}
		
		// 3사분면
		else if(len/2<=r && len/2>c) {
			// 3사분면 시작은 8*8에서 32이고, 이거는 4*4*2가 된다.
			result+=len/2*len/2 * 2;
			find(len/2,r-len/2,c);
		}
		
		// 4사분면
		else if(len/2<=r && len/2<=c) {
			// 4사분면 시작은 48
			result+=len/2*len/2 * 3;
			find(len/2,r-len/2,c-len/2);
		}
	}
}
