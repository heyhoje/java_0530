package review_0630.VocabularyNote.vo;

// �ܾ��� Ŭ����
public class VocabularyNote {

	// ������� : �ܾ��
	private Word wordList[];
	private int wordCount = 0;
	
	// ������
	public VocabularyNote() {
		wordList = new Word[10];
	}
	
	// �ܾ��� ũ��
	public VocabularyNote(Word wordList[]) {
		int size = wordList.length > 10 ? wordList.length : 10;
		
		this.wordList = new Word[size]; // �ܾ��� ũ�� ��ŭ�� �� �迭 ����
		// �ٵ� �� this.wordList ��?
		
		for(int i = 0; i < wordList.length; i++) {
			this.wordList[i] = new Word(wordList[i]);
		}
		
	}
	
	// [print]
	// �޼ҵ�1 : �ܾ���� ��� 
	public void print() {
		System.out.println("-----------");
		for(int i = 0; i < wordCount; i++) {
			wordList[i].print();
			System.out.println("-----------");
		}
	}
	
	// * �ܾ �־����� �ܾ �ִ� ��ġ�� �˷��ִ� �޼ҵ�(�ܾ ������ -1)
	public int indexOf(String title) {
		for(int i = 0; i < wordCount; i++) {
			if(wordList[i].getTitle().equals(title)) {
				return i;
			}
		}
		return -1;
	}
	
	// [insert(String title, String meaning)]
	/* �޼ҵ�3 : �ܾ�� ���� �־����� ��,
	 * ���� �ܾ��̸� ���� �ܾ �߰��ϰ� 1�� ���� / �ִ� �ܾ��̸� �游 ���� �߰��ϰ� -1�� ����
	 * �߰��� �����ϸ� 0�� �����ϴ� �޼ҵ� (�ܾ�� ���� �Ѱ��ִ� ���)
	 */ 
	public int insert(String title, String meaning) {
//		 Word word = new Word(title, meaning);
//		 this.wordList[wordCount] = word;
//		 wordCount++;
//		 return 1;
		if(wordCount == wordList.length) {
			// System.out.println("�ܾ����� �� á���ϴ�.");
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
	// �޼ҵ�4 : �ܾ �־����� �ܾ��忡�� �����ϰ� ���� ���θ� �˷��ִ� �޼ҵ�
	public boolean delete(String title) {
		int index = indexOf(title);
		if(index == -1) {
		//	System.out.println("�ܾ �����ϴ�.");
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
	// �޼ҵ�5 : �ܾ �־����� �ش� �ܾ ����ϰ�, �ܾ �ִ��� �������� �˷��ִ� �޼ҵ�
	public boolean search(String title) {
		int index = indexOf(title);
		
		if(index == -1) {
			System.out.println("ã�� �ܾ �����ϴ�");
			return false;
		}
		wordList[index].print();
		return true;
	}
	
	// [updateTitle] �ܾ����
	// �޼ҵ�7 : �ܾ�� (������ �ܾ�)�� �־�����, �ܾ �����ϰ� ���� ���θ� �˷��ִ� �޼ҵ�
	public boolean updateTitle(String title, String UpdateTitle) {
		int index = indexOf(title);
		
		if(index == -1) {
			System.out.println("ã�� �ܾ �����ϴ�");
			return false;
		}
		wordList[index].setTitle(UpdateTitle);
		return true;
	}
	
	 //[updateMeaning(title, meaningIndex, meaning)] �� ����
	 // �޼ҵ�6 : �ܾ�� (������ ���� ��ȣ�� ������ ��)�� �־����� �ܾ��� ���� �����ϰ�, �������θ� �˷��ִ� �޼ҵ�
	 public boolean updateMeaning(String title, int meaningIndex, String meaning) {
		 int index = indexOf(title);
		 
		 if(index == -1) {
			 System.out.println("ã�� �ܾ �����ϴ�.");
			 return false;
		 }
		 if(wordList[index].updateMeaning(meaningIndex, meaning)) {
			 
		 }
		 return false;
		 
	 }
	 
	// [deleteMeaning(title, num)] �� ����
	// �޼ҵ�8 : �ܾ�� (������ ���� ��ȣ)�� �־�����, ���� �����ϰ� �������θ� �˷��ִ� �޼ҵ�
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
	
// �ڱⰡ �� �ڸ��� ��ã�� �޼ҵ� �ΰ��� ������.... ���� �ϳ��� �Ǿ���. 
	// [insert(Word word)]
	// �޼ҵ�2 : �ܾ �־����� �ܾ��忡 �߰�(�ܾ� ��ü�� �Ѱ��ִ� ���)
	public void insert(Word word) {
		if(wordCount == wordList.length) {
			System.out.println("�ܾ����� �� á���ϴ�");
			return;
		}
		// ���� ����, Word�� ���� �����ڷ� ���ܾ� ������ �� �߰�
		wordList[wordCount++] = new Word(word);
	}
}
