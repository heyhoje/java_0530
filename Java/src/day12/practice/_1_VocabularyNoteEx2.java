package day12.practice;

import java.util.Scanner;

public class _1_VocabularyNoteEx2 {

	public static void main(String[] args) {
		// 1. 영어 단어장을 만들기 위해 필요한 객체를 만들고 테스트 해보세요. 
		// 아직 배열 안쓰고/ 최종적으로는 단어장을 만든다구요?
		
		Word word1 = new Word("vocabulary", "the words that ~");
		word1.print();
		word1.addMeaning("all of the words known and used by a person");
		word1.print();
		
		System.out.println("--삭제--");
		word1.removeMeaning(1);
		word1.print();
	
	}
//		String Vocabulary = new String();
//		System.out.println("영어 단어를 입력하세요.");
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



	

