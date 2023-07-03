package day24._161_thread;

public class _1_ThreadEx1 {

	public static void main(String[] args) {
		ChildThread1 chThread = new ChildThread1();
		chThread.start();
		// 2. 작업1과 작업2가 섞여서 나옴. 동시에 작업하는 것처럼 보임 
		
		// 1. 싱글스레드 : 앞에 작업이 다 끝나야, 뒤에 작업이 시작됨
		for(int i = 0; i < 10; i++) {
			System.out.println("Work1");
		}
//		for(int i = 0; i < 10; i++) {
//			System.out.println("Work2");
//		}
		
	}

}

// 방법1 : 쓰레드 클래스를 상속받아서
class ChildThread1 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Work2");
		}
	}
}