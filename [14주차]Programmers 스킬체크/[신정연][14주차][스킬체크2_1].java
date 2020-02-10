package week14;

/*
 * H-Index
 * ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰� ������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �� �������� H-Index.
 */
public class Programmers_lv2_1 {
	static int[] cit;
	static int len;

	public static boolean hIndex(int h) {
		int more = 0;
		for (int i = 0; i < len; i++) {
			if (cit[i] >= h)
				more++;
		}
		if (more >= h)
			return true;
		return false;
	}

	public static int solution(int[] citations) {
		int answer = 0;
		cit = citations;
		len = citations.length;
		int max = 0;
		for (int i = 0; i < len; i++) {
			max = Math.max(citations[i], max);
		}
		for (int i = 0; i <= max; i++) {
			if (hIndex(i)) {
				answer = Math.max(i, answer);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
	}
}
