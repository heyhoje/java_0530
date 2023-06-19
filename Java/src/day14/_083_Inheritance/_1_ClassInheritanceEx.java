package day14._083_Inheritance;

import lombok.Data;

public class _1_ClassInheritanceEx {

	public static void main(String[] args) {
		/* ����Ʈ���� ���̴�. => ���
		 * - ����Ʈ�� : �ڽ� Ŭ����
		 * - �� : �θ� Ŭ����
		 * ����Ʈ���� ī�޶� ������ �ִ�. => ����
		 * - ����Ʈ�� : Ŭ����
		 * - ī�޶� : �������
		 * 
		 * �θ� Ŭ�������� ��� ���� ��ɵ��� ����� �� �ִ�.
		 * - ���������ڰ� public, protected�� ���
		 * - ����Ʈ�� ���� ��Ű���� ���� �����ϳ� �ٸ� ��Ű���̸� �Ұ���
		 * */
		
		
		// ����Ʈ ���̶�� Ŭ������ call, answer ��� x, ��ӹ޾� ��
		SmartPhone phone1 = new SmartPhone();
		phone1.call("010-1234-5678");
		phone1.answer("02-123-4567");
		//System.out.println(phone1.getNum);
		phone1.take();
		
		System.out.println("--------");
		
		//�ٿ� ĳ���� : �ȵǴ� ���
		Phone p1 = new Phone("010-123-3456");
		//���������� ������ �߻����� ������ ���ܰ� �߻� : �ٿ�ĳ������ �ȵǴ� ����̱� ����
		if(p1 instanceof SmartPhone) {
			SmartPhone c1 = (SmartPhone) p1;
			c1.call("������ȣ");
		}
		
		// �ٿ� ĳ���� : �Ǵ� ���(�켱 �� ĳ������ ���� �Ǿ���)
		// ��ĳ������ ������ ��ü p2
		Phone p2 = new SmartPhone(); // ��ĳ����
		SmartPhone c2 = (SmartPhone)p2; // �ٿ�ĳ����
		c2.call("123-4567");
	}

}

@Data
class Phone {
	protected String num = "010-1111-4444"; // ��ȭ��ȣ
	
	// ��ȭ �ɱ� ���
	public void call(String num) {
		System.out.println(num); // ���� ��ȭ�� �Ŵ� ���� ��ȣ
		System.out.println("Calling....");
		
		
	}
	
	// ��ȭ �ޱ�
	public void answer(String num) {
		System.out.println(num); // ������ ��ȭ�� �� ���� ��ȣ
		System.out.println("Answering...");
	}	
	
	public Phone(String num) {
		this.num = num;
	} 
	// public Phone (){} // �����ڰ� �ϳ��� ������ ������ �Ҷ� �⺻ �����ڰ� �ڵ����� �߰�
}

@Data
class SmartPhone extends Phone{
	Camera camera = new Camera(); // (has a) ���԰���, ����Ʈ���� ī�޶� ������ �ִ�.	
	public void take() {
		camera.take();
	}
	
	// �������̵�
	public void call(String num) {
//		System.out.println(num); // ���� ��ȭ�� �Ŵ� ���� ��ȣ
//		System.out.println("SmartPhone Calling....");
		super.call(num);
		System.out.println("SmartPhone!");
	}
	
	// �޼ҵ� �����ε���
	public void answer(String num1, String num2) {
		System.out.println(num); // ������ ��ȭ�� �� ���� ��ȣ
		System.out.println("SmartPhone Answering...");
	}
	
	public SmartPhone() {
		//�θ� Ŭ������ �����ڰ� ȣ��
		
		// super()�� �̿��Ͽ� �θ� Ŭ������ �����ڸ� ���� ȣ������ ������
		// �⺻ �������� super()�� �ڵ����� �߰��� �ǰ� ȣ���� ��
		// �� ��, �θ�Ŭ������ �⺻ �����ڰ� ������ ������ �߻�     .....?���ؾȵʤ�����
		// super(); // ���� �߻�
		super("");
	}
}


class Camera {
	public void take() {
		System.out.println("take a picture!");
	}
	
}