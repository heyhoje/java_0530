package day9._06_classEx;

public class Car {
	// ��� ����(�ʵ�)
	 private String name;		// ����
	 private String company;  // ������
	 private int year; 		// ����
	 
	 private int speed;		// �ӷ�
	 private char gear;		// P:����, R:����, D:����, N:�߸�
	 private boolean power;		// ����
	 
	// (������� �ʱ�ȭ�ϴ�)������
	 public Car(String _name, String _company, int _year) {
		name = _name;
		company = _company;
		year = _year;
		gear = 'p';
	 
		// power = false;
		// speed = 0; �⺻������ �ʱ�ȭ ������
		
		//������� �Ķ�, �Ű����� ����
		//Ŭ���� = ������� + �޼ҵ�
	 }
	// �޼ҵ� (����߰�)
		/** �ڵ��� ������ ����ϴ� �޼ҵ�
		 * �Ű����� : ���� (�� ������ ���� �� ��)
		 // ��������� �̹� �˰��־, �˷��� �ʿ� ����...(�̸�, ������, ����, �ӷ�, ������, �������� => String, int, char, boolean)
		 * ����Ÿ�� : ����? => void
		 * �޼���� : printInfo
		 */
		//�ֿܼ� �ԷµǴ� ������ ����Ÿ���� ���ٰ� ���� �ȴ�. 
		
		//public ����Ÿ�� �޼ҵ��(�Ű�����)
	public void printInfo() {
		System.out.println("�ڵ��� ��ȸ");
		System.out.println("������ : " + company);
		System.out.println("�� : " + name);
		System.out.println("���� : " + year);
		System.out.println("���� : " + (power?"On":"Off"));
		System.out.println("��� : " + gear);
		System.out.println("�ӷ� : " + speed);
		System.out.println("---------");
		}
		/** �ӷ��� <1 ���� �Ǵ� 1 ����>�ϴ� �޼ҵ�
		 * �Ű����� : �����Ұ���(��) �ƴϸ� ���ҽ���(����) => boolean positive
		 * ����Ÿ�� : ���� (int�� �����ϱ� �˷��� �ʿ� ����)
		 * �޼ҵ�� : speedChange
		 */
		
	public void speedChange(boolean positive) {
			
		// ������ ���������� ����
		if (!power) {
			return;
		}
		// �� �߸� �Ǵ� �������̸� ����
		if (gear == 'N'||gear == 'P') {
			return;
		}
		// �ӷ��� �����ϴ� ����̸�, �ӷ��� �����ϸ�
		if (positive) {
			speed += 1;
			// ������ �ƴϸ�, (�����ϴ°� �ƴϰ�) �����ϴ� ����̰� �ӷ��� 0���� ũ�� 
		}else if(speed > 0){
			speed -=1;
		}
	}	
	/** �ڵ��� �õ��� �Ѱų� ���� �޼ҵ�
	 * �Ű����� : �� ����.. (power�� �Ѱų� power�� ���ų�)
	 * ����Ÿ�� : ����
	 * �޼ҵ�� : powerOn
	 */
	public void turn() {
		if(!power) {
			power = true;
		}else if(gear == 'P') {
			power = false;
		}
	}
	
	public void setGear(char gear) {
		this.gear = gear;
	}
	
	 
	 
	 
}
