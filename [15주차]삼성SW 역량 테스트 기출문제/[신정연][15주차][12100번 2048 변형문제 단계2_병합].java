package week15;

import week15.CellCheck;
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

public class SamsungSWTest3 {
	static int[][] rst;
	static int N;

	public static void move(String inst) { // ���� �����ϰ� ���� ������.
		int row = 0, col = 0, rowPlus = 0, colPlus = 0;
		switch (inst) {
		case ("U"):
			rowPlus = 1;
			break;
		case ("D"):
			row = N - 1;
			rowPlus = -1;
			break;
		case ("R"):
			col = N - 1;
			colPlus = -1;
			break;
		case ("L"):
			colPlus = 1;
			break;
		}

		for (int a = 0; a < N; a++) {
			int i = row + (rowPlus == 0 ? a : 0);
			int j = col + (colPlus == 0 ? a : 0);
			Deque<CellCheck> dq = new LinkedList<>();
			for (; 0 <= i && 0 <= j && i < N && j < N; i += rowPlus, j += colPlus) {

				if (rst[i][j] != 0) {
					if (dq.size() > 0) {
						CellCheck cc = dq.peekLast();
						if (cc.value == rst[i][j] && cc.merged == false) {
							dq.pollLast();
							dq.addLast(new CellCheck(cc.value * 2, true));
							continue;
						}
					}
					dq.addLast(new CellCheck(rst[i][j], false));
				}
			}
			while (dq.size() < N)
				dq.addLast(new CellCheck(0, false));

			i = row + (rowPlus == 0 ? a : 0);
			j = col + (colPlus == 0 ? a : 0);

			for (; 0 <= i && 0 <= j && i < N && j < N; i += rowPlus, j += colPlus) {
				rst[i][j] = dq.pollFirst().value;
			}
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
			move(inst[i]);
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
