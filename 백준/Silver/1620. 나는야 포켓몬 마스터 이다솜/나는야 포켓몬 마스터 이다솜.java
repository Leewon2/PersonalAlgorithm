
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int find = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> poket = new HashMap<>();
		Map<String, Integer> poket2 = new HashMap<>();
		
		for(int i=1; i<=n; i++) {
			String x= br.readLine();
			poket.put(i, x);
			poket2.put(x, i);
		}
		
		for(int i=0; i<find; i++) {
			String str = br.readLine();
//			System.out.println("나 str : "+str);
			boolean checkNumber = false;
			for (int j = 0; j < str.length(); j++) {
			    if (Character.isDigit(str.charAt(j))) {
			    	checkNumber = true;
			        break;
			    }
			}
			
			if(checkNumber) {
				int result = Integer.parseInt(str);
				System.out.println(poket.get(result));
			}else {
				System.out.println(poket2.get(str));
			}
		}
	}
}
