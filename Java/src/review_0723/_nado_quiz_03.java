package review_0723;

public class _nado_quiz_03 {

	public static void main(String[] args) {
		// �ֹε�Ϲ�ȣ���� <������� �� ����>������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�
		String id = "030708-4567890";
		System.out.println(id.substring(0, 8));// ���� �ε������� �� �ε��� ��������
		id = "901231-1234567";
		System.out.println(id.substring(0, id.indexOf("-")+2));// indexOf ��ġ�� ã��
	}
}
