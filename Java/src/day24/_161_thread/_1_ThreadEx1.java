package day24._161_thread;

public class _1_ThreadEx1 {

	public static void main(String[] args) {
		ChildThread1 chThread = new ChildThread1();
		chThread.start();
		// 2. �۾�1�� �۾�2�� ������ ����. ���ÿ� �۾��ϴ� ��ó�� ���� 
		
		// 1. �̱۽����� : �տ� �۾��� �� ������, �ڿ� �۾��� ���۵�
		for(int i = 0; i < 10; i++) {
			System.out.println("Work1");
		}
//		for(int i = 0; i < 10; i++) {
//			System.out.println("Work2");
//		}
		
	}

}

// ���1 : ������ Ŭ������ ��ӹ޾Ƽ�
class ChildThread1 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Work2");
		}
	}
}