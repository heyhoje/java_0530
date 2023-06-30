package day19._14_exception;

public class _3_TryCatchEx {

	public static void main(String[] args) {
		/* catch�� �ּ� 1���� �ʿ�
		 * � ���ܰ� �߻����� �𸦶����� Exception�� �̿�
		 */
		
		try{
			// ���ܰ� �߻��� �� �ִ� �ڵ�
			System.out.println(1 / 0);
		}
		catch(ArithmeticException e) {
			System.out.println("����ó���� �մϴ�.");
		}
		// ù��° catch�� ���� ArithmeticException Ŭ������ ��ü�� Exception���� ��ȯ(��ĳ����) �������� Ȯ���ϰ�
		// �����ϸ� ó��
		catch(Exception e) { // ���ȳ���, ����ó�� ����� Exception
			// (Ŭ������ ��ü��)
			// ����ó��
			System.out.println("����ó���� �մϴ�.");
		}
		// ���� Exception���� ��� ���ܰ� �ɸ��� ������ �Ʒ��ִ� catch�� ������ ���� ����
		/* catch(ArithmeticException e) {
			System.out.println("����ó���� �մϴ�.");
		}*/
		System.out.println("���α׷��� �����մϴ�");
		
	}

}

/* * Try-catch��
 * - ���� catch�� ���� �پ��� ����ó���� �� �� ����
 * - catch�� ������� �����ϱ� ������ �θ� ����(Exception)�� �ڽ� ����(ArithmeticException ��)���� ���� ���� �ȵ�
 *   �� �����ϴ� �Ǽ�
 *   
 *   try {
 *   // ���ܰ� �߻��� �� �ִ� �ڵ�
 *   }catch(���� Ŭ������1 ��ü��) {
 *   	// ����ó��
 *   }catch(���� Ŭ������2 ��ü��) {
 *   	// ����ó��
 *   }
*/
