

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main{
	
	static String str;
	static String find;
	
	static Stack<Character> stack;
	
	static String compare;
	
	static boolean check;
	
	static int idx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		find = br.readLine();
		
		stack = new Stack<>();
		
		bomb();
		StringBuilder sb  = new StringBuilder();
		// 스택에 남아있는 녀석들을 다시 문자열로 만들어주자.
		for(char c : stack) {
			sb.append(c);
		}
		
		// sb는 등가비교가 안되니까 string으로 바꾸자
		String result = sb.toString();
		
		System.out.println(result.length()!=0 ? result : "FRULA");
	}
	
	private static void bomb() {
		for(int i=0; i<str.length(); i++) {
			stack.push(str.charAt(i));
			
			// 스택에 들어있는것보다 find가 커지면 비교해보자.
			if(stack.size()>=find.length()) {
				// 폭발 문자열인지 확인
				boolean check = true;
				
				// find의 길이만큼 반복하면 될듯
				for(int j=0; j<find.length(); j++) {
					// 끝에서부터 확인해보자.
					if(stack.get(stack.size()-find.length()+j) != find.charAt(j)) {
						// 다르면 false로 바꾸고 바로 break
						check = false;
						break;
					}
				}
				// 폭발 문자열이라면?
				if(check) {
					// 스택에서 제거해야겠다.
					for(int j=0; j<find.length(); j++) {
						// 어디서부터 제거하던 상관없으니 그냥 빼버리자.
						stack.pop();
					}
				}
			}
		}
	}
}
