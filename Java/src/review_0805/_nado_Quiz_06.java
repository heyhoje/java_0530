package review_0805;

public class _nado_Quiz_06 {

	public static void main(String[] args) {
		String name = "���ڵ�"; // �̸�
		String id = "990130-1234567"; // �ֹε�Ϲ�ȣ
		String phone = "010-1234-5678"; // ��ȭ��ȣ
		
		System.out.println("�̸� : " + getHiddenData(name, 1)); // ��������, ����� ���� ��ġ
		System.out.println("�ֹε�Ϲ�ȣ : " + getHiddenData(id, 8) );
		System.out.println("��ȭ��ȣ : " + getHiddenData(phone, 9));
	}
	
	/** ��� : �ε����������� *�� ���������� ������ �޼ҵ�
	 * �Ű����� : String data, int index
	 * ����Ÿ�� : *ó���� �������� => String
	 * �޼ҵ�� : getHiddenData
	*/
	public static String getHiddenData(String data, int index) {
			String hiddenData = "";
			for(int i = 0; i < data.length() - index; i++) {
				hiddenData = data.substring(0, index);
				System.out.print("*");
//			 System.out.print("*");
//			 �̷��� �ϴϱ� *ǥ�� ������ ������.. �ֱ׷����?
		}
		return hiddenData;
		
	}

}
