package review_0630.VocabularyNote.vo;

// 단어장 클래스
public class VocabularyNote {

	// 멤버변수 : 단어들
	private Word wordList[];
	private int wordCount = 0;
	
	// 생성자
	public VocabularyNote() {
		wordList = new Word[10];
	}
	
	// 단어장 크기
	public VocabularyNote(Word wordList[]) {
		int size = wordList.length > 10 ? wordList.length : 10;
		
		this.wordList = new Word[size]; // 단어장 크기 만큼의 새 배열 생성
		// 근데 왜 this.wordList 죠?
		
		for(int i = 0; i < wordList.length; i++) {
			this.wordList[i] = new Word(wordList[i]);
		}
		
	}
	
	// [print]
	// 메소드1 : 단어들을 출력 
	public void print() {
		System.out.println("-----------");
		for(int i = 0; i < wordCount; i++) {
			wordList[i].print();
			System.out.println("-----------");
		}
	}
	
	// * 단어가 주어지면 단어가 있는 위치를 알려주는 메소드(단어가 없으면 -1)
	public int indexOf(String title) {
		for(int i = 0; i < wordCount; i++) {
			if(wordList[i].getTitle().equals(title)) {
				return i;
			}
		}
		return -1;
	}
	
	// [insert(String title, String meaning)]
	/* 메소드3 : 단어와 뜻이 주어졌을 때,
	 * 없는 단어이면 새로 단어를 추가하고 1을 리턴 / 있는 단어이면 뜻만 새로 추가하고 -1을 리턴
	 * 추가가 실패하면 0을 리턴하는 메소드 (단어와 뜻을 넘겨주는 경우)
	 */ 
	public int insert(String title, String meaning) {
//		 Word word = new Word(title, meaning);
//		 this.wordList[wordCount] = word;
//		 wordCount++;
//		 return 1;
		if(wordCount == wordList.length) {
			// System.out.println("단어장이 다 찼습니다.");
			return 0;
		}
		
		int index = indexOf(title);
		if(index == -1) {
			wordList[wordCount++] = new Word(title, meaning);
			return 1;
		}
		
		wordList[index].addMeaning(meaning);
		return -1;
	} 
	
	// [delete]
	// 메소드4 : 단어가 주어지면 단어장에서 삭제하고 삭제 여부를 알려주는 메소드
	public boolean delete(String title) {
		int index = indexOf(title);
		if(index == -1) {
		//	System.out.println("단어가 없습니다.");
			return false;
		}
		for(int i = index; i < wordCount-1; i++) {
			wordList[i] = wordList[i+1];
		}
			wordCount--;
			wordList[wordCount] = null;
		return true;
	}
	
	// [search]
	// 메소드5 : 단어가 주어지면 해당 단어를 출력하고, 단어가 있는지 없는지를 알려주는 메소드
	public boolean search(String title) {
		int index = indexOf(title);
		
		if(index == -1) {
			System.out.println("찾는 단어가 없습니다");
			return false;
		}
		wordList[index].print();
		return true;
	}
	
	// [updateTitle] 단어수정
	// 메소드7 : 단어와 (수정할 단어)가 주어지면, 단어를 수정하고 수정 여부를 알려주는 메소드
	public boolean updateTitle(String title, String UpdateTitle) {
		int index = indexOf(title);
		
		if(index == -1) {
			System.out.println("찾는 단어가 없습니다");
			return false;
		}
		wordList[index].setTitle(UpdateTitle);
		return true;
	}
	
	 //[updateMeaning(title, meaningIndex, meaning)] 뜻 수정
	 // 메소드6 : 단어와 (수정할 뜻의 번호와 수정할 뜻)이 주어지면 단어의 뜻을 수정하고, 수정여부를 알려주는 메소드
	 public boolean updateMeaning(String title, int meaningIndex, String meaning) {
		 int index = indexOf(title);
		 
		 if(index == -1) {
			 System.out.println("찾는 단어가 없습니다.");
			 return false;
		 }
		 if(wordList[index].updateMeaning(meaningIndex, meaning)) {
			 
		 }
		 return false;
		 
	 }
	 
	// [deleteMeaning(title, num)] 뜻 삭제
	// 메소드8 : 단어와 (삭제할 뜻의 번호)가 주어지면, 뜻을 삭제하고 삭제여부를 알려주는 메소드
	public boolean deleteMeaning(String title, int num) {
		int index = indexOf(title);
		if(index == -1) {
			return false;
		}
		Word tmp = wordList[index];
		if(tmp.removeMeaning(num)) {
		return true;
		}
		return false;
	}
	
// 자기가 들어갈 자리를 못찾은 메소드 두개좀 보세요.... 이제 하나가 되었소. 
	// [insert(Word word)]
	// 메소드2 : 단어가 주어지면 단어장에 추가(단어 객체를 넘겨주는 경우)
	public void insert(Word word) {
		if(wordCount == wordList.length) {
			System.out.println("단어장이 다 찼습니다");
			return;
		}
		// 깊은 복사, Word의 복사 생성자로 새단어 생성한 후 추가
		wordList[wordCount++] = new Word(word);
	}
}
