package day15.practice.shop.controller;

import java.util.Scanner;

import day15.practice.shop.vo.Customer;
import day15.practice.shop.vo.Product; //import안해서. product랑 list[] 에러 떴었음
import day15.practice.shop.vo.Sales;
import day17._10_interfaceEx.RunInterface;

public class ShopManager implements RunInterface{
	
	private Scanner sc = new Scanner(System.in); // 스캐너를 멤버로 가지고 있으면 매번 생성하지 않아도됨
	private Product list[] = new Product[10]; // 제품 리스트
	private int count = 0; // 저장된 제품 개수
	
	private Customer customerList[] = new Customer[10]; // 최대 10명의 고객 관리
	private int customerCount = 0; //저장된 고객 수
	
	private Sales salesHistory[] = new Sales[100]; // 판매 기록
	private int salesCount; // 기록된 판매수
	private int totalPrice;
	
	
	public void run () {
		// 멤버변수 / 기능 
		System.out.println("프로그램을 시작!!");
		
		int menu = -1;
		final int EXIT = 6;
		// 반복 : 선택한 메뉴가 종료가 아닐때까지 & 반드시 한번은 실행됨
		do {// 1. 메뉴 출력
			printMenu();
			
			// 2. 메뉴 선택
			menu = sc.nextInt();
			
			// 3. 메뉴에 따른 기능 실행
			runMenu(menu);
				
		}while(menu != EXIT);
		
		System.out.println("프로그램 종료!!");
		
		sc.close();
	}
	
	// 메소드1 : 메인메뉴 출력
		/** 기능 : 메뉴를 출력하는 메소드
		 * 메소드명 : printMenu
		 */
		private void printMenu() {
			System.out.println("----------");
			System.out.println("메뉴입니다");
			System.out.println("1. 제품 판매");
			System.out.println("2. 제품 입고");
			System.out.println("3. 제품 조회");
			System.out.println("4. 매출 조회");
			System.out.println("5. 고객 등록");
			System.out.println("6. 프로그램 종료");
			System.out.println("----------");
			System.out.print("메뉴를 선택하세요 : ");
		}
			
		// 메소드2 : 메뉴 기능 실행
		/** 기능 : 메뉴에 따른 기능을 실행하는 메소드
		 * 매개변수 : 메뉴 => int menu
		 * 리턴타입 : (안에서 실행) 없음 => void
		 * 메소드명 : runMenu
		 */
		private void runMenu(int menu) {
			// sysout("menu+선택")
			switch(menu) {
			case 1: 
				// '어떤 고객'이 '어떤 제품'을 구매했는지 관리
				// System.out.println("제품 판매 기능");
				sell();
				break;
			case 2: 
				// 새 제품이 추가됨. '어떤 제품'이 '몇개 추가'되었는지 관리
				//System.out.println("새 제품 추가/입고");
				store();
				break;
			case 3:
				//제품 정보 조회. '제품명'으로 제품을 조회
				//System.out.println("제품 정보 조회");
				printProduct();
				break;
			case 4: 
				// '판매된 제품' '매출' 조회. 누적 매출
				//System.out.println("판매 매출 조회");
				printSales();
				break;
				
			case 5:
				// 고객을 추가하여 고객 관리
				System.out.println("고객 추가 및 관리");
				registerCustomer();
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");

			}
		}
		
