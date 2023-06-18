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
		System.out.println("----�ܾ� ----");
		Word word = new Word("a", "a");
		note.insert(word);
		note.print();
		note.insert("b", "b is b");
		note.print();
		
		System.out.println("----�ܾ� ����----");
		note.delete("C"); // No words found
		note.delete("a");
		//note.print();
		
		System.out.println("----�ܾ� �˻�----");
//		note.search("a");
//		note.search("b");
//		
		System.out.println("---�� �߰�---");
		note.insert("b", "b");
		//note.print();
		
		System.out.println("----�� ����----");
		note.updateMeaning("b", 2, "B");
		note.updateMeaning("b", 3, "B"); // 3�� ���� ������ Wrong Number
		//note.print();
		
		System.out.println("----�ܾ� ����----");
		note.updateTitle("b", "B");
		// No words found ���. �̹� �տ��� �����ؼ� (������ �ܾ ���) b�� ����
		note.updateTitle("b", "B");
	
	}
 
	
}
