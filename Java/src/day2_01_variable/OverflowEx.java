package day2_01_variable;

public class OverflowEx {

	public static void main(String[] args) {
		byte num = 127;
		++num;//num�� 1�� ����
		System.out.println(num);// �����÷ο찡 �߻�
		
		num = -128;
		--num;
		System.out.println(num);// ����÷ο찡 �߻�
	}

}
