package review_0723.practice;

import lombok.Data;

@Data
public class Word {
	// 1. �������
	private String title;
	private String meaning[];
	private int meaningCount;
	
	// 2. ������
	public Word(String title, String meaning) {
		this.title = title;
		this.meaning = new String[5];
		this.meaning[0] = meaning;
		meaningCount++;
	}
	
	// ������ �����ε�
	public Word(String title) {
		this.title = title;
		this.meaning = new String[5];
	}
	
	// ���������
	public Word(Word w) {
		this.title = w.title;
		this.meaning = new String[5];
		for(int i = 0; i < w.meaningCount; i++) {
			this.meaning[i] = w.meaning[i];
		}
		meaningCount = w.meaningCount;
	}
	
	// 3. �޼ҵ�
	
}
