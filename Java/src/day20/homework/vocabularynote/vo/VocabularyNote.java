package day20.homework.vocabularynote.vo;
 
// 수정 및 업데이트 완료

/* 단어장 클래스
 * - 단어들의 모임
 * - Word들의 모임
 * */

public class VocabularyNote {
	// 1. 멤버변수
	// 단어들
	private Word wordList[]; // 단어들
	private int wordCount; // 저장된 단어의 개수
	
	// 2. 생성자
	public VocabularyNote() {
		wordList = new Word[10]; // 멤버 wordList
		//ㄴ기본생성자는 ~`~~~~ 10개짜리 
	}
	
	public VocabularyNote(Word wordList[]) {
		this.wordList = new Word[10]; //  this. 붙여야함
		
		//기존 단어장의 크기와 10을 비교해서 큰 수로 단어장 크기로 선택
		int size = wordList.length > 10 ? wordList.length : 10;
		
		this.wordList = new Word[size];
		
		for(int i = 0; i < size; i++) {
			//this.wordList[i] = wordList[i]; // 얕은 복사. 매개변수로 넘겨준 단어장에서
			//if(i == this.wordList.length) { // 꽉찼으니까 더 할 필요가 없다.
				//return;
			this.wordList[i] = new Word(wordList[i]);
			
			wordCount = wordList.length;
		}
	}
	
	// 3. 메소드
	// 메소드1 : 단어출력
	/** 기능 : 단어들을 출력하는 메소드
	 * 매개변수 : 내가 알고있으니까 없음
	 * 리턴타입 : 없음
	 * 메소드명 : print
	 */
	public void print() {
		// 전부가 아니라 저장된 만큼만 프린트
		System.out.println("----------");
		for(int i = 0; i < wordCount; i++) {
			wordList[i].print(); // 단어들을 하나씩 꺼내서 프린트 메소드로 출력해줌
			System.out.println("----------");
		}
	}
	// 메소드2 : 단어객체 추가
	/** 기능 : 단어가 주어지면 단어장에 추가하는 메소드(단어 객체를 넘겨주는 경우)
	 * 매개변수 : 단어(단어 객체) => Word word
	 * 리턴타입 : 없음 => void
	 * 메소드명 : insert
	 */

	public void insert(Word word) {
		// 단어장에 단어가 다 찼으면 추가를 하지 못함(배열은 꽉차면 더 채울 수 없음)
		// array boundary 어쩌구 에러 발생....
		if(wordCount == wordList.length) {
			System.out.println("Vocabulary note is full!");
			return; // 
		}
		// 깊은 복사를 위해 Word의 복사 생성자를 이용하여 새 단어를 생성한 후 추가
		// (얕복을 할 경우 객체는 문제가 생길 수 있음)
		wordList[wordCount++] = new Word(word);
		// wordList[wordCount] = new Word(word); // wordCount번지에 저장
		// wordCount++;
	}

	// 메소드2+ : (메소드 오버로딩)
	/** 기능 : 단어와 뜻이 주어질때 없는 단어이면 새로 단어를 추가하고 '1을 리턴',
	 * 		  있는 단어이면 뜻만 새로 추가하고 '-1을 리턴하고,
	 * '추가가 실패하면 0을 리턴하는' 매소드(단어와 뜻을 넘겨주는 경우)
	 * 		// 메소드2 + 있는 단어이면 뜻만 새로 추가
	 * 매개변수 : 단어와 뜻 => String title, String meaning
	 * 리턴타입 : (리턴 값 추가!) -1(뜻 추가), 0(추가실패), 1(단어추가) => int
	 * 메소드명 : insert (매개변수만 다름 / 메소드 오버로딩)
	 */

	public int insert(String title, String meaning) {
		// 단어장에 단어가 다 찼으면 추가하지 못함(배열은 꽉차면 더 채울 수 없음)
		if(wordCount == wordList.length) {
			// System.out.println("Vocabulary note is full!");
			return 0; // 
		}
		int index = indexOf(title);
		//없는 단어이면 새 단어로 추가
		if(index == -1) {
			// 깊은 복사를 위해 Word의 복사 생성자를 이용하여 새 단어를 생성한 후 추가
			// (얕복을 할 경우 객체는 문제가 생길 수 있음)
			// 단어와 뜻을 이용해 단어 객체를 생성한 후 단어장에 추가
			wordList[wordCount++] = new Word(title, meaning);
			return 1;
		}
		// 있는 단어이면 뜻을 추가
		wordList[index].addMeaning(meaning);
		return -1;
	}
	
	// 메소드3 : 단어 삭제
	/** 기능 : 단어가 주어지면 단어장에서 단어를 삭제하고 삭제 여부를 알려주는 메소드
	 * 매개변수 : 삭제할 단어 => String title
	 * 리턴타입 : 없음 / 삭제(인지 아닌지_)여부 => void / boolean
	 * 메소드명 : delete
	 */
	
