package day24._16_thread;

public class _4_SynchronizedEx1 {

	// ����ȭ �۾��� �� �ʿ��Ѱ�
	public static void main(String[] args) throws InterruptedException {
		System.out.println("----����ȭ �۾� ��/��-----");
		Passbook pb = new Passbook();
		// pb�� �ٸ� �� �����忡�� �����ϴ� ���, ���ÿ� �����ؼ� ����ó�� ������ ���� �� ����.
		User user1 = new User("dul2", pb);
		User user2 = new User("Go gildong", pb); // �����̶� ������ �����ϰ�����
		user1.start();
		user2.start();
	}

}
