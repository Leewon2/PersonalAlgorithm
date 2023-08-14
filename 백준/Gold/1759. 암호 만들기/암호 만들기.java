import java.util.Arrays;
import java.util.Scanner;
public class Main {
	/*
	 * 문제 보안 시스템은 열쇠가 아닌 암호로 동작하게 되어있다. 암호는 서로 다른 L개의 알파벳 소문자들로 구성되어 있는데, 최소 한개의 모음과
	 * 두개의 자음으로 구성되어 있다. 암호는 알파벳이 증가하는 순서로 배열된다. C개의 문자가 주어졌을 때, 가능성 있는 암호를 모두 구해보자.
	 * 
	 * 
	 * 문제 조건 구해야 하는 문자열L은 3 이상 C&&15 이하다. C개의 문자는 3&&L 이상 15 이하다. 주어지는 문자들은 모두
	 * 소문자이고, 중복되는 것은 없다.
	 * 
	 * 문제 해결 방법 알파벳 순으로 정렬하고, 중복없는 조합을 만들어보자. L개의 알파벳을 구성할 수 없다면 break 하고, 모음이 1개 이상
	 * 없거나, 자음이 2개이상 없다면 break 하자.
	 * 
	 */
	static char[] arr;
	static char[] tmp;
	static boolean[] check;
	static int completeWord;


	static void combination(int data, int idx, int start) {

		if (idx == completeWord) {
//			for (int i = 1; i < idx; i++) {
//				if (tmp[i] < tmp[i - 1])
//					return;
//			}
			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = 0; i < idx; i++) {
				if (tmp[i] == 97 || tmp[i] == 101 || tmp[i] == 105 || tmp[i] == 111 || tmp[i] == 117) {
					cnt1++;
				} else {
					cnt2++;
				}
			}
			if (cnt1 < 1 || cnt2 < 2)
				return;

			for(int i=0; i<tmp.length; i++) {
				System.out.print(tmp[i]);
			}
			System.out.println();
			return;

		}

		for (int i = start; i < arr.length; i++) {
			if (check[i])
				continue;
			tmp[idx] = arr[i];
			check[i] = true;
			combination(completeWord, idx + 1, i + 1);
			check[i] = false;
		}
	}
	public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			completeWord = sc.nextInt();
			
			int word = sc.nextInt();
			
			arr = new char[word];
			tmp = new char[completeWord];
			check = new boolean[word];
			
			
			for(int i=0; i<word; i++) {
				arr[i]=sc.next().charAt(0);
			}
			Arrays.sort(arr);
			
			
			combination(completeWord,0,0);
		}
}