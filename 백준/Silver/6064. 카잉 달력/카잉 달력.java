

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int idx=0;
			int maxMonth = sc.nextInt();
			int maxDay = sc.nextInt();
			int findMonth = sc.nextInt()-1;
			int findDay = sc.nextInt()-1;
			
			for(int i=findMonth; i<(maxMonth*maxDay); i+=maxMonth) {
//				System.out.println(i+"나는아이");
				if(i%maxDay ==findDay) {
					System.out.println(i+1);
					idx++;
					break;
				}
			}
			if(idx==0) {
				System.out.println(-1);
			}
			
		}
	}
}
