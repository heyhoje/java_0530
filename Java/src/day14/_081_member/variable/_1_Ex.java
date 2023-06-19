package day14._081_member.variable;

// 에러뜨고 부터 필기 놓침
// 클래스 멤버변수랑 객체 멤버변수도 모르겠음

public class _1_Ex {

	public static void main(String[] args) {
		// 초기화 방법 잘 알아두기
		
		/* 멤버변수 초기화 예제
		 * 객체 멤버변수 num 초기화 순서
		 * 1. 기본값 : int의 기본값이 0으로 초기화
		 * 2. 명시적 초기화 : 멤버변수 선언과 동시에 초기화 되는 값 => 1
		 * 3. 초기화 블럭 : {} 로 된 초기화 블럭에서 초기화 => 2
		 * 4. 생성자 : 생성자에서 초기화 => 3 / 마지막!! 
		 */
		
		System.out.println(TestA.num2);
		TestA a = new TestA(TestA.num2);
	}

}

class TestA {
	int num = 1; // 기본값 0 => 명시적 초기화
	// 초기화 블록
	{
		num = 2;
	}
	public TestA() { // 생성자에서 초기화
		num = 3;
	}
	
	static int num2 = 1;
	//정적 초기화 블록
	static {
		num2 = 2;
	}
	
}	
