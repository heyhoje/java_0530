package day9._06_classEx;

public class CarMain {

	public static void main(String[] args) {
		/* car				// �ڵ���
		 * String name;		// ����
		 * String company;  // ������
		 * int year 		// ����
		 * 
		 * int speed;		// �ӷ�
		 * char gear;		// P:����, R:����, D:����, N:�߸�
		 * boolean power	// ����
		 * */
		
		/*���� �� �ƹݶ� 2023��� �ڵ��� ��ü�� �����ϴ� �ڵ带 �ۼ��ϼ���
		 * */
		
		//Ŭ������ ��ü�� = new Ŭ������(�Ű�������)
		Car myCar = new Car("�� �ƹݶ�", "����", 2023);
		
//		String name = "�� �ƹݶ�";
//		String company = "����"; 
//		int year = 2023;
		
		// System.out.println(company + name +" " + year + "���");
		
		// ���� �� �� ���� ��ȸ
		myCar.turn();
		myCar.setGear('D');
		myCar.printInfo();
		myCar.speedChange(false);
		myCar.speedChange(false);
		myCar.speedChange(false);
		myCar.printInfo();
		myCar.speedChange(true);
		myCar.speedChange(true);
		myCar.speedChange(true);
		myCar.printInfo();
		myCar.speedChange(false);
		myCar.printInfo();
	}

}
