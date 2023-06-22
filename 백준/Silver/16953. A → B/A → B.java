
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Queue<Long> q;
	static Queue<Long> q2;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		q = new LinkedList<>();
		q2 = new LinkedList<>();
		q.offer(A);
		result=1;
		bfs(B);
		System.out.println(result);
	}
	
	public static void bfs(Long B) {
		outer : while(true) {
			if(q.isEmpty()) {
				result=-1;
				break;
			}
			
			while(!q.isEmpty()) {
				q2.offer(q.poll());
			}
			
			while(!q2.isEmpty()) {
				long poll = q2.poll();
				if(poll==B) 
					break outer;
				
				if(poll*10+1<=B) q.offer(poll*10+1);
				if(poll*2<=B) q.offer(poll*2);
			}
			result++;
		}
		
	}
}
