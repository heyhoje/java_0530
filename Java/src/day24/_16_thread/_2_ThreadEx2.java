package day24._16_thread;

public class _2_ThreadEx2 {

	public static void main(String[] args) {
		// 2. Ŭ������ ����°� ����. ����̾ƴ� ��������(Runnable Ŭ������(�������̽���?) ������)
		Thread thread = new Thread(new ChildThread2());
		thread.start();
		
		for(int i = 0; i < 10; i++) {
			System.out.println("+");
		}
		
	}

}

// ���2 : ��ӹ��� Ŭ������ �ƴ�, ���ʺ��������̽��� �����߱� ������
// �������� �Ű������� �־������
class ChildThread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("-");
		}		
	}
	
}