package week20;

import java.util.*;

/*
 * �ּ� ���� Ʈ�� - ���� �˰���?
 * ����_2887_�༺ �ͳ�
 */
public class Problem_2887_2 {
	public static int minCost(int[] a, int[] b) {
		int minX = Math.abs(a[0] - b[0]);
		int minY = Math.abs(a[1] - b[1]);
		int minZ = Math.abs(a[2] - b[2]);
		int min = Math.min(minX, Math.min(minY, minZ));
		return min;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();  // �༺ ����
		List<int[]> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() });
		}
		
		Queue<int[]> q = new LinkedList<>();
		boolean[] vst = new boolean[N];
		q.add(list.get(0));
		vst[0] = true;
		
		int[] minCosts = new int[N];
		Arrays.fill(minCosts, 2147483647);

		int currentIdx = 0;
		int sum = 0;
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int nextIdx = 0;
			for(int i=0; i<N; i++) {
				if(vst[i]) continue;  // �� �ڽ��̶��� �� ����, �̹� �湮�� �༺�� �� ����
				int min = minCost(current, list.get(i));  // �� �༺ ���� �ּ� ���
				minCosts[currentIdx] = Math.min(min, minCosts[currentIdx]);  // ���� �༺��� �� �� �ּ� ��� ����.
				if(min == minCosts[currentIdx]) nextIdx = i;
			}
			if(vst[nextIdx] == false) {
				q.add(list.get(nextIdx));
				vst[nextIdx] = true;
			}
			if(minCosts[currentIdx] < 2147483647) {
				sum += minCosts[currentIdx];				
			}
			currentIdx = nextIdx;
		}
		System.out.println(sum);
	}
}
