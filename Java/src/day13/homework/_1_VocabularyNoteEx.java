package day13.homework;

import java.util.Scanner;

import day12.practice.VocabularyNote;
import day12.practice.Word;

public class _1_VocabularyNoteEx {

	public static void main(String[] args) {
		// day12.practice Ȱ��. �� ������ ��� �����ϵ���....
		
		// 1. ���� �ܾ��� ���α׷��� �����ϼ���
		// Word, VocabularyNote Ŭ���� �̿�
		
		/*�޴�
		 * 1. �ܾ� �߰�
		 * 2. �ܾ� ����
		 * 3. �ܾ� ����
		 * 	 a. �ܾ� ����
		 *   b. �� ����
		 *   c. �� ����
		 * 4. �ܾ� ���
		 *   a. ��ü ���
		 *   b. �˻�
		 * 5. ���α׷� ����
		 */
		
//		�޴��� ���
//		�޴� ����
//		����޴� ����
//		����޴�����
//		������ �ܾ� / ������ �ܾ� 
//		������ �����߽��ϴ�
		
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		
		//���� �޴��� ��� �� ����
		// �迭�� �ϰ�, �� �޼ҵ� ȣ��� �ؾ��ϳ�?
		// ����޴����� �����? >> if�� ������. ���� �޴��� ���� ��.. ��µ�
		System.out.println("���� �ܾ���");
		System.out.println("1. �ܾ� �߰�");
		System.out.println("2. �ܾ� ����");
		System.out.println("3. �ܾ� ����");
		System.out.println("4. �ܾ� ���");
		System.out.println("5. ���α׷� ����");
		System.out.println("�޴��� �����ϼ��� : ");
		
		Word wordList[] = {
				new Word("abc"),
				new Word("def", "def is define")
		};
		VocabularyNote note = new VocabularyNote(wordList);
		
		do {
			
			//�޴��� �Է�
			menu = sc.nextInt();

			//������ �޴��� ���� ��¹� ����
			switch(menu) {
			case 1: 
				System.out.println("1. �ܾ� �߰�");
				
				break;
			case 2:
				System.out.println("2. �ܾ� ����");
				break;
			case 3: 
				System.out.println("3. �ܾ� ����");
				
				break;
			case 4:
				System.out.println("4. �ܾ� ���");
				
				break;
			case 5:
				System.out.println("5.���α׷� ����");
				break;
			}		
				
		}
		while(menu != 5);
			
		if(menu == 3) {
			System.out.println("a. �ܾ� ����");
			System.out.println("b. �� ����");
			System.out.println("c. �� ����");
			System.out.println("���� �޴��� �����ϼ��� : ");
		}
		if(menu == 4) {
			System.out.println("a. ��ü ���");
			System.out.println("b. �˻�");
			System.out.println("���� �޴��� �����ϼ��� : ");
			
		sc.close();
		}
		
	}
	
	/** ��� : ���θ޴��� ����
	 * �Ű����� : int num
	 * ����Ÿ�� : void??
	 * �޼ҵ�� : selectMain
	 */
	
	/** ��� : ����޴��� ����
	 * �Ű����� : int num
	 * ����Ÿ�� : void??
	 * �޼ҵ�� : selectSub
	 */
}