	public boolean delete(String title) {
		// 단어가 어디 있는지 찾아야함 -> 한칸씩 땡겨줘야함
		// class Word에서 삭제 처럼(removeMeaning)
		int index = indexOf(title);
		// 단어가 단어장에 없으면 알림 메세지 출력 후 종료
		if(index == -1) {
			//System.out.println("No words found"); // 출력문은 콘솔에서만
			return false;
		}
		
		// 찾은 위치부터 한칸씩 밀어줌
		for(int i = index; i < wordCount - 1; i++) {
			wordList[i] = wordList[i+1];
		}
		
		// 단어의 개수를 하나 줄여줌
		wordCount--;
		// 마지막 단어를 비워줌(null) 
		// 번지는 (크기 -1)
		wordList[wordCount] = null;
		return true;
	}
	
	// 메소드3+ : 메소드 삭제 <- 위치찾는 메소드
	/** 기능 : 단어가 주어지면 단어가 있는 위치를 알려주는 메소드
	 * ===> 해당하는 단어가 없으면, -1(배열의 주소는 0번지부터 시작하기 때문에 음수가 나올 수 없음, 
	 * 		그래서 배열에서 나올 수 없는 값으로 음수 아무거나 넣음)
	 * 매개변수 : 단어 => String title
	 * 리턴타입 : 위치 => 번지 => 정수 => int
	 * 메소드명 : indexOf
	 */
	// 어디있는지 알면, 해당 단어를 출력하는 메소드에서 쓸 수 있음(재사용)
	
	public int indexOf(String title) {
		// 단어장에 등록된 단어들을 조회
		for(int i = 0; i < wordCount; i++) {
			// 단어가 같으면, i번지를 리턴
			if(wordList[i].getTitle().equals(title)) { //기본자료형은 ==/참조자료형은 .equals(title) 해줘야함
				return i;
			}
		}
		// 찾아서 있으면 리턴하고 반복문 빠져나감.
		// 여기까지 오면 일치하는 단어가 없는 경우이므로, -1 을 리턴
		return -1;
	}
	
	// 메소드4 : 단어검색
	/** 기능 : 단어가 주어지면 단어장에 해당 단어를 출력하'고 단어가 있는지 없는지를 알려주는' 메소드
	 * 매개변수 : 단어 => String title 
	 * 리턴타입 : 단어가 있는지 없는지 => boolean
	 * 메소드명 : search
	 */
	 
	public boolean search(String title) {
		int index = indexOf(title);
		
		if (index == -1) { // 해당하는 단어가 없으면
			//System.out.println("No word found");
			return false;
		}
		
		wordList[index].print();
		return true;
	}
	 
	// 메소드5 : 단어 뜻(의미) 수정/업데이트
	/** 기능 : 단어와 수정할 뜻(의미)의 번호와 수정할 뜻이 주어지면 단어의 뜻을 수정하고
	 * 		  '수정 여부를 알려주는' 메소드
	 * * 매개변수 : 뜻을 수정할 단어, 수정할 뜻의 번호, 수정할 뜻 
	 * 			=> String title, (int meaningIndex), String meaning 
	 * 리턴타입 : (수정하고 끝) 없음 / 수정여부 => void / boolean
	 * 메소드명 : updateMeaning
	 */
	
	public boolean updateMeaning(String title, int meaningIndex, String meaning) {
		// 해당 단어가 어디있는지 찾기
		int index = indexOf(title);
		
		if(index == -1) {
			//System.out.println("No words found");
			return false; //하고 끝
		}
		// 있으면,		뜻 수정하는 메소드...? 이것은 무엇
		if(!wordList[index].updateMeaning(meaningIndex, meaning)) {
			// System.out.println("Wrong number");
			return false;
		}
		return true;
		
	}
	
	// 메소드6 : 단어수정
	/** 기능 : 단어와 수정할 단어가 주어지면 단어를 수정하는 메소드
	 * 매개변수 : 단어와 수정할 단어 => String title, String updateTitle 
	 * 리턴타입 : (수정하고 끝)없음 /수정 여부 => void / boolean
	 * 메소드명 : updateTitle
	 */
	
	public boolean updateTitle(String title, String updateTitle) {
		int index = indexOf(title);
		
		if(index == -1) {
			//System.out.println("No words found");
			return false;
		}
		
		wordList[index].setTitle(updateTitle);
		return true;
	}
	
	// 메소드7 : 단어삭제
	/** 기능 : 단어와 삭제할 뜻의 번호가 주어지면, 뜻을 삭제하고, 삭제여부를 알려주는 메소드
	 * 매개변수 : 단어와 뜻 번호 => String title, int num
	 * 리턴타입 : 뜻 삭제 여부 => boolean
	 * 메소드명 : deleteMeaning
	 */
	public boolean deleteMeaning(String title, int num) {
		//단어의 위치를 찾음
		int index = indexOf(title);
		
		if(index == -1) { // 해당하는 단어가 없으면 삭제 못함
			return false;
		}
		Word tmp = wordList[index]; // 단어를 객체에 저장
		if(tmp.removeMeaning(num)) {
			return true;
		}
		return false;
	}
	
}