package day3_02_Operator;

public class _08_ArithmeticEx {
	public static void main(String[] args) {
		//
		/* byte + ������ char + ������ ����� int���� byte�� char�� �ٷ� ������ �� ����
		 * �ڷ��� ��ȯ�� �̿��ؼ� �����ؾ� �Ѵ�.
		 */
		byte num1 = 3;// num1�� 3�̶�� ���� �����ϰ�
		//num1 = num1 + 5;// ������ ���� int �� �ǹ����� ���� byte�� ������ �� ����. 
		num1 = (byte)(num1 + 5);
		
		char ch = 'A';
		System.out.println(ch);
		ch = (char)(ch + 1); //�������� int�� ��.
		System.out.println(ch);
		
		int num2 = 3;
		num2 = (int)(num2 + 4.0); // ���� + �Ǽ� = '�Ǽ�'�� ��ȯ��
		System.out.println(num2); // ��� �����ϳĿ� ���� ����ȯ�� �ʿ��� ����, ���ʿ��� ���� �ִ�. 
	}

}
