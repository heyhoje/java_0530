package review_0723;

public class _nado_quiz_06 {

	public static void main(String[] args) {
		// �־��� �ڵ��� getHiddenData(...) �޼ҵ带 �ϼ��Ͻÿ�
		String name = "���ڵ�"; // 0 1 2
		String id = "990130-1234567"; // 0 1 2 ... 13  
		String phone = "010-1234-5678"; // 0 1 2 ... 12
		
		System.out.println("�̸� : " + getHiddenData(name, 1)); // ��������, ����� ����
		System.out.println("�ֹι�ȣ : " + getHiddenData(id, 8));
		System.out.println("��ȭ��ȣ : " + getHiddenData(phone, 9));
		
	
	/** ��� : ���° �ε��� ���� �߶��� 
	 * �Ű����� : �������, �ε�����ȣ
	 * ����Ÿ�� : *ó���� ��ȣ�� �������� => String
	 * �޼ҵ� : getHiddenData
	 */
	private static String getHiddenData(String data, int index) {
		String hiddenData = data.substring(0, index); // ���ڵ� -> ��**

		for(int i = 0; i < data.length() - index; i++) {
			hiddenData += "*";
		}
		
		return hiddenData;
	}
	
//	String hiddenData = data + "*" * (index+1);
//	 for(int i = 0; i < data.length() - index; i++)

}
