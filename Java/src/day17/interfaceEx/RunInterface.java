package day17.interfaceEx;

public interface RunInterface {
	/*public final static */ int NUM = 10;//Ŭ���� ���=>Ŭ������ �̿��Ͽ� ȣ��
	/*public abstract*/ void run();
	default void stop() {
		System.out.println("Program stop!");
	}
}
