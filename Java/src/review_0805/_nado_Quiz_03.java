package review_0805;

public class _nado_Quiz_03 {

	public static void main(String[] args) {
		/* 3. �ֹε�Ϲ�ȣ���� ������� �� ���������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�
		 * (������)
		 * "901231-1234567"�� ��� 901231-1 ���� ���
		 * "030708-4567890"�� ��� 030708-4 ���� ���
		 */
		String id = "901231-1234567";
		
		System.out.print(id.substring(0, 8));
		for(int i = 0; i < id.length() - 8;i++) {
			System.out.print("*");	
		}
		System.out.println();
		
		id = "030708-4567890";

		System.out.print(id.substring(0, 8));
		for(int i = 0; i < id.length() - 8;i++) {
			System.out.print("*");	
		}
		System.out.println();
		
		id = "940418-2465710";
		System.out.println(id.substring(0, id.indexOf("-")+2));
	}

}
