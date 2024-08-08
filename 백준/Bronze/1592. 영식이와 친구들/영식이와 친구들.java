import java.util.Scanner;
public class Main {public static void main(String[] args) {Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b=sc.nextInt(),c =sc.nextInt(),d=0;
		for(int i=1;i<=c; i++) {if(a%i==0 && c%i==0) d=i;}
			System.out.println((a/d)*(b-1));}}