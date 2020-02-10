package week15;

import java.util.*;

/*
 * ����_Samsung_2048(Easy) ���� 2�ܰ�
 * 4 2
 * 2 0 2 0
 * 2 2 4 4
 * 2 2 4 4
 * 2 4 8 8
 * R D		(R L U D)
 */
class CellCheck {
	int value;
	boolean merged;

	CellCheck(int value, boolean merged) {
		this.value = value;
		this.merged = merged;
	}
}

public class SamsungSWTest2 {
	static int[][] rst;
	static int N;

	public static void moveUD(String inst) {  // ���� �����ϰ� ���� ������.
		Deque<CellCheck> dq = new LinkedList<>();
		// U : 0 -> N
		int js = 0;
		int je = N;
		String direction = "zton";
		
		if(inst.equals("D")) {  // D : N -> 0.
			js = N - 1;
			je = 0;
			direction = "ntoz";
		}
		
		switch (direction) {
		case "ntoz":
			for (int i = 0; i < N; i++) {
				for (int j = js; j >= je; j--) {  // N -> 0
					if (rst[j][i] == 0)
						continue;
					if (!dq.isEmpty()) {
						if (dq.peekLast().value == rst[j][i] && !dq.peekLast().merged) {
							dq.pollLast();
							dq.offerLast(new CellCheck(rst[j][i] * 2, true));
						} else {
							dq.offerLast(new CellCheck(rst[j][i], false));
						}
					} else {
						dq.offerLast(new CellCheck(rst[j][i], false));
					}
				}
				for (int j = js; j >= je; j--) {
					if (!dq.isEmpty()) {
						rst[j][i] = dq.pollFirst().value;
					} else {
						rst[j][i] = 0;
					}
				}
			}
			break;

		case "zton":
			for (int i = 0; i < N; i++) {
				for (int j = js; j < je; j++) {  // 0 -> N
					if (rst[j][i] == 0)
						continue;
					if (!dq.isEmpty()) {
						if (dq.peekLast().value == rst[j][i] && !dq.peekLast().merged) {
							dq.pollLast();
							dq.offerLast(new CellCheck(rst[j][i] * 2, true));
						} else {
							dq.offerLast(new CellCheck(rst[j][i], false));
						}
					} else {
						dq.offerLast(new CellCheck(rst[j][i], false));
					}
				}
				for (int j = js; j < je; j++) {
					if (!dq.isEmpty()) {
						rst[j][i] = dq.pollFirst().value;
					} else {
						rst[j][i] = 0;
					}
				}
			}
			break;
		}
	}

	public static void moveRL(String inst) {  // ���� �����ϰ� ���� ������.
		Deque<CellCheck> dq = new LinkedList<>();
		// L : 0 -> N
		int js = 0;
		int je = N;
		String direction = "zton";
		
		if(inst.equals("R")) {  // R : N -> 0
			js = (N - 1);
			je = 0;
			direction = "ntoz";
		}
		
		switch (direction) {
		case "ntoz":
			for (int i = 0; i < N; i++) {
				for (int j = js; j >= je; j--) {
					if (rst[i][j] == 0)
						continue;
					if (!dq.isEmpty()) {
						if (dq.peekLast().value == rst[i][j] && !dq.peekLast().merged) {
							dq.pollLast();
							dq.offerLast(new CellCheck(rst[i][j] * 2, true));
						} else {
							dq.offerLast(new CellCheck(rst[i][j], false));
						}
					} else {
						dq.offerLast(new CellCheck(rst[i][j], false));
					}
				}
				for (int j = js; j >= je; j--) {
					if (!dq.isEmpty()) {
						rst[i][j] = dq.pollFirst().value;
					} else {
						rst[i][j] = 0;
					}
				}
			}
			break;

		case "zton":
			for (int i = 0; i < N; i++) {
				for (int j = js; j < je; j++) {
					if (rst[i][j] == 0)
						continue;
					if (!dq.isEmpty()) {
						if (dq.peekLast().value == rst[i][j] && !dq.peekLast().merged) {
							dq.pollLast();
							dq.offerLast(new CellCheck(rst[i][j] * 2, true));
						} else {
							dq.offerLast(new CellCheck(rst[i][j], false));
						}
					} else {
						dq.offerLast(new CellCheck(rst[i][j], false));
					}
				}
				for (int j = js; j < je; j++) {
					if (!dq.isEmpty()) {
						rst[i][j] = dq.pollFirst().value;
					} else {
						rst[i][j] = 0;
					}
				}
			}
			break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // �迭 ũ��
		int M = sc.nextInt(); // ��ɾ� Ƚ��

		// �ʱ���� �Է�
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// ��ɾ� �Է�
		String[] inst = new String[M];
		for (int i = 0; i < M; i++) {
			inst[i] = sc.next();
		}

		rst = arr; // ��� ���� �迭.

		// ��ɾ� ����
		for (int i = 0; i < inst.length; i++) {
			if (inst[i].equals("R") || inst[i].equals("L")) {
				moveRL(inst[i]);
			} else {
				moveUD(inst[i]);
			}
		}

		// ��� ���
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(rst[i][j] + " ");
			}
			System.out.println();
		}
	}
}
