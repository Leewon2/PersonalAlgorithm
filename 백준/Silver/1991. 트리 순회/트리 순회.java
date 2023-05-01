

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static char[][] arr;

	static char[] result;

	static int idx;

	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new char[N][3];

		// 0번쨰는 부모
		// 1번째는 left
		// 2번째는 right
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.next().charAt(0);
			arr[i][1] = sc.next().charAt(0);
			arr[i][2] = sc.next().charAt(0);
		}

		sb = new StringBuilder();

		pretree('A');
		sb.append("\n");
		inordertree('A');
		sb.append("\n");
		posttree('A');
		System.out.println(sb);
	}

	private static void pretree(char root) {
		sb.append(root);
		for(int i=0; i<N; i++) {
			if(arr[i][0]==root) {
				if(arr[i][1] != '.') {
					pretree(arr[i][1]);
				}
				if(arr[i][2]!='.') {
					pretree(arr[i][2]);
				}
			}
		}
		
	}

	private static void inordertree(char root) {
		
		for(int i=0; i<N; i++) {
			if(arr[i][0]==root) {
				if(arr[i][1] != '.') {
					inordertree(arr[i][1]);
				}
				sb.append(root);
				if(arr[i][2]!='.') {
					inordertree(arr[i][2]);
				}
			}
		}
	}

	private static void posttree(char root) {
		for(int i=0; i<N; i++) {
			if(arr[i][0]==root) {
				if(arr[i][1] != '.') {
					posttree(arr[i][1]);
				}
				if(arr[i][2]!='.') {
					posttree(arr[i][2]);
				}
				sb.append(root);
			}
		}
	}

}
