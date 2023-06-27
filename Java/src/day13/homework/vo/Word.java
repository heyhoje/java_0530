package day13.homework.vo;

import lombok.Data;

// �� ���ƴ� ����� ��������ڸ� ������µ� ���ڱ� class word�� �Ѿ���ֳ�
@Data // getter, setter, toString equals�� �ڵ� �߰�

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
				this.meaning[i] = w.meaning[i];
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
		
		/** ��� : ���� ������'�� ���ſ��θ� �˷��ִ�' �޼ҵ�
		 * �Ű����� : ������ ���� ��ȣ => int num
		 * ����Ÿ�� : ���ſ��� => boolean
		 * �޼ҵ�� : removeMeaning
		 */
		
		public boolean removeMeaning(int num) {
			// num�� ������ �ƴ�. num - 1 = [����]
			if(num > meaningCount || num < 1) {
				//System.out.println("I can't work.");
				return false; // �ؿ� �۾��� ���� �ʵ��� ��������
				// return�� ���� ������, else {} �� ���;���. 
				// return;�� �����ϰ� �� Ȱ���ϸ�, �������� ����� �ڵ尡 ȿ�������� �۾��� �� �ִ�.
				}
				
				// num -1 �������� �ϳ��� ��ܿͼ� ä���ش�. �����.
				for(int i = num -1; i < meaningCount -1; i++) {
					meaning[i] = meaning[i+1]; //��ĭ�� ���ܿ�
				}
			
				// �������� ������� �����͸� ����
				meaning[meaningCount-1] = null; // �ص��ǰ� ���ص���. 
				// ���� ������ �� ������ �ϳ� ����
				meaningCount--;
				return true;
		}
		
		/** ��� : ������ ���� ��ȣ�� ������ ���� �־����� ���� �����ϰ�, ���� ���θ� �˷��ִ� �޼ҵ�
		 * �Ű����� : ������ ���� ��ȣ, ������ �� => int meaningNum, String meaning
		 * ����Ÿ�� : �����ߴ��� ���ߴ��� => boolean
		 * �޼ҵ�� : updateMeanting
		 * @param meaningIndex
		 * @param meaning2
		 * @return
		 */
		public boolean updateMeaning(int meaningNum, String meaning) {
			// ������ ���� ��ȣ�� �߸��� ���(1,2 �ε�, 0, -1, 3 ���� ����)
			if(meaningNum > meaningCount || meaningNum <= 0) {
				return false;
			}
			// meaningNum�� 1�����̰�, ������ 0�����̱� ������ -1�� �Ѵ�
			this.meaning[meaningNum - 1] = meaning;
			return true; // ���� �Ϸ� �Ŀ��� true!
		}

		// title�� getter&setter ����
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}	
			
}

