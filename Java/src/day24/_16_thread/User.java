package day24._16_thread;

import lombok.Data;

// ����ڰ� ������ ������ �ְ�, ���忡 ������ �Ա�
public class User extends Thread{ // ���� Ŭ����
	private Passbook pb; // ����
	private String name; // �̸�
	
	//private int balance; // �ܰ�
	
	public User(String name, Passbook pb) { // ������ �ϳ� ����
		this.name = name;
		this.pb = pb;
	}
	
	@Override
	public void run() {
		pb.deposit(name, 10000); // ����, �󸶸� �Ա��ߴ���
	}
}

@Data
class Passbook { // Ŭ���� �ϳ� 
	private int balance;
	
	// ���� // +synchronized ����ȭ �۾�. ���� �۾��� ���ϵ��� ������
				// �� �����Ա�, �����¼� ���� ��
	public synchronized void deposit(String name, int money) { 
		this.balance += money;
		
		try {
			Thread.sleep(2000); // �ٷ� �Ա��ϴ°� �ƴ϶� ��� ����, ����ϰ� ���´�
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // sleep�� �� ����� ����?????? 
		System.out.println(name + " : " + money);
		System.out.println("balance : " + this.balance);
	}
	
}

/*
// ���
public int withdrawal(int money) {
	if(balance >= money) {
		balance -= money;
		return money;
	}
	return 0;
}

// �Ա�
public int deposit(int money) {
	this.balance =+ money;
	return balance;
} */