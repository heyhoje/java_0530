package day3_02_Operator;

public class _05_LogicalEx {

	public static void main(String[] args) {
		// && and�����ڴ� �Ѵ� ���̾����
		int score = 95;//75, 85, 95
		//������ 80�� �̻��̰�, 90�� �̸��ΰ�? << ������ �ڵ�� ����°� �����. ���� �ִ��� ���� �˰��ִ� �����ڷ�, �ܰ躰�� Ǯ��� �����ʿ�
		//score�� 80���� ũ�ų� �۴� && score�� 90���� �۴�.
		System.out.println(score + "���� B�����ΰ�? " + (score >= 80 && score < 90));
		
		// ! not������
		// 20�� �̻��̸� ����
		int age = 21;
		boolean isAdult = age >= 20;
		//age���� �̼������ΰ�? -> ������ �ƴ�
		System.out.println(age + "���� �̼������ΰ�? : " + !isAdult);// is not adult.
		
		// || or�����ڴ� �ϳ��� ���̾ ��
		//�ֹε������ �ְ�, ������������ ����.
		boolean hasIdCard = true;//true, false
		boolean hasDriversLicense = false;
		//������ �� �� ������?(�ֹε������ �ְų� ������������ ������ �� �� ����)
		System.out.println("���ͽ����� �� �� �ִ°�? : " + (hasIdCard || hasDriversLicense));
		
	}

}
