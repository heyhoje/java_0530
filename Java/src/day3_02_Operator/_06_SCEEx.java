package day3_02_Operator;

public class _06_SCEEx {
	
	public static void main(String[] args) {
		String str = "abc";//null
		System.out.println("Is " + str + " equal to abc? " + (str != null && str.equals("abc")));
		
		String str = null;
		//str�� null�̱� ������ str.xx���� �Ǿ� �ִ� ��� ������ ������ �߻�
		//�׷��� && ������ �տ��� null üũ�ϴ� �ڵ尡 ���� �ֱ� ������ 
		//null �� ��쿡 �պκ��� ������ �Ǽ� �޺κ��� ������ �Ǵ� �ڵ带 �������� �ʾƼ� ������ �Ѿ(SCE: �ܶ�ȸ����)
		System.out.println("Is " + str + " equal to abc? " + (str != null && str.equals("abc")));// ��ǻ�Ͱ� ���� �ʴ�(�ִ�) && ��ǻ�� ������ �Ѷ�?
		// �Ʒ� �ڵ�� �� �ڵ忡�� ������ ������ �ڵ��, ������ �Ǵ� �ڵ带 ���� �����ϱ� ������ ����(����)�� �߻�
		System.out.println("Is " + str + " equal to abc? " + (str.equals("abc") && str != null));// ��ǻ�Ͱ� ���µ�, && ��ǻ�� ������ �Ѷ�??
	}

}
