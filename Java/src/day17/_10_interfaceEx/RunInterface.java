package day17._10_interfaceEx;

// RunInterface�� �ۺ����� ����� ����!
// => ���ϸ�� Ŭ�������� ���ƾ���(�׷��� �� Ŭ������ �и��Ѱſ���)

public interface RunInterface{
	/*public final static*/ int NUM = 10; // Ŭ���� ��� => Ŭ������ �̿��Ͽ� ȣ���Ѵ�
	// final ���� => ��� = ����� �׻� ���� �־������. �Ϲ������� �빮�ڷ� �� 
	// ������� : �Ķ��� / ������ : final / ����� : static
	
	public abstract void run(); // = ��ɱ����� �ȵ� �߻�޼ҵ�!
	//(public abstract) void run
	
	default void stop() { // void stop(); �߻�޼ҵ� > ����Ʈ �޼ҵ�� ����
		System.out.println("program stop");
	}
	/* ������ ������� �������̽��� ���ο� �޼ҵ带 �߰��ϰ� �Ǹ� 
	 * ������ �ش� �������̽��� ����ϴ� ���� Ŭ�����鿡 ������ �߻�
	 * => �������̽��� �ڴʰ� ����� �߰��Ǿ ������ �߻����� �ʵ��� defaultŰ����, ����Ʈ �޼ҵ� �̿�
	 */
}

