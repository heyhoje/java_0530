package day12.practice;
 
// �� �����߰� �����ٳ���.....


/* �ܾ��� Ŭ����
 * - �ܾ���� ����
 * - Word���� ����
 * */

public class VocabularyNote {
	// 1. �������
	// �ܾ��
	private Word wordList[];
	private int wordCount; // ����� �ܾ��� ����
	
	// 2. ������
	public VocabularyNote() {
		wordList = new Word[10]; // ��� wordList
		���⺻�����ڴ� ~`~~~~ 10��¥�� 
	}
	
	public VocabularyNote(Word wordList[]) {
		// this.wordList = new Word[10]; //  this. �ٿ�����
		
		//���� �ܾ����� ũ��� 10�� ���ؼ� ū ���� �ܾ��� ũ��� ����
		int size = wordList.length > 10 ? wordList.length : 10;
		
		for(int i = 0; i < wordList.length; i++) {
			//this.wordList[i] = wordList[i]; // ���� ����. �Ű������� �Ѱ��� �ܾ��忡��
			//if(i == this.wordList.length) { // ��á���ϱ� �� �� �ʿ䰡 ����.
				//return;
			this.wordList[i] = new Word(wordList[i]);
			}
			wordCount = wordList.length;
		}
	}
	
	// 3. �޼ҵ�
	/** ��� : �ܾ���� ����ϴ� �޼ҵ�
	 * �Ű����� : ���� �˰������ϱ� ����
	 * ����Ÿ�� : ����
	 * �޼ҵ�� : print
	 */
	public void print() {
		// ���ΰ� �ƴ϶� ����� ��ŭ�� ����Ʈ
		for(int i = 0; i < wordCount; i++) {
			wordList[i].print(); // �ܾ���� �ϳ��� ������ ����Ʈ �޼ҵ�� �������
		}
	}
}