		// 메소드4 : 고객등록
		private void registerCustomer() {
			// 고객 정보(이름, 전화번호)를 입력
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.println("번호 : ");
			String phoneNumber = sc.next();
			
			// (고객 리스트에) 고객을 등록
			// 이미 등록된 전화번호이면 등록x
			for (int i = 0; i < customerCount; i++) {
				// customerList[i] : 고객 리스트에서 i번지에 있는 고객 정보
				// customerList[i].getPhoneNumber() : i번지 고객의 전화번호
				// i번지 고객의 전화번호와 등록하려는 고객의 전화번호가 같으면 등록 실패
				if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
					System.out.println("등록된 번호! 고객 등록 실패!");
					return;
				}
			}
			// 새 전화번호이면 등록
			// 입력받은 고객 정보를 이용하여 고개 객체를 생성한 후, 마지막 고객 다음에 새 고객을 추가
			// 등록된 고객의 수를 증가
			customerList[customerCount] = new Customer(name, phoneNumber);
			customerCount++;
		}
			
		private void printSales() {
			// 매출 내역 출력
			for(int i = 0; i < salesCount; i++) {
				salesHistory[i].print();
			}
			
			// 누적 매출액 출력
			System.out.println("누적 매출액 : " + totalPrice);
		}
		
		// 메소드5 : 제품 조회
		private void printProduct() {
			//검색할 제품을 입력
			System.out.println("제품명 : ");
			sc.nextLine(); // 엔터. 이전 입력에서 엔터를 쳤기 때문에 엔터 제거
			String name = sc.nextLine();
			
			// 입력한 검색어와 맞는 제품을 출력
			int index = indexOf(name);// 등록된 제품들 중에 검색어와 일치하는 제품이 어디있는지 확인

			// 제품이 있으면 제품 정보를 출력
			if(index >= 0) {
				list[index].print();
				return;
			}
			// 없으면 없는 제품이라고 출력
			System.out.println("없는 제품!");
		}

		// 메소드3 : 입고(제품명, 수량, 가격, 분류)
		private void store() {
			// 입고할 제품명 입력
			System.out.print("제품명 : ");
			sc.nextLine(); // *
			String name = sc.nextLine();

			// 입고할 제품 수량
			System.out.println("수량 : ");
			int amount = sc.nextInt();
			
			if(amount < 0) { // 예외처리, 안정적으로 하기위해
				System.out.println("입고 수량 오류!");
				return;
			}
			
			// 제품 리스트에서 입고할 제품명이 있는지 찾기
			// 제품 배열에 있는 제품명과 입고할 제품명이 같은지 확인해서
			// 같으면 위치를 기억(몇번지에 있는지)
			int index = indexOf(name);
			
			// 있으면, 입고할 제품 수량만큼 해당 제품에 입고
			// (위치가 0이상이면)
			if(index != -1) {
				list[index].store(amount);
				System.out.println("입고 완료");
				return;
			}
			// 없으면, 제품리스트에 제품 정보를 추가(입고할 수량도 함께)
			// (위치가 -1이면)
			// 최대치로 등록되어 있으면
			if(count == list.length) {
				System.out.println("제품 리스트 다참");
				return;
			}
			
			// 모델명 입력
			System.out.println("새 제품 등록");
			System.out.println("모델명 : ");
			sc.nextLine(); //* nextLine 공백 처리하려고
			String modelName = sc.nextLine();
			// 가격을 입력
			System.out.println("가격 : ");
			int price = sc.nextInt();
			// 분류 입력
			System.out.println("분류 : ");
			String category = sc.next();

			// 제품 리스트에 추가
			list[count++] = new Product(name, modelName, price, amount, category);
			System.out.println("제품 추가 후 입고 완료!");
		}

		// 메소드 3.5 : 제품 위치 찾기
		/** 기능 : 제품 리스트에 제품명과 일치하는 제품이 있으면 번지를 없으면 -1을 알려주는 메소드
		 * 매개변수 : 제품명 => String name
		 * 리턴타입 : 제품이 있는 번지나 -1 => 정수 => int
		 * 메소드명 : indexOf
		 */
		public int indexOf(String name) {
			for(int i = 0; i < count; i++) {
				if(list[i].getName().equals(name)){
					// 제품 정보에서 i정보, 이름을 가져와서 둘이 비교???
					return i;
				} 
			}
			return -1;
		}
		
		private void sell() {
			// 제픔명 입력
			System.out.print("제품명 : ");
			sc.nextLine();
			String name = sc.nextLine();
			
			// 제품 개수 입력
			System.out.print("수량 : ");
			int amount = sc.nextInt();
			
			// 고객 정보 입력
			System.out.print("번호 : ");
			String phoneNumber = sc.next();
			
			// 있는 제품인지 확인
			int index = indexOf(name);
			if (index < 0) {
				System.out.println("제품명 오류!");
				return;
			}
			if (amount <= 0) {
				System.out.println("제품 수량 오류!");
				return;
			}
			
			// 있는 고객인지 확인
			int customerIndex = indexOfCustomer(phoneNumber);
			if(customerIndex < 0) {
				System.out.println("전화번호 오류!");
				return;
			}
			
			// 판매 내역에 추가
			// 제품 정보
			// 복사 생성자를 이용해서 제품 정보를 복사(깊은 복사)
			Product product = new Product(list[index]);
			product.setAmount(amount);
			
			// 고객 정보
			Customer customer = customerList[customerIndex];
			
			Sales sales = new Sales(customer, product);
			salesHistory[salesCount++] = sales; 
			
			// 판매된 개수만큼 재고량에서 뺴줘야함
			list[index].release(amount);
			
			// 매출 금액을 추가
			totalPrice += sales.getTotalPrice();
		}
		
		
		
		private int indexOfCustomer(String phoneNumber) {
			for (int i = 0; i < customerCount; i++) {
				// 고객의 번호가 같으면
				if(customerList[i].getPhoneNumber().equals(phoneNumber))
					return i;
			}
			return -1;
		}
		// 메소드3 : 제품 판매 기능(제품명, 재고count)
		// 메소드4 : 새 제품 추가/입고(count++)
		// 메소드5 : 제품 정보 조회(제품명, 가격, 재고)
		// 메소드6 : 판매 매출 조회(가격 * 판매량)
		// 메소드7 : 고객 추가 및 관리(고객명, 전화번호, 주소, 적립된 포인트 등)

}
