import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main {
	static int T;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb=new StringBuilder();
		
		
		T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			Stack<Character> stack = new Stack<>();
			String str=br.readLine();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='(') {
					stack.push(str.charAt(j));
				}
				if(stack.isEmpty() && str.charAt(j)==')') {
					stack.push(str.charAt(j)); // 아래 NO, YES 출력하기 위해 그냥 push 
					break;
				}
				if(!stack.isEmpty() && str.charAt(j)==')') {
					stack.pop();
				}
				
			}
			if(!stack.isEmpty()) { 
				sb.append("NO\n");
			}else {
				sb.append("YES\n");
			}
			
		}
		System.out.println(sb);
	}
}