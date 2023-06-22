package day17.interfaceEx;

public interface RunInterface {
	/*public final static */ int NUM = 10;//클래스 상수=>클래스를 이용하여 호출
	/*public abstract*/ void run();
	default void stop() {
		System.out.println("Program stop!");
	}
}
