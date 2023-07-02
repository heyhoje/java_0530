package review_0630.machine.controller;

import java.util.Scanner;

import review_0630.machine.vo.Beverage;

public class BeverageMachine {

	int menu;
	private Scanner sc = new Scanner(System.in);
	private Beverage list[] = new Beverage[3]; // vo.Beverage
	
	private int money; // 자판기에 있는 금액
	
	private final static int COKE = 0;
	private final static int SPRITE = 1;
	private final static int FANTA = 2;
	private final static int EXIT = 4;
	
	// 음료자판기 배열에 대해 합의한적 있나? 그 매개변수있는 생성자 선언하는 부분이 없어도 되는건가?
	public BeverageMachine() {
		list[COKE] = new Beverage("콜라", 1200, 10);
		list[SPRITE] = new Beverage("사이다", 1100, 10);
		list[FANTA] = new Beverage("환타", 1000, 10);
	}
	
	
	public void printMenu() {
		System.out.println("-----------");
		System.out.println("메뉴");
		System.out.println("1. 금액 투입");
		System.out.println("2. 메뉴 선택");
		System.out.println("3. 제품 입고");
		System.out.println("4. 프로그램 종료");
		System.out.println("메뉴 선택 : ");
		System.out.println("-----------");

	}
	
	public void run() {
		int menu;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
	}
	
	public void runMenu(int menu) {
		switch(menu) {
		case 1: // 금액 투입
			insertCoin();
			break;
		case 2: // 메뉴 선택 - 음료 선택
			selectBeverage();
			break;
		case 3: // 제품 입고
			insertBeverage();
			break;
		case 4:  // EXIT
			System.out.println("프로그램을 종료합니다.");
			break;
		default: 
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	
	/** 기능 : 돈을 투입한다
	 * 매개변수 : 왜 없는지 모르겠다
	 * 리턴타입 : 돈을 넣고 금액이 얼마인지 알려줌(출력) => void */
	private void insertCoin() {
		System.out.print("금액 투입 : ");
		int money = sc.nextInt();
		this.money += money;
		System.out.println("현재 금액 : " + this.money);
		System.out.println();
		System.out.println("메뉴2를 눌러 음료를 선택하세요!");
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	/** 기능 : 진짜 음료수 고르기 타임
	 * 매개변수 : 숫자입력
	 * 리턴타입 : 입력한거중에 선택됨 -> void */
	private void selectBeverage() {
		System.out.println("1. 콜라");
		System.out.println("2. 사이다");
		System.out.println("3. 환타");
		System.out.print("음료 선택 : ");
		
		int selectBeverage = sc.nextInt() -1; // 왜?? 지???? 아 맞다맞다 번지수 찾기
		// int index = indexOf(title) <- 영어단어장에서 뭔가 참고할게 있을 것 같았지만 없었음
		
		switch(selectBeverage) {
		case COKE:
		case SPRITE:
		case FANTA:
			// 왜 나오는지 모르겠지만 generate가 나옴
			generate(selectBeverage); // 없다고 에러뜨니까 또 메소드 만들러 가줘야함
			//System.out.println("음료가 나왔습니다");
			break;
		default: 
			System.out.println("잘못 선택했습니다.");
			return;
		}
		// ++뭐가 나왔습니다. 알려주고 싶은데, generate랑 break;가 case3 밑에 있어서 다 출력되버려
	}
	
	/** 기능 : 총괄같기도? 전체적으로 발생하는 흐름? - 무슨뜻으로 generate를 쓴건지 모르겠음
	 * 매개변수 : beverage <- 왜 내가 고른 음료수sB도 아니고 beverage로 간걸까? 그냥 매개변수명 통일된건가?
	 * 리턴타입 : 입력한거따라 출력하고, 계산하고 끝 => void */
	private void generate(int beverage) {
		int amount = list[beverage].getAmount();
		if(amount < 0) {
			System.out.println("죄송합니다 재고가 없습니다");
			return;
		}
		
		int money = list[beverage].getPrice();
		if(this.money < money) {
			System.out.println("금액이 부족합니다.");
			return;
		}
		
		list[beverage].setAmount(amount -1);
		this.money -= money;
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	/** 기능 : 음료수재고와 수량을 확인한다?
	 * 매개변수 : 이것도 숫자를 직접 입력하기 때문에 매개변수가 없나?
	 * 리턴타입 : 입력하고 출력 => void */
	private void insertBeverage() {
		System.out.println("1. 콜라");
		System.out.println("2. 사이다");
		System.out.println("3. 환타");
		System.out.print("음료 선택 : ");
		
		int selectBeverage = sc.nextInt() -1; // 인덱스번지를 찾아가려고 -1 한건가?
		System.out.print("수량 : "); // 뽑을 개수 말하는 거겠지? 넣을 개수인건가??
		int amount = sc.nextInt();
		
		switch(selectBeverage) {
		case COKE:
		case SPRITE:
		case FANTA:
			// 콜라, 사이다, 환타의 재고를 확인하러 간다. 
			store(selectBeverage, amount);
			break;
		default: 
			System.out.println("잘못 선택했습니다.");
			return;
		}
		// 개수가 있는지 확인해야 음료수를 줄 수 있어서 store(고른음료수, 재고량) 을 확인하러 가는걸까?
	}
	
	/** 기능 : 재고를 더한다
	 * 매개변수 : 음료수번호, 음료수 양 => 
	 * 리턴타입 : 안에서 계산하고 끝나서 void? */
	private void store(int selectBeverage, int amount) {
		if(amount < 0) {
			System.out.println("수량 오류");
			return;
		}
		int remainAmount = list[selectBeverage].getAmount();
		list[selectBeverage].setAmount(remainAmount+amount);
		System.out.println("입고 완료!");
		
		// ++무엇이 몇개 입고 되었다. 라고 알려줄 수는 없나? 
	}
	
	

}
