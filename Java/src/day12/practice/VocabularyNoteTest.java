package day12.practice;

//import VocabularyNote;

public class VocabularyNoteTest {

	public static void main(String[] args) {
		Word wordList[] = {
				new Word("abc"),
				new Word("def", "def is define")
		};
		
		VocabularyNote note = new VocabularyNote(wordList);
		note.print();
		System.out.println("----단어 ----");
		Word word = new Word("a", "a");
		note.insert(word);
		note.print();
		note.insert("b", "b is b");
		note.print();
		
		System.out.println("----단어 삭제----");
		note.delete("C"); // No words found
		note.delete("a");
		//note.print();
		
		System.out.println("----단어 검색----");
//		note.search("a");
//		note.search("b");
//		
		System.out.println("---뜻 추가---");
		note.insert("b", "b");
		//note.print();
		
		System.out.println("----뜻 수정----");
		note.updateMeaning("b", 2, "B");
		note.updateMeaning("b", 3, "B"); // 3은 없기 때문에 Wrong Number
		//note.print();
		
		System.out.println("----단어 수정----");
		note.updateTitle("b", "B");
		// No words found 출력. 이미 앞에서 수정해서 (수정할 단어가 없어서) b가 없음
		note.updateTitle("b", "B");
	
	}
 
	
}
