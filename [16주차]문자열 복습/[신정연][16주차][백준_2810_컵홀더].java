package week16;

import java.util.*;

/*
 * ����_2810_��Ȧ��
 */
public class Problem_2810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String seats = sc.next();
		int cnt = 0;
		for(int i=0; i<N; i++) {
			char c = seats.charAt(i);
			if(c == 'S') {
				cnt++;
			} else {
				cnt++;
				i++;
			}
		}
		if(cnt + 1 > N) {  // ���� ��� ���� ���ϴ� ���̱� ������ �¼������� ������ �Ⱦ��� ��Ȧ���� ���� ��.
			System.out.println(N);
		} else {
			System.out.println(cnt + 1);			
		}
	}
}
