package day17._10_interfaceEx;

import day13.homework.controler.VocabularyNoteController;
import day15.practice.shop.controller.ShopManager;

// ���� ���� ���� �߰� �� ���� �ʿ�!!!!!!
// 230622 �������ǿ���1

public class _1_InterfaceEx {

	public static void main(String[] args) {
		/* �������̽��� �̿��Ͽ� ��ü�� ������ �� ���� */ 
		// RunInterface run = new RunInterface(); 
		// �������̽��δ� ��ü�� ������ �� ����(��� ������ �ȵ� '�߻�޼ҵ�'�� �ֱ� ����)
		
		System.out.println(RunInterface.NUM);// Ŭ���� ��� = static ��ü �������� ȣ���� �� �ִ�.
		// <- final static int NUM <- interface RunInterface
		// �������̽��� �̿��ؼ� ��ü�� ������ ���� ������, ����� ������ �� �� ����?����!

		System.out.println("----------");
		// �������̽��� ������, ����Ŭ����(runŬ����)�� ��ü�� ������ �� �ִ�. 
		Run run = new Run();
		run.run();
		run.load(); // �� �����
		
		System.out.println("---------------");
		// �������̽��� ���� ��ü�� ������ ���� ����
		// = ����Ŭ������ ���� ������ ��ü�� RunInterface�� ����
		RunInterface runInterface = new Run(); // ����ȯ! ��ĳ����!!
		// ���� Ŭ����(Run) = �������̽� ���ø���Ʈ(��� �� ��밡��) + ����ü�� �߰� ������ �޼ҵ� 
		// => �������̽����� ũ�ų� ���� �� �ۿ� ����
		runInterface.run();
		
		// RunInterface���� load�� �߻�޼ҵ�� �������� �ʱ� ������ ������ �߻�
		// runInterface.load();// ����ȵ�(���������̽����� �ε� �߻�޼ҵ尡 ����)
		// �Ʒ� �ڵ�� RunŬ������ ��ü�� Ŭ������ȯ�� �Ʊ� ������ load() �޼ҵ带 ȣ���� �� �ִ�
		((Run)runInterface).load(); // >> Run���� �ӽ� ����ȯ(�ٿ�ĳ����)�ϸ� ����

		run(new ShopManager()); // ���𰡴� ����..? == �ܾ���, �ǸŰ��� ���α׷��� ����
		//run(new VocabularyNoteController()); // ���� : ShopManager�� Ŭ����(����)����ȯ�� �����Ϸ��� '��Ӱ���'������
											// run(� ���α׷� ��ü)�� �͵� ���� �����ϰ� ���� > ��Ʈ�ѷ� Ŭ������ 'implements RunInterface' �߰��ؼ� ���!
	}
	
	// **�������̽��� ������(�ſ� �߿�) - Ŭ������ �������� ���
	/* �������̽� �Ű������� ������
	 * 1. �Ű������� �������̽��� ��ü�� �����ϸ�, 
	 * ȣ���� �� �Ű������� ���� Ŭ�������� ��ü���� �� �� �ִ�.
	 * => �پ��� Ŭ�������� ��ü�� �� �� �ִ�.
	 * 2. RunInterface�� ��ü�� �Ű������� �ϸ�, RunInterface �� ������ ����Ŭ������ 
	 * ShopManager, VocabularyNoteController�� ��ü�� �ͼ� ���α׷��� ������ �� �ִ�.

	 * */
//	public static void run(ShopManager program) {/*���α׷� ��ü*/
//	public static void run(VocabularyNoteController program) {/*���α׷� ��ü*/
	public static void run(RunInterface program) {/*���α׷� ��ü*/
		//���α׷� ����
		program.run(); // ���̶�� �޼ҵ带 main���� �����ϰ� ����
		// �ܾ��� ���α׷�, �ǸŰ��� ���α׷��� run�̶�� �޼ҵ� �������� ����, �޼ҵ� �ϳ��� ���� ���� ���� ��!
	}

}

// >> �ۺ����� ��������� RunInterface Ŭ���� ���� ���� �и�
// interface RunInterface{
//	/*public final static*/ int NUM = 10; // Ŭ���� ��� => Ŭ������ �̿��Ͽ� ȣ���Ѵ�
//	// final ���� => ��� = ����� �׻� ���� �־������. �Ϲ������� �빮�ڷ� �� 
//	// ������� : �Ķ��� / ������ : final / ����� : static
//	
//	public abstract void run(); // = ��ɱ����� �ȵ� �߻�޼ҵ�!
//	//(public abstract) void run
//}

 interface Stop{
	 void stop();
 }

// * �������̽��� ���� 
// Ŭ���̾�Ʈ ���α׷��� � �޼ҵ带 �����ϴ��� �̸� �˷��ִ� ����� ����. 
// �������̽��� ������ Ŭ������ � ����� �޼ҵ�� �����ϴ��� ���
// ex) ����, ���� �����ڵ��� ��ɱ�����. 

// ���� Ŭ���� : �������̽��� ������ Ŭ����
class Run implements RunInterface, Stop {
//    �� "add unimplemented method"
// 1. ���� Ŭ������ �������̽��� ��� �߻� �޼ҵ带 �ݵ�� �������̵� �ؾ���
// 2. ���� Ŭ������ ���� �������̽��� ����, Ȱ���� �� �ִ�. 
// - �������̽�(��ɹ̸�����)�� ����⵵ ������, ���� Ŭ������ ����� ��쵵 ����.
	// �⺻���� �� ��� [���� : Ŭ���� implements ������ : �������̽���]
	
	public void load() {
		System.out.println("�ε����Դϴ�....");

	}
	
	@Override
	public void run() {
		System.out.println("���α׷��� �����մϴ�.");
		stop();
	}

	@Override
	public void stop() {
		System.out.println("���α׷��� ����ϴ�.");
	}

	
}

