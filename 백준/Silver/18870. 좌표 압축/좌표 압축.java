
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] newArr;
	static int[] only;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		arr = new int[n];
		newArr = new int[n]; 
		only = new int[n]; 
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			newArr[i] = num;
		}
		Arrays.sort(arr);

		int idx = 0;
		only[0] = arr[0];
		
		for (int i = 1; i < n; i++) {
			if (only[idx] != arr[i])
				only[++idx] = arr[i];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			sb.append(binarySearch(newArr[i], idx)).append(" ");
		}
		System.out.println(sb);
	}

	public static int binarySearch(int target, int len) {
		int start = 0;
		int end = len;
		while (start < end) {
			int mid = (start + end) / 2;

			if (only[mid] >= target)
				end = mid;
			else
				start = mid + 1;
		}

		return start;
	}
}
