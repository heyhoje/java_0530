package day17._10_interfaceEx;

import day13.homework.controler.VocabularyNoteController;
import day15.practice.shop.controller.ShopManager;

// 깃헙 보고 내용 추가 및 이해 필요!!!!!!
// 230622 오전강의영상1

public class _1_InterfaceEx {

	public static void main(String[] args) {
		/* 인터페이스를 이용하여 객체를 생성할 수 없음 */ 
		// RunInterface run = new RunInterface(); 
		// 인터페이스로는 객체를 생성할 수 없다(기능 구현이 안된 '추상메소드'가 있기 때문)
		
		System.out.println(RunInterface.NUM);// 클래스 상수 = static 객체 생성없이 호출할 수 있다.
		// <- final static int NUM <- interface RunInterface
		// 인터페이스를 이용해서 객체를 생성할 수는 없지만, 상수는 가져다 쓸 수 있음?ㅇㅇ!

		System.out.println("----------");
		// 인터페이스를 구현한, 구현클래스(run클래스)는 객체를 생성할 수 있다. 
		Run run = new Run();
		run.run();
		run.load(); // 잘 실행됨
		
		System.out.println("---------------");
		// 인터페이스를 통해 객체를 관리할 수도 있음
		// = 구현클래스를 통해 생성한 객체를 RunInterface가 관리
		RunInterface runInterface = new Run(); // 형변환! 업캐스팅!!
		// 구현 클래스(Run) = 인터페이스 임플리먼트(기능 다 사용가능) + 런자체에 추가 구현된 메소드 
		// => 인터페이스보다 크거나 같을 수 밖에 없음
		runInterface.run();
		
		// RunInterface에는 load가 추상메소드로 존재하지 않기 때문에 에러가 발생
		// runInterface.load();// 실행안됨(런인터페이스에는 로드 추상메소드가 없음)
		// 아래 코드는 Run클래스의 객체로 클래스변환이 됐기 때문에 load() 메소드를 호출할 수 있다
		((Run)runInterface).load(); // >> Run으로 임시 형변환(다운캐스팅)하면 가능

		run(new ShopManager()); // 무언가는 무엇..? == 단어장, 판매관리 프로그램을 실행
		//run(new VocabularyNoteController()); // 에러 : ShopManager와 클래스(끼리)형변환이 가능하려면 '상속관계'여야함
											// run(어떤 프로그램 객체)가 와도 런을 실행하고 싶음 > 컨트롤러 클래스에 'implements RunInterface' 추가해서 상속!
	}
	
	// **인터페이스의 다형성(매우 중요) - 클래스의 다형성과 비슷
	/* 인터페이스 매개변수의 다형성
	 * 1. 매개변수로 인터페이스의 객체로 선언하면, 
	 * 호출할 때 매개변수로 구현 클래스들의 객체들이 올 수 있다.
	 * => 다양한 클래스들의 객체가 올 수 있다.
	 * 2. RunInterface의 객체를 매개변수로 하면, RunInterface 를 구현한 구현클래스인 
	 * ShopManager, VocabularyNoteController의 객체가 와서 프로그램을 실행할 수 있다.

	 * */
//	public static void run(ShopManager program) {/*프로그램 객체*/
//	public static void run(VocabularyNoteController program) {/*프로그램 객체*/
	public static void run(RunInterface program) {/*프로그램 객체*/
		//프로그램 실행
		program.run(); // 런이라는 메소드를 main에서 실행하고 싶음
		// 단어장 프로그램, 판매관리 프로그램에 run이라는 메소드 공통으로 있음, 메소드 하나로 같이 쓰고 싶은 것!
	}

}

// >> 퍼블릭으로 만들기위해 RunInterface 클래스 새로 만들어서 분리
// interface RunInterface{
//	/*public final static*/ int NUM = 10; // 클래스 상수 => 클래스를 이용하여 호출한다
//	// final 변수 => 상수 = 상수는 항상 값을 넣어줘야함. 일반적으로 대문자로 씀 
//	// 멤버변수 : 파란색 / 굵은색 : final / 기울임 : static
//	
//	public abstract void run(); // = 기능구현이 안된 추상메소드!
//	//(public abstract) void run
//}

 interface Stop{
	 void stop();
 }

// * 인터페이스의 역할 
// 클라이언트 프로그램에 어떤 메소드를 제공하는지 미리 알려주는 약속의 역할. 
// 인터페이스를 구현한 클래스가 어떤 기능의 메소드는 제공하는지 명시
// ex) 협업, 여러 개발자들이 기능구현중. 

// 구현 클래스 : 인터페이스를 구현한 클래스
class Run implements RunInterface, Stop {
//    ㄴ "add unimplemented method"
// 1. 구현 클래스는 인터페이스의 모든 추상 메소드를 반드시 오버라이딩 해야함
// 2. 구현 클래스는 여러 인터페이스를 구현, 활용할 수 있다. 
// - 인터페이스(기능미리보기)를 만들기도 하지만, 구현 클래스를 만드는 경우도 많음.
	// 기본형태 잘 기억 [왼쪽 : 클래스 implements 오른쪽 : 인터페이스들]
	
	public void load() {
		System.out.println("로딩중입니다....");

	}
	
	@Override
	public void run() {
		System.out.println("프로그램이 동작합니다.");
		stop();
	}

	@Override
	public void stop() {
		System.out.println("프로그램이 멈춥니다.");
	}

	
}

