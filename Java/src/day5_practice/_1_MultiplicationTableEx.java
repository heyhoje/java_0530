package day5_practice;

public class _1_MultiplicationTableEx {

	public static void main(String[] args) {
		// 1. ������ 2���� ����ϴ� �ڵ带 �ۼ��ϼ���.
		/*�ݺ�Ƚ�� : i�� 1���� 9���� 1�� ����
		 * ��Ģ�� : 2 * i = 2*i�� ��� 
		 */
		
		int max = 9;
		int i = 1;
		while (i <= max) {
			System.out.println(2 + " * " + i + " = " + 2*i); //�;� ��ȣ�ϳ� �ߴٰ� ���´ٰ�????// �ƴ� ��ȣ������ �ƴϾ��ٰ�? �Ʊ�� 2*1�� ���ѷ��� �ɷ�����!!!!!
			++i;
		}
	}

}
