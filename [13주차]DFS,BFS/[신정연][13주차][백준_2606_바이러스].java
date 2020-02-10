package week13;

import java.util.*;

/*
 * ����_2606_���̷���
 * 1�� ��ǻ�Ͱ� �� ���̷����� �ɷ��� ��, 1�� ��ǻ�͸� ���� �� ���̷����� �ɸ��� �Ǵ� ��ǻ���� ���� ù° �ٿ� ���.
 * 
 * 7	��ü ��ǻ�� ��.
 * 6	��Ʈ��ũ �󿡼� ���� ����Ǿ� �ִ� ���� ��.
 * 1 2
 * 2 3
 * 1 5
 * 5 2
 * 5 6
 * 4 7
 * ----
 * 4
 */
public class Problem_2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int com = sc.nextInt();
		int net = sc.nextInt();
		int[][] network = new int[net][2];
		
		for(int i=0; i<net; i++) {
			network[i][0] = sc.nextInt();
			network[i][1] = sc.nextInt();
		}
		
		Queue<Integer> next = new LinkedList<>();
		next.add(1);
		boolean[] vst = new boolean[com+1];
		int cnt = 0;
//		List<Integer> vst = new ArrayList<>();
		
		while(!next.isEmpty()) {
			int current = next.poll();
			if(!vst[current]) {
				vst[current] = true;
				cnt++;
			}
			for(int i=0; i<net; i++) {
				if(network[i][0] == current || network[i][1] == current) {
					if(!vst[network[i][1]]) {
						next.add(network[i][1]);
					} else if(!vst[network[i][0]]) {
						next.add(network[i][0]);
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
