/* 문제
 * 666은 종말을 나타내는 수라고 한다. 종말의 수는 어떤 수에 6이 적어도 3개이상 연속되는 수 이다.
 * 숌은 영화 제목을 만드는데, 종말의 수를 포함하여 영화 제목을 짓고자 한다.
 * 예를 들어, 제일 작은 종말의 수는 666이고, 다음은 1666, 2666, 3666 .... 이다.
 * N번째 영화의 제목은 N번째로 작은 종말의 수 와 같다고 할 때,
 * N번째 영화의 제목에 들어간 수를 출력하는 프로그램을 작성해보자.
 * 
 * 
 * 조건 
 * N은 1만 이하의 자연수이다.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int idx=0;
		for(int i=666; ; i++) {
			String x = Integer.toString(i);
			if(!x.contains("666")) {
				continue;
			}else {
				idx++;
			}
			if(idx==N) {
				System.out.println(i);
				break;
			}
		}
		
	}
}
