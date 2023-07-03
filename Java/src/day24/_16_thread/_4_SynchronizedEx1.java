package day24._16_thread;

public class _4_SynchronizedEx1 {

	// 동기화 작업이 왜 필요한가
	public static void main(String[] args) throws InterruptedException {
		System.out.println("----동기화 작업 전/후-----");
		Passbook pb = new Passbook();
		// pb를 다른 두 쓰레드에서 공유하는 경우, 동시에 접근해서 지금처럼 문제가 생길 수 있음.
		User user1 = new User("dul2", pb);
		User user2 = new User("Go gildong", pb); // 가족이라 통장을 공유하고있음
		user1.start();
		user2.start();
	}

}
