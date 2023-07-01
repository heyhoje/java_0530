package review_0630.VocabularyNote.vo;

import lombok.Data;

// 한 단어를 관리하는 클래스(단어, 뜻)
@Data
public class Word {
	
	// 멤버변수 
	private String title;
	private String meaning[];
	private int meaningCount;
	
	// 생성자
	public Word(String title, String meaning) {
		this.title = title;
		this.meaning = new String[5];
		this.meaning[0] = meaning;
		meaningCount++;
		
	}
	
	// 생성자 오버로딩 같은데, 왜? 어느 시점에? 작성하는건지 모름니다.
//	public Word(String title) {
//		this.title = title;
//		this.meaning = new String[5];
//	}
//	
//	public Word(Word w) {
//		this.title = w.title; //  왜 w.title이 나오고 있지????
//		this.meaning = new String[5];
//		for(int i = 0; i < w.meaningCount; i++);{
//			this.meaning[i] = w.meaning[i];
//		}
//		meaningCount =  w.meaningCount;
//	}
	
	// 메소드1 : 단어와 뜻을 출력하는 메소드
	public void print() {
		
	}

// ㅡㅡㅡㅡㅡㅡㅡㅡ 여기부터 저기까진 잘 채우면서 진행함 ㅡㅡㅡㅡㅡㅡㅡㅡ
	// 메소드2 : 뜻을 추가하는 메소드
	public void addMeaning(String meaning) {
		if(meaningCount == this.meaning.length) {
			System.out.println("뜻이 다 찼습니다.");
			return;
		}		
		this.meaning[meaningCount] = meaning;
		meaningCount++;
	}
	
	// 메소드3 : 뜻을 제거하고 제거 여부를 알려주는 메소드
	public boolean removeMeaning(int num) {
		if(num > meaningCount || num < 1) {
			// System.out.println("I can't work.");
			return false;
		}
		// num-1번지부터 하나씩 당겨와서 덮어쓰기함
		for(int i = num-1; i < meaningCount-1; i++) {
			meaning[i] = meaning[i+1];
		}
		meaning[meaningCount-1] = null;
		meaningCount--;		
		return true;
	}
	
// 자리 찾음ㅇㅇㅅㄱ
	// 메소드4 : 수정할 뜻의 번호와 수정할 뜻이 주어지면 뜻을 수정하고 수정여부를 알려주는 메소드
	public boolean updateMeaning(int meaningNum, String meaning) {
		if(meaningNum > meaningCount || meaningNum <= 0) {
			return false;
		} 
		// meaningNum는 1부터이고, 번지수는 0부터이기 때문에 -1 을 한다.
		this.meaning[meaningNum-1] = meaning;
		return false;
	}
	
	// getter, setter 는 @Data 어노테이션으로 해결봄 ㅇㅇㅇ굿b
	
	

}
