package day3_02_Operator;

public class _07_ConditionalEx {

	public static void main(String[] args) {
		//���̰� 20�� �̻��̸� ����adult, �ƴϸ� �̼�����minor �� ����ϴ� �ڵ带 �ۼ��ϼ���.
		int age = 30;
		String str;
		
		str = age > 20 ? "adult" : "minor";
		System.out.println(age + " years old is a " + str);
	}

}
