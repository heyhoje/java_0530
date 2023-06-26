package day17._10_interfaceEx;

// RunInterface를 퍼블릭으로 만들고 싶음!
// => 파일명과 클래스명이 같아야함(그래서 새 클래스로 분리한거였다)

public interface RunInterface{
	/*public final static*/ int NUM = 10; // 클래스 상수 => 클래스를 이용하여 호출한다
	// final 변수 => 상수 = 상수는 항상 값을 넣어줘야함. 일반적으로 대문자로 씀 
	// 멤버변수 : 파란색 / 굵은색 : final / 기울임 : static
	
	public abstract void run(); // = 기능구현이 안된 추상메소드!
	//(public abstract) void run
	
	default void stop() { // void stop(); 추상메소드 > 디폴트 메소드로 변경
		System.out.println("program stop");
	}
	/* 기존에 만들어진 인터페이스에 새로운 메소드를 추가하게 되면 
	 * 이전에 해당 인터페이스를 사용하던 구현 클래스들에 에러가 발생
	 * => 인터페이스에 뒤늦게 기능이 추가되어도 에러가 발생하지 않도록 default키워드, 디폴트 메소드 이용
	 */
}

