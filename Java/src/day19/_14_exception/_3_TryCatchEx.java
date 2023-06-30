package day19._14_exception;

public class _3_TryCatchEx {

	public static void main(String[] args) {
		/* catch는 최소 1개는 필요
		 * 어떤 예외가 발생할지 모를때에는 Exception을 이용
		 */
		
		try{
			// 예외가 발생할 수 있는 코드
			System.out.println(1 / 0);
		}
		catch(ArithmeticException e) {
			System.out.println("예외처리를 합니다.");
		}
		// 첫번째 catch로 가서 ArithmeticException 클래스의 객체를 Exception으로 변환(업캐스팅) 가능한지 확인하고
		// 가능하면 처리
		catch(Exception e) { // 기억안나면, 예외처리 조상급 Exception
			// (클래스명 객체명)
			// 예외처리
			System.out.println("예외처리를 합니다.");
		}
		// 위에 Exception에서 모든 예외가 걸리기 때문에 아래있는 catch를 실행할 일이 없음
		/* catch(ArithmeticException e) {
			System.out.println("예외처리를 합니다.");
		}*/
		System.out.println("프로그램을 종료합니다");
		
	}

}

/* * Try-catch문
 * - 여러 catch를 통해 다양한 예외처리를 할 수 있음
 * - catch는 순서대로 동작하기 때문에 부모 예외(Exception)가 자식 예외(ArithmeticException 등)보다 위에 오면 안됨
 *   ㄴ 많이하는 실수
 *   
 *   try {
 *   // 예외가 발생할 수 있는 코드
 *   }catch(예외 클래스명1 객체명) {
 *   	// 예외처리
 *   }catch(예외 클래스명2 객체명) {
 *   	// 예외처리
 *   }
*/
