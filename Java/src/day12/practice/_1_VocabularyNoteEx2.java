package day12.practice;

import java.util.Scanner;

public class _1_VocabularyNoteEx2 {

	public static void main(String[] args) {
		// 1. ���� �ܾ����� ����� ���� �ʿ��� ��ü�� ����� �׽�Ʈ �غ�����. 
		// ���� �迭 �Ⱦ���/ ���������δ� �ܾ����� ����ٱ���?
		
		Word word1 = new Word("vocabulary", "the words that ~");
		word1.print();
		word1.addMeaning("all of the words known and used by a person");
		word1.print();
		
		System.out.println("--����--");
		word1.removeMeaning(1);
		word1.print();
	
	}
//		String Vocabulary = new String();
//		System.out.println("���� �ܾ �Է��ϼ���.");
//		Scanner sc = new Scanner(System.in);
//		Vocabulary = sc.next();
//		
//		int num = 10;
//		for(int i = 0; i < num; ) { 
//			System.out.println(i + ". " + Vocabulary);
//			i++;
//			}
//		sc.close();
	

}

class vocabularyNote{
	
}



	

