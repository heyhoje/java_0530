package day14._082_switchEx;

public class _1_switchEx {

	public static void main(String[] args) {
		/*switch������ case�� ������ �����ϸ� 
		 * �ٸ� case���� ������ �� ���ٴ°� �����ִ� ����
		 */
		
		// �򰥸��� switch�� �ۿ��� ���� ������ �� �ϸ������
		// ���鼭 �ϰ� �ʹ� �ϸ� �� �����ؾ���
		
		int menu = 2;
		
		switch(menu) {
		case 1:
			String title = "����1";
			System.out.println(title);
			// break; // case���� break�� �������� �ʼ��� �ƴ�
					  // => break�� ���� ��� ���� case�� ���๮���� �̵�
		case 2:
			String title2 = "����2"; // title�� case 1�� �־ ������ �ȵ� 
			// case 2 ���� title�� ���� ���� �߻�
			// => title�� ���� ���ؼ��� case 1�� �ݵ�� ������ �ϴµ�, 
			// 	  menu�� 2���� case2�� �ٷ� ����� ���� case 1�� �ǳʶٰ�
			//    ���� ������ title�� ������� �ʾƼ� ���� �߻�
			
			// System.out.println(title);
			System.out.println(title2);
			break;
		case 3:
			break;
		}
	}

}
