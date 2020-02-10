package week14;

import java.util.*;

/*
 * ������ �������� ���� �迭
 * array�� �� element �� divisor�� ������ �������� ���� ������������ ������ �迭�� ��ȯ.
 */
public class Programmers_lv1_2 {
	public static int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0)
				list.add(arr[i]);
		}
		if (list.size() == 0)
			list.add(-1);
		list.sort(null);
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] rst = solution(new int[] { 1, 2, 5, 6, 8, 7, 12, 16 }, 4);
		for (int r : rst)
			System.out.println(r);
	}
}
