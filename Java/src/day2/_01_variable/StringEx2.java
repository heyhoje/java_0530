package day2._01_variable;

public class StringEx2 {

	public static void main(String[] args) {
		String str = "";
		char op = '+';
		int num1 = 1, num2 = 2;
		//num1 + op�� ���� ����� �Ǽ� +�� �ش��ϴ� 43�� 1�� �������� 44�� ��
		//44�� 2�� �������� 46, 46�� ���ڿ� = �� �������� ���ڿ� 46=  
		str = num1 + op + num2 + "=" + (num1+num2);
		System.out.println(str);
		
		//�� ���ڿ��� num1�� ���Ǽ� ���ڿ� 1
		//���ڿ� 1�� + �� �������� ���ڿ� 1+
		//���ڿ� 1+�� 2�� �������� ���ڿ� 1+2
		str = "" + num1 + op + num2 + "=" + (num1+num2);
		System.out.println(str);
	}

}
