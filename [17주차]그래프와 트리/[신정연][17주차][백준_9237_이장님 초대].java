package week17;

import java.util.*;

/*
 * ����_9237_����� �ʴ�
 * ���� �ϳ��� �ɴµ� �ɸ��� �ð��� 1��.
 * ������ �ɴ� ������ �����ϰ� ��� ������� �ִ��� ���� �ʴ�.
 * 
 * 4
 * 2 3 4 3
 * --------
 * 7
 * 
 * 6
 * 39 38 9 35 39 20
 * -----------------
 * 42
 */
public class Problem_9237 {
	public static void rev(List<Integer> list) {
		list.sort(null);
		Collections.reverse(list);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> times = new ArrayList<>();
		for(int i=0; i<N; i++) {
			times.add(sc.nextInt());
		}
		rev(times);
		List<Integer> days = new ArrayList<>();
		for(int i=1; i<=times.size(); i++) {
			days.add(i + times.get(i-1));
		}
		rev(days);
		System.out.println(days.get(0)+1);
	}
}
