package day5.homework;

public class _equals {

	public static void main(String[] args) {
		String str1 = new String ("abc");
		String str2 = "abc";
		System.out.println(str1 == str2); // false : �ּҰ��� ���߱� ������ false
		// ��ü�� == �� ���ϴ� ���� �ּҰ�
		
		System.out.println(str1.equals(str2)); // true : equals ��� �޼ҵ�� �ּҰ� 1,2�� �ƴ� ������ "abc" �� ��
		
	}

}
