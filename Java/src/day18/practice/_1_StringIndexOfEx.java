package day18.practice;

public class _1_StringIndexOfEx {

	public static void main(String[] args) {
		// 1. Hello world ���� l�� � �ִ��� Ȯ���ϴ� �ڵ带 �ۼ��ϼ���.
		// int index = str.indexOf("wo", 7);// 5�������� �����Ͽ� wo ã�� Ȱ��
		
		String str = "Hello world!";
		int count = 0; // �� ������ ������ ����
		String search = "l"; // ã�� �ܾ� ��������
		int index = -1;
		
		// ��� 1�� �̻� �ݺ���.
		// �ݺ� : ã���� �ݺ� / ��ã���� ����
		do {
			index = str.indexOf(search, ++index);
			if(index != -1) {
				count++;
			}
		} while(index != -1);
		System.out.println(str + " : " + search + " : " + count);

		//3. �ݺ�
			// 1. Hello world���� l�� ��ġ�� ã�� => lo world => o world
			// => d���� l�� ��ġ�� ã��
		
			// 2. ã������ ������ ����
		// 4. ������ ���
	
	}
}
// �õ�2
//		for(int j = 0; j < str.length(); j++){
//			index = str.indexOf("l", j);
//			count++;
//			}
//			System.out.println(count);

// �õ�1
// boolean result = str.contains("l");

//		for(int i = 0; i < str.length(); i++) {
//				if(result = str.contains("l")) {
//					count++;
//				}
//		}
//		System.out.println(count); // ���ڿ� ����(11)��ŭ �ݺ��ؼ� 11�� ���Դٴ°� ������... 
//								   //3�� ��� ������ ����...
//		