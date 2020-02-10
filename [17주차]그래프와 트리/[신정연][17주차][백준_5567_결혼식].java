package week17;

import java.util.*;

/*
 * ����_5567_��ȥ��
 * 
 * �����(1)�� ģ��, ģ���� ģ��
 * 
 * 6	n : ���� ��
 * 5	m : ���� ��
 * 1 2
 * 1 3
 * 3 4
 * 2 3
 * 4 5
8
8
1 2
1 3
4 1
5 1
2 6
3 7
8 7
2 3
 */
public class Problem_5567 {
	static int n;
	static int m;
	public static void dfs(int[][] list, int friend, int level, boolean[] vst) {
		if(level == 2) return;
		for(int i=0; i<m; i++) {
			if(list[i][0] == friend && vst[list[i][1]] == false) {
				vst[list[i][1]] = true;
				dfs(list, list[i][1], level+1, vst);
			} else if(list[i][1] == friend && vst[list[i][0]] == false) {
				vst[list[i][0]] = true;
				dfs(list, list[i][0], level+1, vst);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] list = new int[m][2];
		for(int i=0; i<m; i++) {
			list[i][0] = sc.nextInt();
			list[i][1] = sc.nextInt();
		}
		
		boolean[] vst = new boolean[n+1];
		vst[1] = true;  // �����
		
		for(int i=0; i<m; i++) {
			int level = 0;  // ģ���� ģ���� level 2
			if(list[i][0] == 1) {
				vst[list[i][1]] = true;
				dfs(list, list[i][1], level+1, vst);
			} else if(list[i][1] == 1) {
				vst[list[i][0]] = true;
				dfs(list, list[i][0], level+1, vst);
			}
		}
		int invited = -1;
		for(boolean v : vst) invited += (v?1:0);
		
//		Queue<Integer> q = new LinkedList<>();
//		q.add(1);  // ������� �й�
//		while(!q.isEmpty()) {
//			int current = q.poll();  // ��ä ģ��
//			for(int i=0; i<m; i++) {
//				int friend1 = list[i][0];  // ���� ģ���� ģ��
//				int friend2 = list[i][1];  // ���� ģ���� ģ��
//				if(list[i][0] == current && vst[friend2] == false) {  // ���� ģ���� ģ���� �湮���� �ʾҴٸ�
//					q.add(friend2);
//					vst[friend2] = true;
//					invited++;
//				} else if(list[i][1] == current && vst[friend1] == false) {
//					q.add(friend1);
//					vst[friend1] = true;
//					invited++;
//				}
//			}
//			level++;  // ������� ģ���� �� ���� level == 1, ģ���� ģ������ �� ���� level == 2
//			if(level == 2) break;
//		}
		
		System.out.println(invited);
	}
}
