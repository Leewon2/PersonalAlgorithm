import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mon = sc.nextInt();
		int day = sc.nextInt();
		int[] date1 = {0,31,59,90,120,151,181,212,243,273,304,334};
		String[] date2 = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		System.out.println(date2[(date1[mon-1]+day)%7]);
		
			
		
	}
}
