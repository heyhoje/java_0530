package day17.interfaceEx;

// 깃헙 보고 내용 추가 및 이해 필요!!!!!!

public class _1_InterfaceEx {

	public static void main(String[] args) {
		/* 인터페이스를 이용하여 객체를 생성할 수 없음 */ 
		// RunINterrface run = new RunInterface(); // 인터페이스로는 객체를 생성할 수 없다(기능 구현이 안된 추상메소드가 있기 떄문)
		
		System.out.println(RunInterface.NUM);// static 객체 생성없이 호출할 수 있다.
	}

}


// 구현 클래스 : 인터페이스를 구현한 클래스
//구현 클래스는 인터페이스의 모든 추상 메소드를 반드시 오버라이딩 해야함

