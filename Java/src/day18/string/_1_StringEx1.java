package day18.string;

// String�� ���� ��������, �ܿ��ʿ�� ���� �ʿ��Ҷ����� ã�Ƽ� ���� ��.

public class _1_StringEx1 {

	public static void main(String[] args) {
		/* ���ڿ� ���� �޼ҵ� */
		// 1. indexOf : ���� ���ڿ����� �˻� ����||���ڿ��� (���ʺ��� �˻��ؼ�) 'ó��'���� ������ ��ġ�� ��ȯ
		// 1.2 lastIndexOf : "" (�����ʺ��� �˻��ؼ�) ó������ ������ ��ġ�� ��ȯ
		String str = "Hello world";
		
		// ���� ������� �����ε�������
		// str���� 7�������� wo�� �ִ��� Ȯ��. orld���� wo�� �ִ��� Ȯ�� => ���� => -1
		int index = str.indexOf("wo", 7);// 5�������� �����Ͽ� wo ã��
		System.out.println(str + "���� 7�������� " + "wo" + "�� �ֳ���? " + index); // ���� => -1
		
		index = str.indexOf("wo");
		System.out.println(str + "���� 0�������� " + "wo" + "�� �ֳ���? " + index); // 6������ ����
		
		index = str.indexOf("o");
		System.out.println(str + "���� 0�������� " + "o" + "�� �ֳ���? " + index); // ó�� ������ 4������ ���
		
		// 2. ����� ��� contains : ���� ���ڿ����� �˻� ����||���ڿ��� �ִ��� ������ �˷��� => T/F
		boolean result = str.contains("o");
		System.out.println(str + "���� 0�������� " + "wo" + "�� �ֳ���? " + result); // ó�� ������ 4������ ���

		// 3. ���ڿ�.length : ���� ����ִ� ũ�⸦ �˷���
		System.out.println(str + "�� ���̴�? " + str.length());
		
		// 4. replace : Ư�� ����||���ڿ��� �ٲ� �� ���. 
		// 	  replaceAll : '����ǥ���� - ���ڿ��� Ư�� ������ �ִ��� ������ 
		// 				ex)ID, e-mail'�� �´� ��� ����||���ڿ��� ����
		String str2 = str.replace(" ", ",");
		System.out.println(str2);
		
		// 5. substring : �κй��ڿ� ����
		String str3 = str.substring(6); // 6�������� ������
		System.out.println(str + "���� 6�������� ������ �κ� ���ڿ� : " + str3);
		
		// 1.2 lastIndexOf : "" (�����ʺ��� �˻��ؼ�) ó������ ������ ��ġ�� ��ȯ
		index = str.lastIndexOf("o", 7);// 5�������� �����Ͽ� o ã��
		System.out.println(str + "���� 0�������� " + "o" + "�� �����ʿ������� ������� �ֳ���? " + index);
		
		// 6. toLowerCase : �ҹ��ڷ�
		System.out.println(str + " : �ҹ��� : " + str.toLowerCase());
		// 6. toUpperCase : �빮�ڷ�
		System.out.println(str + " : �ҹ��� : " + str.toUpperCase());
		
		System.out.println("\n\t\t-------------------");
		String str4 = "\n\t\tabc\t\tdef\t\n";
		
		// 7. .trim() : ���۾�(a) �� ����/��������(f) �� ������ ������(���̿� �ִ� ������ ó�� ����)
		System.out.println(str4.trim());
		System.out.println(str4.replace(" ",""));
		
		// 8. split : �����ڸ� �������� ���ڿ��� �����ؼ� ������� �迭�� ����
		String str5 = "���,��,����";
		String fruits[] = str5.split(","); // �޸��� �������� �յ� ���� ����, ������� �迭�� ����
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
		
	}

}
