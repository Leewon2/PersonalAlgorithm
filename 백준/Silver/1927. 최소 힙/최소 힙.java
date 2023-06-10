
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			long num = Long.parseLong(br.readLine());
			if(num==0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.offer(num);
			}
		}
	}
}
