import java.util.Scanner;

public class pgdfdafad {
//���̰� n�̰�, ���ڼ��ڼ��ڼ�....�� ���� ������ �����ϴ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.
//������� n�� 4�̸� ���ڼ����� �����ϰ� 3�̶�� ���ڼ��� �����ϸ� �˴ϴ�.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));
	}
	
	 public static String solution(int n) {
	      String answer = "";
	      String s = "";
	      for (int i = 0; i < n; i++) {
	    	  s += i%2==0 ? "��" : "��";		      
		}
	      answer = s.substring(0,n);
	      
	      return answer;
	  }

}
