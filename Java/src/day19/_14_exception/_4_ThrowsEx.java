package day19._14_exception;

public class _4_ThrowsEx {

	public static void main(String[] args) {
		int num1 = 1, num2 = 0;
		int res;
		int arr[] = {1, 3, 5};
		
		//res = mod2(num1, num2); 
		// throw RuntimeException�� �ڵ������ ������ �߻����� ����(�����δ� �����߻��� �� ������)
		// throw ArithmeticException => ok

		
		res = mod1(num1, num2); //���ܵ� ó���ϰ�, ���� ����
		try {
			arr = null;
			printArray(arr); // �޼ҵ� �����Ҷ�, arr == null�̸� �ݵ�� ���� ó��
		//	res = mod2(num1, num2); // ���� ó������(���ܹ߻��� catch�� �ٷ� �̵��ϱ� ����)
			System.out.println(res);
		} catch (Exception e) {
			//System.out.println("Exception : / by zero");
			System.out.println(e.getMessage());
			e.printStackTrace(); // ���α׷��� �ߴܵȰ� �ƴϰ�, ���ܰ� �߻��� ��ġ�� �˷��ذͻ�
		}
		System.out.println("EXIT! �����ƴ�");

		
	}
	// mod1 : try-catch�� �̿��Ͽ� ���ܸ� ���� ó��
	public static int mod1(int num1, int num2) {
		try{
			int res = num1 % num2;
			return res;
			
		}catch(Exception e) {
			System.out.println("Exception : / by zero");
			
			return 0;
		}
	}
	
	// mop2 : throws�� �̿��Ͽ� ���� ó���� �̷�
	public static int mod2(int num1, int num2) throws Exception {
		return num1 % num2;
	}
	
	// 3. throw ����
	public static void printArray(int arr[]) throws Exception {
		if (arr == null) {
			throw new Exception("Array is null."); 
			// throw�� ���ܸ� �߻���Ű�� ��. ���� ���ܰ� ����
			// Runtime�� �ƴ�.
			// throw - throws�� ���� �ٴ�
		}
		for(int tmp : arr) {
			System.out.println(tmp);
		}
	}
}
