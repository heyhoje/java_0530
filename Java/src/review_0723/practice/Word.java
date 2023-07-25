package review_0723.practice;

import lombok.Data;

@Data
public class Word {
	// 1. 멤버변수
	private String title;
	private String meaning[];
	private int meaningCount;
	
	// 2. 생성자
	public Word(String title, String meaning) {
		this.title = title;
		this.meaning = new String[5];
		this.meaning[0] = meaning;
		meaningCount++;
	}
	
	// 생성자 오버로딩
	public Word(String title) {
		this.title = title;
		this.meaning = new String[5];
	}
	
	// 복사생성자
	public Word(Word w) {
		this.title = w.title;
		this.meaning = new String[5];
		for(int i = 0; i < w.meaningCount; i++) {
			this.meaning[i] = w.meaning[i];
		}
		meaningCount = w.meaningCount;
	}
	
	// 3. 메소드
	
}
