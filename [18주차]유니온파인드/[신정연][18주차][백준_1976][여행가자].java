package week18;

import java.util.*;

/*
 * ����_1976_���� ����
 */
public class Problem_1976 {
	static int[] arr;
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			arr[b] = a;
		}
	}
	public static int find(int a) {
		if(a == arr[a]) {
			return a;
		} else {
			return arr[a] = find(arr[a]);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();  // ��ü ������ ��
		int M = sc.nextInt();  // ���� ��ȹ�� ���� ������ ��
		arr = new int[N+1];
		for(int i=1; i<N+1; i++) arr[i] = i;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				int conn = sc.nextInt();
				if(conn == 1) {
					union(i, j);
				}
			}
		}
		
		int temp = sc.nextInt();
		int current;
		for(int i=0; i<M-1; i++) {
			current = sc.nextInt();
			if(find(temp) != find(current)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
