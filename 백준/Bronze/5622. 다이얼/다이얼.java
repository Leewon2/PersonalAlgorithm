import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] arr = new int[26];
		arr[25]=10;
		int idx=2;
		for(int i=0; i<25; i++) {
			if(i%3==0) idx++;
			arr[i]=idx;
		}
		arr[18] = 8;
		arr[21]=9;
		arr[24]=10;
//		System.out.println(Arrays.toString(arr));
		int result=0;
		
		for(int i=0; i<str.length(); i++) {
			int x = str.charAt(i)-'A';
			result+=arr[x];
		}
		System.out.println(result);
	}
}
