package day19._12_exception;

public class _2_NullPointerExceptionEx {

	public static void main(String[] args) {
		/* NullPointerException
		 * - ��ü�� null�� ���·� �޼ҵ�, ����� ȣ���ϴ� ��� �߻�
		 * */
		
		 String str = null;
		//String str = "abc";
//		System.out.println(str.substring(0));
		 test(str);
	}
	
	/* �޼ҵ带 ���� �� �Ű������� null üũ�� �ݵ�� �ϴ°� ��*/
	public static void test(String str) {
		System.out.println(str.substring(0));
	}

}
