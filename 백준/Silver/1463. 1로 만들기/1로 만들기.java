

import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[1000001];

		for(int i=2; i<=1000000; i++) {
			boolean check = false;
			if(i%2==0) {
				check=true;
				if(arr[i]!=0) {
					arr[i]=Math.min(arr[i], arr[i/2]+1);
					arr[i]=Math.min(arr[i], arr[i-1]+1);
				}else {
					arr[i]=Math.min(arr[i/2]+1, arr[i-1]+1);
				}
			}
			if(i%3==0) {
				check=true;
				if(arr[i]!=0) {
					arr[i]=Math.min(arr[i], arr[i]=arr[i/3]+1);
					arr[i]=Math.min(arr[i], arr[i-1]+1);
				}else {
					arr[i]=Math.min(arr[i/3]+1, arr[i-1]+1);
				}
			}
			if(!check) {
				arr[i]=arr[i-1]+1;
			}
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(arr[n]);
	}
}
