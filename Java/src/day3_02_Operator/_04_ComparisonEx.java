package day3_02_Operator;

public class _04_ComparisonEx {

	public static void main(String[] args) {
		//��(����)������ - ���������� ���϶��� ��������.
		
		System.out.println("1 > 2 : " + (1 > 2)); // ���ϱ� > �񱳿����� ���� �켱����
		System.out.println("1 < 2 : " + (1 < 2));
		System.out.println("1 >= 2 : " + (1 >= 2));
		System.out.println("1 <= 2 : " + (1 <= 2));
		System.out.println("1 == 2 : " + (1 == 2));
		System.out.println("1 != 2 : " + (1 != 2));
		
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		
		/*str1�� str2�� ���ͷ� ���ڿ� abc�� ����(�ϴ� ��Ҹ� �˰� ����)�ϰ� �ֱ� ������ == �� �� ����������
		 * str3�� ���ͷ� ���ڿ��� �ƴϱ� ������ ==�� ���� �� ����
		 * �׷���, �Ϲ������� ���ڿ� ������ �ִ� ���, (������ ����) �� ������ ���ͷ��� ����ִ��� �ƴ����� �� �� ����
		 * �׷��� ���ڿ��� == �� != �� ������ �ʴ� ���� ����. 
		 */
		System.out.println("str1 == str2 : " + (str1 == str2));//
		System.out.println("str1 == str3 : " + (str1 == str3));//���ͷ� ���� ���ͷ� ���� �ƴ� ���� ��. false
		System.out.println("str2 == str3 : " + (str2 == str3));
		
		//���ڿ��� ������ ���� �������� �ַ� equals�� �̿��Ͽ� ������ �ٸ����� �Ǻ��Ѵ�.
		System.out.println("str1.equals(str2) : " + str1.equals(str2));
		System.out.println("str1.equals(str3) : " + str1.equals(str3));
		System.out.println("str2.equals(str3) : " + str2.equals(str3));//equals�� ���� 3���� ��� ����..... �ֳ�...�𸥴� 
		
		//������������ ���ų� ���� �ʴٸ� ���ϴ� ���
		//���������� ==�� !=�� ���� ��ǥ���� ���� null�� ���ؼ� ������� �Ⱥ������(��ü�� �ִ���?) Ȯ���� ���� ���
		System.out.println(str1 == null);// null�� ���Ҷ���
		System.out.println(str1 != null);
	}

}
