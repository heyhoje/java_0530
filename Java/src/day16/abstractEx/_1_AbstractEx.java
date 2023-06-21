package day16.abstractEx;

public class _1_AbstractEx {

	public static void main(String[] args) {
		// 추상 클래스를 이용하여 객체를 만들 수 없다. 
		// A a = new A(); // cannot instantiate the type A
		
		/* 직접 만들 수는 없지만, 
		 * 구현되지 않은 추상메소드를 객체 생성후에 오버라이딩을 해주면 가능*/
		A a = new A() {
			public void test() { // test 메소드를 오버라이딩???
				System.out.println("class A Test.");
			}
		}; // 이런 형태를 많이 볼 수 있을 거라고?? 왜?죠???
		a.test();
		
		A a2 = new A() {
			public void test() { // test 메소드를 오버라이딩???
				System.out.println("class A Test.");
			}
		}; // 정식 클래스가 아니기 때문에 다시 쓰고싶으면 재사용이 안되서 복붙해야함
		a2.test();
		
		// ChildA1도 추상 클래스이기 ??문에 ChildA1으로 객체를 생성할 수 없다.
		// ChildA1 ca1 = new ChildA1(); // 기본생성자 생성 안됨
		
		/* 추상 클래스를 상속받은 ChildA2는 일반 클래스이기 때문에 객체를 생성할 수 있다
		 * 모든 기능이 구현되어 있다 => 객체 생성이 가능
		 * 모든 기능이 구현되어 있지 않다 => 추상 메소드가 있다 => 객체 생성이 불가능	 */
		ChildA2 ca2 = new ChildA2(); // 부모로부터 상속받은 메소드를 오버라이딩 해서? 에러 안뜸
		ca2.test();
		
		// 다형성 : 하나의 객체에 여러 타입이 올 수 있는 것
		a = ca2; // 업캐스팅 ㄷㄷㄷ 부모 A a = 
		// 업캐스팅에 의해 ca2객체를 a가 다룰 수 있다.
		a.test(); // 기능 호출 가능
		
	}

}

/* 추상 클래스는 추상 메소드를 가지고 있고
 * 추상 메소드가 있는 클래스에 abstract를 붙이지 않으면 에러 발생
 */
abstract class A{
	public abstract void test(); // 구현부({}add body)가 없음. 추상 메소드.
	// 메소드에 final이 붙으면 상속할 수 없다???
	public final void test2() {
		System.out.println("Test2");		
	}
}

/* 추상 클래스 상속 받는 방법 1
 * 추상 클래스 A를 상속받은 자식 클래스는 추상클래스로 만들어야함 */
abstract class ChildA1 extends A{ 
	// A상속받았으면 abstract void test() 를 가지고 있음
	// class 앞에 abstract 붙여야함
	
	/* final 메소드를 오버라이딩 할 수 없음
	public void test2() {
		// final 예약어를 지워주세요ㅠ 라고 에러뜸
	}
	*/
}

/* 추상 클래스 상속 받는 방법 2 (두번째가 중요)
 * 부모 클래스의 추상 메소드를 오버라이딩해서 재정의 해줌
 * - 두번째 방법을 많이 쓴다
 */
class ChildA2 extends A{

	@Override
	public void test() { // test라는 추상메소드를 오버라이딩 함..??	
		System.out.println("테스트");
	}
	
	
}
