package day24._16_thread;

import lombok.Data;

// 사용자가 통장을 가지고 있고, 통장에 만원을 입금
public class User extends Thread{ // 통장 클래스
	private Passbook pb; // 통장
	private String name; // 이름
	
	//private int balance; // 잔고
	
	public User(String name, Passbook pb) { // 생성자 하나 만듬
		this.name = name;
		this.pb = pb;
	}
	
	@Override
	public void run() {
		pb.deposit(name, 10000); // 누가, 얼마를 입급했는지
	}
}

@Data
class Passbook { // 클래스 하나 
	private int balance;
	
	// 예금 // +synchronized 동기화 작업. 동시 작업을 못하도록 막아줌
				// ㄴ 통장입금, 버스좌석 예매 등
	public synchronized void deposit(String name, int money) { 
		this.balance += money;
		
		try {
			Thread.sleep(2000); // 바로 입금하는게 아니라 잠시 지연, 대기하고 막는다
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // sleep을 왜 여기다 놓죠?????? 
		System.out.println(name + " : " + money);
		System.out.println("balance : " + this.balance);
	}
	
}

/*
// 출금
public int withdrawal(int money) {
	if(balance >= money) {
		balance -= money;
		return money;
	}
	return 0;
}

// 입금
public int deposit(int money) {
	this.balance =+ money;
	return balance;
} */