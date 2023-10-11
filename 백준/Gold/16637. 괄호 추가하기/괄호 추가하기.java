

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static long res;
	static String str;
	static long[] arr;
	static char[] sign;

	static boolean[] check;
	static boolean[] checkSign;
	static long[] compareArr;

	public static void main(String[] args) throws IOException {
		input();
		if (N != 1) {
			firstCalculate();
			perm(0);
		System.out.println(res);
		}else{
			System.out.println(arr[0]);
		}
	}

	private static long calculate(char oper, long x, long y) {
		if (oper == '+') {
			return x + y;
		} else if (oper == '-') {
			return x - y;
		} else {
			return x * y;
		}
	}

	// 부분집합
	private static void perm(int idx) {
		if (idx == arr.length) {
			// System.out.println("idx : "+idx);
			compareArr = new long[arr.length];
			checkSign = new boolean[arr.length];

			// System.out.println(Arrays.toString(check));
			for (int i = 0; i < arr.length; i++) {
				compareArr[i] = arr[i];
			}

			for (int i = 0; i < arr.length - 1; i++) {
				if (check[i]) {
					compareArr[i] = compareArr[i + 1] = calculate(sign[i], arr[i], arr[i + 1]);
					checkSign[i] = true;
				}
			}

			long sum = compareArr[0];
			for (int i = 0; i < arr.length - 1; i++) {
				if (!checkSign[i]) {
					sum = calculate(sign[i], sum, compareArr[i + 1]);
				}
			}
			// System.out.println(Arrays.toString(compareArr));
			res = Math.max(res, sum);
			return;
		}

		check[idx] = true;
		if (idx + 2 < arr.length) {
			perm(idx + 2);
		} else {
			perm(idx + 1);

		}
		// System.out.println(idx);
		check[idx] = false;
		if (idx + 1 < arr.length) {
			perm(idx + 1);
		}
	}

	private static void firstCalculate() {
		long sum = calculate(sign[0], arr[0], arr[1]);
		for (int i = 1; i < arr.length - 1; i++) {
			sum = calculate(sign[i], sum, arr[i + 1]);
		}
		res = sum;
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		arr = new long[N / 2 + 1];
		sign = new char[N / 2];
		res = 0;
		int idx = 0;
		int idx2 = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 0) {
				arr[idx++] = Character.getNumericValue(str.charAt(i));
			} else {
				sign[idx2++] = str.charAt(i);
			}
		}
		check = new boolean[arr.length];
	}
}
