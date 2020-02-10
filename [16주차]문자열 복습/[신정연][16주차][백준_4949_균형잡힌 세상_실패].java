package week16;

import java.util.*;
import java.io.*;

/*
 * ����_4949_�������� ����
 * ( 40
 * ) 41
 * [ 91
 * ] 93
 */
public class Problem_4949 {
	public static boolean isBalanced(String S) {
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();
		int len = S.length();
		for(int i=0; i<len; i++) {
			char c = S.charAt(i);
			if(c == '(' || c == ')' || c == '[' || c == ']') {
				queue.add(c);  // ��ȣ�� ����.
			}
		}
		
		while(!queue.isEmpty()) {
			if(queue.peek() == '(' || queue.peek() == '[') {  // ������ ��ȣ�� queue���� ������ stack�� ����.
				stack.push(queue.poll());
			} else if(!stack.isEmpty()) {  // ������ ��ȣ�ε� stack�� ������ ��ȣ�� �ִ� ���.
				if(queue.peek() - stack.peek() <= 2) {  // �ùٸ� ¦�̸� �� �� ������
					queue.poll();
					stack.pop();
				} else {  // �ùٸ��� ���� ¦ -> ���� x
					return false;
				}
			} else {  // ������ ��ȣ�ε� stack�� ����ִٴ� ���� ������ �� ���� �����ٴ� �� -> ���� x
				return false;
			}
		}
		
		if(stack.size() > 0) {  // ������ ��ȣ�� ���� ��� ¦�� ���� �ʴ� �� -> ���� x
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		do {
			if(isBalanced(S) == true) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			S = br.readLine();
		} while(!S.equals("."));
	}
}
