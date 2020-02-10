package week16;

import java.util.*;

/*
 * ����_1316_�׷� �ܾ� üĿ
 */
public class Problem_1316 {
	public static boolean groupCheck(String S) {
		int len = S.length();
		if(len == 1) {
			return true;
		}
		Set<Character> alpha = new HashSet<>();  // �ߺ� x
		alpha.add(S.charAt(0));
		int groupCnt = 1;
		for(int i=1; i<len; i++) {
			alpha.add(S.charAt(i));
			if(S.charAt(i-1) != S.charAt(i)) {  // �ٲ�� �������� �׷찹�� �÷���.
				groupCnt++;
			}
		}
		if(groupCnt == alpha.size()) {  // �׷� ������ ����� ���ĺ��� ������ ������ �׷� �ܾ���.
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for(int i=0; i<N; i++) {
			String S = sc.next();
			if(groupCheck(S) == true) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
