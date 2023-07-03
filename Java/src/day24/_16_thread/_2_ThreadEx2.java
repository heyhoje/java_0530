package day24._16_thread;

public class _2_ThreadEx2 {

	public static void main(String[] args) {
		// 2. 클래스를 만드는건 동일. 상속이아닌 구현을함(Runnable 클래스를(인터페이스를?) 구현함)
		Thread thread = new Thread(new ChildThread2());
		thread.start();
		
		for(int i = 0; i < 10; i++) {
			System.out.println("+");
		}
		
	}

}

// 방법2 : 상속받은 클래스가 아닌, 러너블인터페이스를 구현했기 때문에
// 생성자의 매개변수로 넣어줘야함
class ChildThread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("-");
		}		
	}
	
}