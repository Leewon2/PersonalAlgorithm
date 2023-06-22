

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<c; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double N = Double.parseDouble(st.nextToken());
			double[] arr = new double[(int) N];
			double sum=0;
			for(int i=0; i<N; i++) {
				arr[i]=Double.parseDouble(st.nextToken());
				sum+= arr[i];
			}
//			System.out.println(sum);
			double avg = sum/arr.length;
//			System.out.println(avg);
			int idx=0;
			
			for(int i=0; i<N; i++) {
				if(arr[i]>avg) idx++;
			}
//			System.out.println(idx);
			double res = (idx/N) * 100;
//			System.out.println(res);
//			System.out.println(idx);
//			System.out.println((float) 3 / (float) 2);
//			System.out.println(idx/N);
			
			String result = String.format("%.3f", res);
			System.out.println(result+"%");
		}
	}
}
