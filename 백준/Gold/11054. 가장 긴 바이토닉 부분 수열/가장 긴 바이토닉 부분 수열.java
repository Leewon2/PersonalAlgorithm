
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 아이디어
	// 2차원 배열을 만든다.
	// 첫번째는 값이 들어가고, 두번째는 최대값이 들어간다.
	// 그 다음 수를 확인하고 자기자신이 더 크다면 +1을 한다.
	// 그 다음으로 뒤에서부터 다시 본다.
	// 마지막에는 두개를 합친다음 -1을 한다.
	static int N;
	static int[] frontDp;
	static int[] backDp;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		calculateFront();calculateBack();
		System.out.println(finalCalculate());
		// System.out.println(Arrays.toString(frontDp));
		// System.out.println(Arrays.toString(backDp));
	}

	private static int finalCalculate(){
		int max=0;
		for (int i = 0; i < N; i++) {
			max = Math.max(frontDp[i]+backDp[i], max);
		}
		return max-1;
	}

	private static void calculateFront(){
		for (int i = 0; i < N; i++) {
			frontDp[i]=1;
			for (int j = 0; j < i; j++) {
				if(arr[i]>arr[j]) frontDp[i] = Math.max(frontDp[i],frontDp[j]+1 );

			}
		}
	}
	private static void calculateBack(){
		for (int i = N-1; i >=0 ; i--) {
			backDp[i]=1;
			for (int j = i+1; j < N; j++) {
				if(arr[i]>arr[j]) backDp[i] = Math.max(backDp[i], backDp[j]+1 );

			}
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		frontDp = new int[N];
		backDp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}
