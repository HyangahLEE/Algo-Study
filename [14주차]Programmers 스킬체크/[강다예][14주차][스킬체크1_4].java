import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pg80007 {
	/*
	 * ���ڿ� s�� ���̰� 4 Ȥ�� 6�̰�, ���ڷθ� �������ִ��� Ȯ�����ִ� �Լ�, solution�� �ϼ��ϼ���. ���� ��� s�� a234�̸�
	 * False�� �����ϰ� 1234��� True�� �����ϸ� �˴ϴ�.
	 * 
	 * s�� ���� 1 �̻�, ���� 8 ������ ���ڿ��Դϴ�. �Է� a234 ��� false �Է� 1234 ��� true
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(solution(s));

	}

	public static boolean solution(String s) {
		boolean answer = true;
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(s);

		if ((s.length() == 4 || s.length() == 6) && m.find()) {
			return answer;
		}
		return false;

	}
	
	

}
