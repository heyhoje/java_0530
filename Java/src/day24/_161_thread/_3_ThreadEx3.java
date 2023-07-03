package day24._161_thread;

public class _3_ThreadEx3 {

	// 방법3 : Runnable 인터페이스의 구현클래스를 만들어줌(람다식을 이용)
	public static void main(String[] args) {
		Thread thread = new Thread(() -> { // 러너블 인터페이스의 구현클래스를 만들어줌. 람다식을 이용해서.
			for(int i = 0; i < 10; i++) {
				System.out.println("+");
			}
		});
		// thread.run(); // 멀티 쓰레드가 아닌 싱글 쓰레드가 됨. main 쓰레드 위에 run() 을 실행하는 꼴
		thread.start(); // run 메소드가 아니라 thead 메소드를 호출함!!!(쓰레드 강의자료 그림 참고)
						// 새로운 쓰레드를 만들고, 만들어진 쓰레드에 run()을 실행(멀티 쓰레드)
		for(int i = 0; i < 10; i++) {
			System.out.println("-");
		}
	}
}

// 스레드가 멀티인지 싱글인지/ 멀티면 몇개인지를 무엇을 보고 확인하지?
// 스레드편은 역시 테스트 이후, 나도코딩 강의 보는걸로... +강의자료 
	
