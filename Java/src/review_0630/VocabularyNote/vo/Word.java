package review_0630.VocabularyNote.vo;

import lombok.Data;

// �� �ܾ �����ϴ� Ŭ����(�ܾ�, ��)
@Data
public class Word {
	
	// ������� 
	private String title;
	private String meaning[];
	private int meaningCount;
	
	// ������
	public Word(String title, String meaning) {
		this.title = title;
		this.meaning = new String[5];
		this.meaning[0] = meaning;
		meaningCount++;
		
	}
	
	// ������ �����ε� ������, ��? ��� ������? �ۼ��ϴ°��� �𸧴ϴ�.
//	public Word(String title) {
//		this.title = title;
//		this.meaning = new String[5];
//	}
//	
//	public Word(Word w) {
//		this.title = w.title; //  �� w.title�� ������ ����????
//		this.meaning = new String[5];
//		for(int i = 0; i < w.meaningCount; i++);{
//			this.meaning[i] = w.meaning[i];
//		}
//		meaningCount =  w.meaningCount;
//	}
	
	// �޼ҵ�1 : �ܾ�� ���� ����ϴ� �޼ҵ�
	public void print() {
		
	}

// �ѤѤѤѤѤѤѤ� ������� ������� �� ä��鼭 ������ �ѤѤѤѤѤѤѤ�
	// �޼ҵ�2 : ���� �߰��ϴ� �޼ҵ�
	public void addMeaning(String meaning) {
		if(meaningCount == this.meaning.length) {
			System.out.println("���� �� á���ϴ�.");
			return;
		}		
		this.meaning[meaningCount] = meaning;
		meaningCount++;
	}
	
	// �޼ҵ�3 : ���� �����ϰ� ���� ���θ� �˷��ִ� �޼ҵ�
	public boolean removeMeaning(int num) {
		if(num > meaningCount || num < 1) {
			// System.out.println("I can't work.");
			return false;
		}
		// num-1�������� �ϳ��� ��ܿͼ� �������
		for(int i = num-1; i < meaningCount-1; i++) {
			meaning[i] = meaning[i+1];
		}
		meaning[meaningCount-1] = null;
		meaningCount--;		
		return true;
	}
	
// �ڸ� ã����������
	// �޼ҵ�4 : ������ ���� ��ȣ�� ������ ���� �־����� ���� �����ϰ� �������θ� �˷��ִ� �޼ҵ�
	public boolean updateMeaning(int meaningNum, String meaning) {
		if(meaningNum > meaningCount || meaningNum <= 0) {
			return false;
		} 
		// meaningNum�� 1�����̰�, �������� 0�����̱� ������ -1 �� �Ѵ�.
		this.meaning[meaningNum-1] = meaning;
		return false;
	}
	
	// getter, setter �� @Data ������̼����� �ذẽ ��������b
	
	

}
