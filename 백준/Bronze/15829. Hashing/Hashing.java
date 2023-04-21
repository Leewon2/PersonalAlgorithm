

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// String으로 문자를 입력 받자.
		String str = br.readLine();

		// 결과값을 저장할 변수를 만들자.
		int result = 0;

		// 문자열의 길이만큼 반복하며
		// 계산을 위해 문자열 하나하나를 char형으로 바꿔준다.
		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);

			// 문자 - 문자는 아스키 코드 값으로 계산 되어서 정수로 반환되므로
			// x-'a'를 하고, a는 1이므로, 1을 더해준다.
			// math.pow 메서드를 이용해 31의 i승을 곱한 값을 result에 더해가자.
			result += (x - 'a' + 1) * Math.pow(31, i);

		}

		System.out.println(result);
	}
}
