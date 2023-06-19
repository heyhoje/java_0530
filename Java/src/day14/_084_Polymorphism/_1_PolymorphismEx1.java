package day14._084_Polymorphism;

// ���� ���� �ٽ� ä����^^

public class _1_PolymorphismEx1 {

	public static void main(String[] args) {
		/* �Ű������� ������
		 * ���������� ���� ��ǰ�� ������ �Ѵ� ����
		 * ��ǰ : TV, ������, ���� ��
		 * ����� �ϱ� ���� �ʿ��� �� = ������ Ŭ����, TV Ŭ����, ������ Ŭ����, ���� Ŭ����*/
		
		TV tv1 = new TV();
		Radio radio1 = new Radio();
		AirConditioner aircon1 = new AirConditioner();
		RemoteControl remocon1 = new RemoteControl();
		remocon1.turnOn(tv1); // TV�� �Ѵ� ���
		remocon1.turnOn(aircon1); // �������� �Ѵ� ���
		remocon1.turnOn(radio1); // ������ �Ѵ� ���
		
		System.out.println("---------");
		// �Ű����� �������� �̿�
		TV1 tv2 = new TV1();
		Radio1 radio2 = new Radio1();
		AirConditioner1 aircon2 = new AirConditioner1();
		RemoteControl1 remocon2 = new RemoteControl1();
		
		HomeAppliances appliance = tv2; // ��ĳ���� �ڽ� -> �θ�Ŭ���� ��ü��?(�ڵ�)
		remocon2.turnOn(appliance);
		remocon2.turnOn(tv2); // ������ �Ѵ� ���
		remocon2.turnOn(aircon2); // ������ �Ѵ� ���
		remocon2.turnOn(radio2); // ������ �Ѵ� ��� 
	}

}

class RemoteControl{
	public void turnOn(TV tv) {
		tv.turnOn();
		System.out.println("������ �������ϴ�.");
	}
	public void turnOn(AirConditioner aircon) {
		aircon.turnOn();
		System.out.println("������ �������ϴ�.");
	}
	public void turnOn(Radio radio) {
		radio.turnOn();
		System.out.println("������ �������ϴ�.");
	}
}

class TV {
	boolean power;
	int channel;
	void turnOn() {
		power = true;
	}
}

class AirConditioner {
	boolean power;
	double currentTemperature;
	double desiredTemperature;
	void turnOn() {
		power = true;
	}
}


class Radio {
	boolean power;
	double frequency;
	void turnOn() {
		power = true;
	}
}

class HomeAppliances{
	boolean power;
	void turnOn() {
		power = true;
	}
	void turnOff(){
		power = false;
	}
}

class RemoteControl1 {
	public void turnOn(HomeAppliances appliance) {
		appliance.turnOn();
		System.out.println("������ �������ϴ�.");
	}
	
	public void turnOff(HomeAppliances appliance) {
		appliance.turnOff();
		System.out.println("������ Rj�����ϴ�.");
	}
}

class TV1 extends HomeAppliances {
	int channel;
	}

class AirConditioner1 extends HomeAppliances {
	double currentTemperature;
	double desiredTemperature;
}

class Radio1 extends HomeAppliances {
	double frequency;
	}


