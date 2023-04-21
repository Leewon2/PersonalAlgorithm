
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 카운팅 배열을 이용해보자.
		// 1만 이하의 자연수이므로, 배열의 크기는 10001로 정한다.
		int[] arr = new int[10001];
		
		
		for(int i=0; i<N; i++) {
			// 입력받은 값의 인덱스를 하나 늘려준다. 
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		br.close();
		
		// 한번에 출력하기 위해 StringBuilder를 이용해보자.
		StringBuilder sb = new StringBuilder();
		
		// 카운팅 배열을 확인해보자.
		// 자연수이므로, 1부터 시작해도 되겠다.
		for(int i=1; i<arr.length; i++) {
			// 0이면 확인할 필요가 없겠다.
			if(arr[i]==0) continue;
			
			// 1이상인 경우에는 해당 인덱스의 값이 몇인지 확인해보자.
			// 만약 i가 1이고, arr[i]는 2라면, 숫자1이 2개 있다는 뜻이다.
			else {
				
				// 반복문을 이용해, arr[i]가 0이 될 때 까지 반복해보자.
				while(arr[i]!=0) {
					// Stringbuilder에 연결하고, 해당 인덱스의 크기를 줄여주자.
					sb.append(i).append("\n");
					arr[i]--;
				}
			}
		}
		
		// 출력
		System.out.println(sb);
	}
}
