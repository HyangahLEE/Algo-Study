package inputoutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
�Լ� solution�� ���� n�� �Ű������� �Է¹޽��ϴ�. n�� �� �ڸ����� ū�ͺ��� ���� ������ ������ ���ο� ������ �������ּ���. ������� n�� 118372�� 873211�� �����ϸ� �˴ϴ�.
n�� 1�̻� 8000000000 ������ �ڿ����Դϴ�.

n			return
118372	873211
*/
public class pg {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();

		String[] arr = n.split("");
		int[] num = new int[n.length()];
		
		for (int i = 0; i < arr.length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		
		Arrays.sort(num);
		
		for (int i = num.length-1; i >= 0; i--) {
			System.out.print(num[i]);
		}

	}

}
