package day19._12_exception;

// 230626 �� ������ ����� ������ 
public class _1_ExceptionEx {

	public static void main(String[] args) {
		/* num2�� ���� 0�̾ ���� ǥ�ô� �ȵ�
		 * ������, ���ܰ� �߻��ؼ� ���α׷��� �ߴ�(arithmetifException - RuntimeException�� �ڽ� Ŭ����)
		 * �ڵ������ ������ ǥ�õ��� ������ �ǵ�ġ �ʰ� ���α׷��� �ߴܵǴ� ����
		 * => RuntimeException(���� ����)
		 */
		int num1 = 1, num2 = 0;
		
		System.out.println(num1/num2);
	}

}

class A implements Cloneable {
	/* clone �޼ҵ带 �������̵� �ϱ� ���ؼ� Object Ŭ������ clone�� ��ȯ�ϸ�
	 * CloneNotSupportedException �� �߻��� �� �ִ�.
	 * CloneNotSupportedException�� RuntimeExceptionŬ������ �ڽ� Ŭ������ �ƴϴ�
	 * => �ݵ�� ����ó���� �ؾ���
	 * */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

// RuntimeException : ����ó�� ���ص� �������� �ȶ��
// 				�� ��, 
// ��ǥ���� RuntimeException Ŭ������ �ڽ� Ŭ������
// - �����ϸ� ����ϴ°� ����
// - ��? �ڵ������ ������ ǥ�� �ȵǱ� ������ ����ó�� ���ϸ� ���α׷��� �Ҿ���.
//		 - NullPointerException
//		 - ArrayIndexOutOfBoundsException
//		 - ClassCastException
//		 = ArithmeticExceptopn
