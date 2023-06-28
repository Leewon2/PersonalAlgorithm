import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=N;i>0; i--) {
			for(int j=i; j>0; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
