import java.util.*;
class Cell{
	int val;
	boolean merge;
	public Cell(int val, boolean merge) {
		this.val = val;
		this.merge = merge;
	}
}
class Main {
	static int[][] board;
	static int n;
	static void move() {
		for(int j = 0; j < n; j++) { // �������� ��� ���� ���Ͽ�
			// ���հ���
			Deque<Cell> dq = new LinkedList<>(); // ���հ� ���ġ�� ���� Deque �ڷᱸ�� ���� ( ������� ���� ��� ����, ����� Queue )
			for(int i = n - 1; i >= 0; i--) { // �������� �� �Ʒ� ����� �Ųٷ� �ö�. ( �Ʒ� �̵� �� �������� ���� )
				if(board[i][j] == 0) continue; // 0�̸� �����ϰ� ���� ĭ Ȯ��
				if(dq.size() > 0) { // ����� 1���� ũ�ٸ� �߰����� Ȯ��
					Cell lastCell = dq.peekLast(); // ���� �������� Deque�� �� Cell
					if(lastCell.val == board[i][j] && lastCell.merge == false) { // ���� ���� ���� �������� ���� Cell�̶�� ����
						dq.pollLast(); // ���� ( ���� )
						dq.addLast(new Cell(board[i][j] * 2, true)); // �� ���� ���������Ƿ� ���� 2��, merge�� true�� �־���.
						continue;
					}
				}
				
				dq.addLast(new Cell(board[i][j], false)); // �������� ���� ���̹Ƿ� merge�� false
			}
//			// ���� dq ���
//			System.out.print(j+" :");
//			for(Cell cell : dq) System.out.print(cell.val+" ");
//			System.out.println();
			
			// ���ġ����
			int i = n - 1; // ���� ������ ĭ ���� ä��� ����
			while(i >= 0) { // ���ġ ���� ���� ĭ�� 0���� ����� ����
				// ���� ������ ��� �� �� �ٷ� Ŭ����
				board[i--][j] = dq.size() > 0 ? dq.pollFirst().val : 0; // dq�� �����ִ� �� �ִٸ� �� �� Cell�� ����, �ƴϸ� 0. i�� 1 ����.
			}
		}		
	}
	
	static void Print() {
		System.out.println("\n\n=====================");
		for(int[] arr : board) { // ���
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = sc.nextInt();
		board = new int[n][n];
		for(int i = 0; i < n * n; i++) {
			board[i/n][i%n] = sc.nextInt(); // �Է�����
		}
		for(int i = 0; i < k; i++) { // �Ʒ��� k�� �̵�
			Print();
			move();
		}
		Print();
	}
}