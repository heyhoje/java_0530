package day19._14_exception;

public class _4_ThrowsEx {

	public static void main(String[] args) {
		int num1 = 1, num2 = 0;
		int res;
		int arr[] = {1, 3, 5};
		
		//res = mod2(num1, num2); 
		// throw RuntimeException은 코드상으로 에러가 발생하지 않음(실제로는 에러발생할 수 있지만)
		// throw ArithmeticException => ok

		
		res = mod1(num1, num2); //예외도 처리하고, 값도 나옴
		try {
			arr = null;
			printArray(arr); // 메소드 실행할때, arr == null이면 반드시 예외 처리
		//	res = mod2(num1, num2); // 예외 처리만함(예외발생시 catch로 바로 이동하기 때문)
			System.out.println(res);
		} catch (Exception e) {
			//System.out.println("Exception : / by zero");
			System.out.println(e.getMessage());
			e.printStackTrace(); // 프로그램이 중단된게 아니고, 예외가 발생한 위치를 알려준것뿐
		}
		System.out.println("EXIT! 강종아님");

		
	}
	// mod1 : try-catch를 이용하여 예외를 직접 처리
	public static int mod1(int num1, int num2) {
		try{
			int res = num1 % num2;
			return res;
			
		}catch(Exception e) {
			System.out.println("Exception : / by zero");
			
			return 0;
		}
	}
	
	// mop2 : throws를 이용하여 예외 처리를 미룸
	public static int mod2(int num1, int num2) throws Exception {
		return num1 % num2;
	}
	
	// 3. throw 예제
	public static void printArray(int arr[]) throws Exception {
		if (arr == null) {
			throw new Exception("Array is null."); 
			// throw는 예외를 발생시키는 애. 없던 예외가 생김
			// Runtime이 아님.
			// throw - throws는 같이 다님
		}
		for(int tmp : arr) {
			System.out.println(tmp);
		}
	}
}
