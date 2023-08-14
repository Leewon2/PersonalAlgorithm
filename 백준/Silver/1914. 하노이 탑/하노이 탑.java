/* 문제
 * 세 개의 장대가 있고, 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여있다.
 * 각 원판은 반경이 큰 순서대로 쌓여있고, 다음 규칙에 따라 세 번째 장대로 옮기려고 한다.
 * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 * 이 작업을 수행하는데 필요한 최소 이동 횟수를 출력해보자.
 * 
 * 
 * 
 * 조건
 * 장대에 쌓인 원판의 갯수 N은 1 이상 100 이하다.
 * N이 20 이하인 경우에는 두 번째 줄 부터 수행 과정을 출력한다.
 * 수행 과정 A B를 출력하는데, A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
 * 
 * 
 * 문제 해결 방법
 * 
 * 
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	static int N;
	
	static int cnt;
	
	static StringBuilder sb = new StringBuilder();

	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		BigInteger result = new BigInteger("1");
		
		if(N>20) {
			for(int i=0; i<N; i++) {
				result = result.multiply(new BigInteger("2"));
			}
			result = result.subtract(new BigInteger("1"));
			System.out.println(result);
				
		}else {
			hanoi(N, 1, 3, 2);
			System.out.println(cnt);
			System.out.println(sb);
			
		}
		
		
	}

	// 기둥이 3개이므로, 의 파라미터를 받아보자.
	// from은 시작점, to는 도착점, other은 나머지 기둥이다.
	public static void hanoi(int num, int from, int to, int other) {
		// 재귀조건
		if (num == 0) {
//			System.out.println(from+" "+other);
			return;
		}
		hanoi(num - 1, from, other, to);
		cnt++;
		if (N <= 20) {
			sb.append(from).append(" ").append(to).append("\n");
		}
		hanoi(num - 1, other, to, from);

	}
}
