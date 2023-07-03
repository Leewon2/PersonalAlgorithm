import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Main {


	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int k = sc.nextInt();
			for(int j=x; j<=y; j++) {
				arr[j-1]=k;
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
