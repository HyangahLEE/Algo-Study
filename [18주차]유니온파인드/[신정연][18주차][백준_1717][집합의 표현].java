package week18;

import java.util.*;

/*
 * ����_1717_������ ǥ��
 */
public class Problem_1717 {
	static int[] arr;
	public static void union(int a, int b) {  // ����Ǿ��ٸ� �ϳ��� �θ�� ��ġ��.
		a = find(a);
		b = find(b);
		if (a != b) {
			arr[b] = a;
		}
	}
	public static int find(int a) {  // �θ� ã��
		if(a == arr[a]) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n+1];
		for(int i=0; i<n+1; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			int inst = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(inst == 0) {
				union(a, b);
			} else {
				if(find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
