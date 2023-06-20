package day15._084_Polymorphism;

public class _2_InstancePorlymrphism {
	// ���� ������, ��ü ������ ����

	public static void main(String[] args) {
		/* TV 1��, ������ 2��, ���� 3�븦 ��ü�� ������ ��
		 * ������ �Ѵ� ����� �����غ�����*/
		
		RemoteControl remocon = new RemoteControl(); // �ּ� ���� ��� ���� ������
		
		// ���1
//		TV tv = new TV();
//		AirConditioner aircon1 = new AirConditioner();
//		AirConditioner aircon2 = new AirConditioner();
//		Radio radio1 = new Radio();
//		Radio radio2 = new Radio();
//		Radio radio3 = new Radio();
//		
//		remocon.turnOn(tv);
//		remocon.turnOn(aircon1);
//		remocon.turnOn(aircon2);
//		remocon.turnOn(radio1);
//		remocon.turnOn(radio2);
//		remocon.turnOn(radio3);
		
//		HomeAppliances homeAppliance = new HomeAppliances();
//		RemoteControl remocon = new RemoteControl();
		
		// ���2
		// ������ �ƴ�, �迭�� �̿��� �� 
//		TV tv = new TV();
//		AirConditioner aircons[] = new AirConditioner[2];
//		Radio radios[] = new Radio[3];
//		
//		
//		for(int i = 0; i < aircons.length; i++) {
//			aircons[i] = new AirConditioner();
//			
//		for(int i = 0; i < radions.length; i++) {
//			radios[i] = new Radio();
//		}
//		
//		remocon.turnOn(tv); // remocon�� �̿��ϴ� ���� '�Ű������� ������'
//		// ���� for��
//		for(AirConditioner aircon : aircons) { 
//			remocon.turnOn(aircon); //'�Ű������� ������'
//		}
//		for(Radio radio : radios) {
//			remocon.turnOn(radio); //'�Ű������� ������'
//		}
		
		// ���3
		// ���� ������ ����, ��ü ������ ����
		int tvCount = 1, airconCount = 2, radioCount = 3;
		int total = tvCount + airconCount + radioCount;
		HomeAppliances homeAppliances[] = new HomeAppliances[6];
		
		int count = 0; // ���� ������� ��ǰ ���
		int i = 0;
		// tv 1�� ����
		for(i = 0; i < tvCount; i++) {
			homeAppliances[count++] = new TV(); // ��ĳ����
			// �� - ������ǰ ���� / �� - tv �������
		}
		// aircon 2�� ����
		for(i = 0; i < airconCount; i++) {
			homeAppliances[count++] = new AirConditioner(); // ��ĳ����
		}
		// radio 3�� ����
		for(i = 0; i < radioCount; i++) {
			homeAppliances[count++] = new Radio(); // ��ĳ����
		}
		// ��� ��ǰ�� ������ �� 
		for(HomeAppliances homeAppliance : homeAppliances) { 
			remocon.turnOn(homeAppliance);
			// �迭 �ϳ��� ����
		}
		
		System.out.println("----������-----");
		// ��ü ��ǰ �� ������ ������ ��
		for(HomeAppliances homeAppliance : homeAppliances) { 
			// homeAppliance ��ü�� Radio Ŭ������ �ν��Ͻ� �����ΰ�?
			// HomeAppliance Ŭ������ŭ ���� �� >> Radio Ŭ���� ��ŭ���� ��ȯ �����Ѱ�?
			// [������ �ٿ�ĳ������ ������ ��ü�� ��]
			if(homeAppliance instanceof Radio) {
				remocon.turnOn(homeAppliance); // �ٿ�ĳ������ �ƴ�!!!(�θ�Ŭ������ ȣ���߱� ����)
				//System.out.println(homeAppliance.frequncy); // �θ�Ŭ������ �ִ� ����� �ƴ�
				Radio radio = (Radio)homeAppliance; //  �ٿ�ĳ����!!!(home >> Radio�� ����ȯ)
				System.out.println(radio.frequency);
				
				
			}
		}
		// System.out.println(radio.frequency); // radio���� ���ļ� ����� �ִµ� �� �̷��Դ� �ٷ� ����� �ȵ���???

	}
	// ��� ���䵵 �߿�������, ������ ������ ��¥ �߿��մϴ�. 
	// �Ű������� ������, ��ü �������� ���� 

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
class RemoteControl {
	public void turnOn(HomeAppliances appliance) {
		appliance.turnOn();
		System.out.println("������ �������ϴ�.");
	}
	
	public void turnOff(HomeAppliances appliance) {
		appliance.turnOff();
		System.out.println("������ �������ϴ�.");
	}
}

class TV extends HomeAppliances {
	int channel;
	}

class AirConditioner extends HomeAppliances {
	double currentTemperature;
	double desiredTemperature;
}

class Radio extends HomeAppliances {
	double frequency;
	}


