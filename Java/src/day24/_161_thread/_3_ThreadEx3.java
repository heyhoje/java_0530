package day24._161_thread;

public class _3_ThreadEx3 {

	// ���3 : Runnable �������̽��� ����Ŭ������ �������(���ٽ��� �̿�)
	public static void main(String[] args) {
		Thread thread = new Thread(() -> { // ���ʺ� �������̽��� ����Ŭ������ �������. ���ٽ��� �̿��ؼ�.
			for(int i = 0; i < 10; i++) {
				System.out.println("+");
			}
		});
		// thread.run(); // ��Ƽ �����尡 �ƴ� �̱� �����尡 ��. main ������ ���� run() �� �����ϴ� ��
		thread.start(); // run �޼ҵ尡 �ƴ϶� thead �޼ҵ带 ȣ����!!!(������ �����ڷ� �׸� ����)
						// ���ο� �����带 �����, ������� �����忡 run()�� ����(��Ƽ ������)
		for(int i = 0; i < 10; i++) {
			System.out.println("-");
		}
	}
}

// �����尡 ��Ƽ���� �̱�����/ ��Ƽ�� ������� ������ ���� Ȯ������?
// ���������� ���� �׽�Ʈ ����, �����ڵ� ���� ���°ɷ�... +�����ڷ� 
	