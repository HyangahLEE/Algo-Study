package week16;

import java.util.*;

/*
 * ����_11656_���̻�迭
 */
public class Problem_11656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		List<String> suffix = new ArrayList<>();
		for(int i=0; i<S.length(); i++) {
			suffix.add(S.substring(i, S.length()));
		}
		suffix.sort(null);
		for(String s : suffix) {
			System.out.println(s);
		}
	}
}
