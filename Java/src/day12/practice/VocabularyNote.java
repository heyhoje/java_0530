package day12.practice;
 
// ���� �� ������Ʈ �Ϸ�

/* �ܾ��� Ŭ����
 * - �ܾ���� ����
 * - Word���� ����
 * */

public class VocabularyNote {
	// 1. �������
	// �ܾ��
	private Word wordList[]; // �ܾ��
	private int wordCount; // ����� �ܾ��� ����
	
	// 2. ������
	public VocabularyNote() {
		wordList = new Word[10]; // ��� wordList
		//���⺻�����ڴ� ~`~~~~ 10��¥�� 
	}
	
	public VocabularyNote(Word wordList[]) {
		this.wordList = new Word[10]; //  this. �ٿ�����
		
		//���� �ܾ����� ũ��� 10�� ���ؼ� ū ���� �ܾ��� ũ��� ����
		int size = wordList.length > 10 ? wordList.length : 10;
		
		this.wordList = new Word[size];
		
		for(int i = 0; i < size; i++) {
			//this.wordList[i] = wordList[i]; // ���� ����. �Ű������� �Ѱ��� �ܾ��忡��
			//if(i == this.wordList.length) { // ��á���ϱ� �� �� �ʿ䰡 ����.
				//return;
			this.wordList[i] = new Word(wordList[i]);
			
			wordCount = wordList.length;
		}
	}
	
	// 3. �޼ҵ�
	// �޼ҵ�1 : �ܾ����
	/** ��� : �ܾ���� ����ϴ� �޼ҵ�
	 * �Ű����� : ���� �˰������ϱ� ����
	 * ����Ÿ�� : ����
	 * �޼ҵ�� : print
	 */
	public void print() {
		// ���ΰ� �ƴ϶� ����� ��ŭ�� ����Ʈ
		System.out.println("----------");
		for(int i = 0; i < wordCount; i++) {
			wordList[i].print(); // �ܾ���� �ϳ��� ������ ����Ʈ �޼ҵ�� �������
			System.out.println("----------");
		}
	}
	// �޼ҵ�2 : �ܾü �߰�
	/** ��� : �ܾ �־����� �ܾ��忡 �߰��ϴ� �޼ҵ�(�ܾ� ��ü�� �Ѱ��ִ� ���)
	 * �Ű����� : �ܾ�(�ܾ� ��ü) => Word word
	 * ����Ÿ�� : ���� => void
	 * �޼ҵ�� : insert
	 */

	public void insert(Word word) {
		// �ܾ��忡 �ܾ �� á���� �߰��� ���� ����(�迭�� ������ �� ä�� �� ����)
		// array boundary ��¼�� ���� �߻�....
		if(wordCount == wordList.length) {
			System.out.println("Vocabulary note is full!");
			return; // 
		}
		// ���� ���縦 ���� Word�� ���� �����ڸ� �̿��Ͽ� �� �ܾ ������ �� �߰�
		// (�躹�� �� ��� ��ü�� ������ ���� �� ����)
		wordList[wordCount++] = new Word(word);
		// wordList[wordCount] = new Word(word); // wordCount������ ����
		// wordCount++;
	}

	// �޼ҵ�2+ : (�޼ҵ� �����ε�)
	/** ��� : �ܾ�� ���� �־����� ���� �ܾ��̸� ���� �ܾ �߰��ϰ�,
	 * 		  �ִ� �ܾ��̸� �游 ���� �߰��ϴ� �żҵ�(�ܾ�� ���� �Ѱ��ִ� ���)
	 * 		// �޼ҵ�2 + �ִ� �ܾ��̸� �游 ���� �߰�
	 * �Ű����� : �ܾ�� �� => String title, String meaning
	 * ����Ÿ�� : ���� => void
	 * �޼ҵ�� : insert (�Ű������� �ٸ� / �޼ҵ� �����ε�)
	 */

	public void insert(String title, String meaning) {
		// �ܾ��忡 �ܾ �� á���� �߰����� ����(�迭�� ������ �� ä�� �� ����)
		if(wordCount == wordList.length) {
			System.out.println("Vocabulary note is full!");
			return; // 
		}
		int index = indexOf(title);
		//���� �ܾ��̸� �� �ܾ�� �߰�
		if(index == -1) {
			// ���� ���縦 ���� Word�� ���� �����ڸ� �̿��Ͽ� �� �ܾ ������ �� �߰�
			// (�躹�� �� ��� ��ü�� ������ ���� �� ����)
			// �ܾ�� ���� �̿��� �ܾ� ��ü�� ������ �� �ܾ��忡 �߰�
			wordList[wordCount++] = new Word(title, meaning);
			return;
		}
		// �ִ� �ܾ��̸� ���� �߰�
		wordList[index].addMeaning(meaning);
	}
	
