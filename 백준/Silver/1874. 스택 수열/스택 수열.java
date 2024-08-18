import java.util.Scanner;
import java.util.Stack;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
	
		
		boolean check = true;
		
		int save=0;
		
		stack.push(0);
		
		outer: for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			if(stack.peek()==x) {
				sb.append("-").append("\n");
				stack.pop();
			}
			
			else if(stack.peek()<x) {
				for(int j=save+1; j<=x; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				save=stack.pop();
				sb.append("-").append("\n");
			}else {
				check=false;
                break outer;
			}
		}
		System.out.println((check) ? sb : "NO");
		
	}
}
