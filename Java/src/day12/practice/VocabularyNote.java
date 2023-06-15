package day12.practice;
 
// 또 에러뜨고 난리다난리.....


/* 단어장 클래스
 * - 단어들의 모임
 * - Word들의 모임
 * */

public class VocabularyNote {
	// 1. 멤버변수
	// 단어들
	private Word wordList[];
	private int wordCount; // 저장된 단어의 개수
	
	// 2. 생성자
	public VocabularyNote() {
		wordList = new Word[10]; // 멤버 wordList
		ㄴ기본생성자는 ~`~~~~ 10개짜리 
	}
	
	public VocabularyNote(Word wordList[]) {
		// this.wordList = new Word[10]; //  this. 붙여야함
		
		//기존 단어장의 크기와 10을 비교해서 큰 수로 단어장 크기로 선택
		int size = wordList.length > 10 ? wordList.length : 10;
		
		for(int i = 0; i < wordList.length; i++) {
			//this.wordList[i] = wordList[i]; // 얕은 복사. 매개변수로 넘겨준 단어장에서
			//if(i == this.wordList.length) { // 꽉찼으니까 더 할 필요가 없다.
				//return;
			this.wordList[i] = new Word(wordList[i]);
			}
			wordCount = wordList.length;
		}
	}
	
	// 3. 메소드
	/** 기능 : 단어들을 출력하는 메소드
	 * 매개변수 : 내가 알고있으니까 없음
	 * 리턴타입 : 없음
	 * 메소드명 : print
	 */
	public void print() {
		// 전부가 아니라 저장된 만큼만 프린트
		for(int i = 0; i < wordCount; i++) {
			wordList[i].print(); // 단어들을 하나씩 꺼내서 프린트 메소드로 출력해줌
		}
	}
}
