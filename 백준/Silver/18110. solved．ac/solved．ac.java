
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); 
		int[] arr = new int[n];
		int x = (int) Math.round(n*0.15);
		for(int i=0; i<n ;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
//		System.out.println(x);
		double sum=0;
		for(int i=(int) x; i<n-x; i++) {
//			System.out.println(arr[i]);
			sum+=arr[i];
		}
//		System.out.println(sum);
		int result = (int) Math.round(sum/(n-2*x));
		
		System.out.println(result);
	}
}