	// �޼ҵ�3 : �ܾ� ����
	/** ��� : �ܾ �־����� �ܾ��忡�� �����ϴ� �޼ҵ�
	 * �Ű����� : ������ �ܾ� => String title
	 * ����Ÿ�� : ���� / �������� => void
	 * �޼ҵ�� : delete
	 */
	
	public void delete(String title) {
		// �ܾ ��� �ִ��� ã�ƾ��� -> ��ĭ�� ���������
		// class Word���� ���� ó��(removeMeaning)
		int index = indexOf(title);
		// �ܾ �ܾ��忡 ������ �˸� �޼��� ��� �� ����
		if(index == -1) {
			System.out.println("No words found");
			return;
		}
		
		// ã�� ��ġ���� ��ĭ�� �о���
		for(int i = index; i < wordCount - 1; i++) {
			wordList[i] = wordList[i+1];
		}
		
		// �ܾ��� ������ �ϳ� �ٿ���
		wordCount--;
		// ������ �ܾ �����(null) 
		// ������ (ũ�� -1)
		wordList[wordCount] = null;
	}
	
	// �޼ҵ�3+ : �޼ҵ� ���� <- ��ġã�� �޼ҵ�
	/** ��� : �ܾ �־����� �ܾ �ִ� ��ġ�� �˷��ִ� �޼ҵ�
	 * ===> �ش��ϴ� �ܾ ������, -1(�迭�� �ּҴ� 0�������� �����ϱ� ������ ������ ���� �� ����, 
	 * 		�׷��� �迭���� ���� �� ���� ������ ���� �ƹ��ų� ����)
	 * �Ű����� : �ܾ� => String title
	 * ����Ÿ�� : ��ġ => ���� => ���� => int
	 * �޼ҵ�� : indexOf
	 */
	// ����ִ��� �˸�, �ش� �ܾ ����ϴ� �޼ҵ忡�� �� �� ����(����)
	
	public int indexOf(String title) {
		// �ܾ��忡 ��ϵ� �ܾ���� ��ȸ
		for(int i = 0; i < wordCount; i++) {
			// �ܾ ������, i������ ����
			if(wordList[i].getTitle().equals(title)) { //�⺻�ڷ����� ==/�����ڷ����� .equals(title) �������
				return i;
			}
		}
		// ã�Ƽ� ������ �����ϰ� �ݺ��� ��������.
		// ������� ���� ��ġ�ϴ� �ܾ ���� ����̹Ƿ�, -1 �� ����
		return -1;
	}
	
	// �޼ҵ�4 : �ܾ�˻�
	/** ��� : �ܾ �־����� �ܾ��忡 �ش� �ܾ ����ϴ� �޼ҵ�
	 * �Ű����� : �ܾ� => String title 
	 * ����Ÿ�� : ���� => void
	 * �޼ҵ�� : search
	 */
	 
	public void search(String title) {
		int index = indexOf(title);
		
		if (index == -1) { // �ش��ϴ� �ܾ ������
			System.out.println("No word found");
			return;
		}
		
		wordList[index].print();
	}
	 
	// �޼ҵ�5 : �ܾ� ��(�ǹ�) ����/������Ʈ
	/** ��� : �ܾ�� ������ ��(�ǹ�)�� ��ȣ�� ������ ���� �־����� �ܾ��� ���� �����ϴ� �޼ҵ�
	 * * �Ű����� : ���� ������ �ܾ�, ������ ���� ��ȣ, ������ �� 
	 * 			=> String title, int meaningIndex, String meaning 
	 * ����Ÿ�� : (�����ϰ� ��) ���� => void
	 * �޼ҵ�� : updateMeaning
	 */
	
	public void updateMeaning(String title, int meaningIndex, String meaning) {
		// �ش� �ܾ ����ִ��� ã��
		int index = indexOf(title);
		
		if(index == -1) {
			System.out.println("No words found");
			return; //�ϰ� ��
		}
		// ������,		�� �����ϴ� �޼ҵ�...? �̰��� ����
		if(!wordList[index].updateMeaning(meaningIndex, meaning)) {
			System.out.println("Wrong number");
		}
		
	}
	
	// �޼ҵ�6 : �ܾ����
	/** ��� : �ܾ�� ������ �ܾ �־����� �ܾ �����ϴ� �޼ҵ�
	 * �Ű����� : �ܾ�� ������ �ܾ� => String title, String updateTitle 
	 * ����Ÿ�� : (�����ϰ� ��)���� => void
	 * �޼ҵ�� : updateTitle
	 */
	
	public void updateTitle(String title, String updateTitle) {
		int index = indexOf(title);
		
		if(index == -1) {
			System.out.println("No words found");
			return;
		}
		
		wordList[index].setTitle(updateTitle);
	}
	
}
 