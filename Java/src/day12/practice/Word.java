package day12.practice;

// �� ���ƴ� ����� ��������ڸ� ������µ� ���ڱ� class word�� �Ѿ���ֳ�
public class Word {
		/* �� �ܾ �����ϴ� Ŭ����
		 * - �ܾ�
		 * - ��1, ��2, ...
		 */
		// ��� ����
		private String title;
		private String meaning[];
		private int meaningCount; // ���� ����� ����, � ����ƴ���(�ݺ������� ������ �ʾƵ���)
		
		// ������
		public Word(String title, String meaning) {
			this.title = title;
			this.meaning = new String[5]; // �ִ� 5�� ���� ����
			this.meaning[0] = meaning;
			meaningCount++;
		}
		
		// ������ �����ε�
		public Word(String title) {
			this.title = title; //�ϴ� �ܾ �߰��ϰ�, ���� ���߿� �Է��Ϸ��� �ϴ� ����
			this.meaning = new String[5]; // ���� �־��� �� �ִ� �迭�� ��������.
		}
		
		//* ���������
		public Word(Word w) { // �Ű������� ����Ŭ������ ��ü�� ���°�� = ���������
			this.title = w.title;
			this.meaning = new String[5];
			//this.meaning = w.meaning; // ��������, �����ؼ� ��¼����...
			for(int i = 0; i <w.meaningCount; i++) {
				meaning[i] = w.meaning[i];
			}
			meaningCount = w.meaningCount;
		}
		// �޼ҵ�
		/** ��� : �ܾ�� ���� ����ϴ� �޼ҵ�
		 * �Ű����� : ����?(������ ����̶� ���� ���� �˷��� �ʿ� ����.)(�ڱ� �ڽ��̶�????)
		 * ����Ÿ�� : (���) ���� => void
		 * �޼ҵ�� : print 
		 */
		
		public void print() {
			System.out.println("word : " + title);
			System.out.println("meaning : ");
			// �ǹ̴� ������! �ݺ���. 
//			for(int i = 0; i < meaning.length; i++) {
//				if(meaning[i] != null) {
			for(int i = 0; i < meaningCount; i++) {
					System.out.println(i + 1 + ". " + meaning[i]);
			}
		}
		
		/** ��� : ���� �߰��ϴ� �޼ҵ�
		 * �Ű����� : �߰��� �� => String meaning
		 * ����Ÿ�� : (����� ���� �ٲٴ°�)���� => void
		 * �޼ҵ�� : addMeaning
		 */
		public void addMeaning(String meaning) {
			//meaningCount ���� �߰�
			
			//���� �� á���� �� á�ٰ� ����ϰ� ����
			if(meaningCount == this.meaning.length) {// �迭�� ������ 5�� ������
				System.out.println("It's all filled");
				return; // �ؿ� �ڵ� ���� ����
			}
			this.meaning[meaningCount] = meaning;
			meaningCount++;
		}	
		
		/** ��� : ���� �����ϴ� �޼ҵ�
		 * �Ű����� : ������ ���� ��ȣ => int num
		 * ����Ÿ�� : (�˷��ִ�x, ��ȯ�ϴ�x) ���� => void
		 * �޼ҵ�� : removeMeaning
		 */
		
		public void removeMeaning(int num) {
			// num�� ������ �ƴ�. num - 1 = [����]
			if(num > meaningCount || num < 1) {
				System.out.println("I can't work.");
				return; // �ؿ� �۾��� ���� �ʵ��� ��������
				// return�� ���� ������, else {} �� ���;���. 
				// return;�� �����ϰ� �� Ȱ���ϸ�, �������� ����� �ڵ尡 ȿ�������� �۾��� �� �ִ�.
				}
				// num -1 �������� �ϳ��� ��ܿͼ� ä���ش�. �����.
				for(int i = num -1; i < meaningCount -1; i++) {
					meaning[i] = meaning[i+1]; //��ĭ�� ���ܿ�
				}
				// �������� ������� �����͸� ����
				//meaning[meaningCount-1] = null; // �ص��ǰ� ���ص���. 
				// ���� ������ �� ������ �ϳ� ����
				meaningCount--;
			}
			
		}
}
