

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int k;
	static boolean[] check;
	static int[] arr;
	static int[] result;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			k = sc.nextInt();
			if(k==0) break;
			check = new boolean[k];
			arr = new int[k];
			result = new int[6];
			
			for(int i=0; i<k; i++) {
				arr[i] =sc.nextInt();
			}
			recursion(0, 0);
			System.out.println();
		}
	}
	
	public static void recursion(int idx, int start) {
		if(idx==6) {
			for(int i=0; i<result.length; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		// 나를 사용하고 재귀
		for(int i=start; i<k; i++) {
			if(!check[i]) {
				result[idx] = arr[i];
			}
			check[i]=true;
			recursion(idx+1,i+1);
			check[i]=false;
//			recursion(idx,start+1);
		}
		// 나를 사용하지 않고 재귀
	}
}
