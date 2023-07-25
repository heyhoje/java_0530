package review_0723.practice;

public class VocabularyNote {
	// 1. 멤버변수
	private Word wordList[];
	private int wordCount;
	
	// 2. 생성자
	public VocabularyNote() {
		wordList = new Word[10];
	}
	
	public VocabularyNote(Word wordList[]) {
		this.wordList = new Word[10];
		
		int size = wordList.length > 10 ? wordList.length : 10;
		
		this.wordList = new Word[size];
		
		for(int i = 0; i < size; i++) {
			this.wordList[i] = new Word(wordList[i]);
			
			wordCount = wordList.length;
		}
	}
	
	// 3. 메소드
}
