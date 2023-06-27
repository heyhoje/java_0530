package day17.practice.controller;

// 230622 영상복습 꼭봐라....ㅂㄷㅂㄷ
// shopService가 뭔가 안되서, 그 뒤에 메소드가 자동추가 Override 안되고 수기 추가함....
//230627 다보고 다 채웠다리

import java.util.Scanner;

import day17._10_interfaceEx.RunInterface;
import day17.practice.service.ShopService;
import day17.practice.service.ShopServiceImp;

// 15 >> 17로 ctrl+shift_o 해서 바꿈

import day17.practice.vo.Customer;
import day17.practice.vo.Product;
import day17.practice.vo.Sales;

public class ShopController implements RunInterface {
	
	private Scanner sc = new Scanner(System.in); // 스캐너를 멤버로 가지고 있으면 매번 생성하지 않아도됨
	private Product list[] = new Product[10]; // 제품 리스트
	private int count = 0; // 저장된 제품 개수
	
	private Customer customerList[] = new Customer[10]; // 최대 10명의 고객 관리
	private int customerCount = 0; //저장된 고객 수
	
	private Sales salesHistory[] = new Sales[100]; // 판매 기록
	private int salesCount; // 기록된 판매수
	
	private ShopService shopService= new ShopServiceImp(); // 방금 만든 service 하나 추가! 
	// <- import하니까 shopService.메소드() 오류건 사라짐
	// 그러고나서 override 안됐던 메소드들이 다 오류로 떠오름
	
	
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
			case 1: // [제품 판매]
				// 제픔명 입력
				System.out.print("제품명 : ");
				sc.nextLine();
				String name = sc.nextLine();
				
				// 제품 개수 입력
				System.out.print("수량 : ");
				int amount = sc.nextInt();
				
				// 고객 정보(전화번호) 입력
				System.out.print("번호 : ");
				String phoneNumber = sc.next();
				
				int salesCount = shopService.sell(
						list, count, // 제품 리스트 정보
						customerList, customerCount, // 고객 리스트 정보
						salesHistory, this.salesCount, // 판매 내역 정보
						// 기본 정보들을 관리하기 위해 필요한 것들
						name, amount, phoneNumber // 실제 제품 판매정보를 확인하기 위해 필요
					);
				if(salesCount == -1) {
					System.out.println("제품 판매 실패!");
				}else {
					System.out.println("제품 판매 성공!");
					this.salesCount = salesCount;
				}
				break;
				
			case 2: // [입고  관리]
				// 입고할 제품 정보를 입력받아 제품 객체로 생성하는 코드 작성
				Product product = inputStoreProduct();
				// 제품 리스트와 제품 수, 입고된 제품을 주고, 제품 입고를 관리하라고 시킴
				// 리턴값을 왜 count에 저장해야할까요?
				// (새 제품이 입고된 경우 제품 리스트에 추가되고, 제품수가 1증가 해야하기 때문)
				count = shopService.store(list, count, product);
				// list; // 바뀜(참조변수는 주소를 공유. 안에서 내용이 바뀌면 밖에도 바뀔 수 있음)
				// count; // 기본자료형은 밖에선 안바뀜(), 그래서 return값을 알려줘야함
				break;
				
			case 3: // [제품 조회]
				// 제품명을 입력
				System.out.print("제품명 : ");
				sc.nextLine();
				String search = sc.nextLine();
				
				// 제품을 검색해서 출력
				shopService.printProduct(list, count, search);
				break;
				
			case 4: // [매출 조회]
				shopService.printSales(salesHistory, this.salesCount); //왜 얘만 또 this 붙여????
				break;
				
			case 5: // [고객 등록]
				// 고객 정보를 입력을 받아 고객 객체로 생성 추가하고, 
				Customer customer = inputRegisterCustomer();
				
				// 고객 리스트, 고객수, 등록된 고객정보를 주고 관리하라고 시킴. 추가함.
				int Count = shopService.registerCustomer(customerList, customerCount, customer);
				if(count == -1) {
					System.out.println("고객 등록 실패!");
				}else {
					System.out.println("고객 등록 성공!");
					customerCount = count;
				}
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");

			}
		}
		
//		System.out.println("-----메소드 재정렬-----");
		
		// 메소드1 : 입고(제품명, 수량, 가격, 분류)
		private Product inputStoreProduct() {// store > inputStoreProduct, 리턴타입 Product
			// 입고할 제품명 입력
			System.out.print("제품명 : ");
			sc.nextLine(); // *
			String name = sc.nextLine();
				// 입고할 제품 수량
			System.out.println("수량 : ");
			int amount = sc.nextInt();
			
			if(amount < 0) { // 예외처리, 안정적으로 하기위해
				System.out.println("입고 수량 오류!");
				return null; // 객체가 없음 null > 뭔가 잘못됐다!!는 뜻
			}
			
			int index = indexOf(name);
		
			if(index != -1) { // 기존정보가 있음
				Product product = new Product(list[index]);
				product.setAmount(amount); // 기존정보 가져오고 수량만 바꿈
				// new Product(name, "", 0, amount, "");
				// 복사생성자 말고, 매개변수 긴 Product로 가져옴
				// (모델이름, 가격, 카테고리이름 알필요없음/이름과 수량만)
				return product;
			}
					
			if(count == list.length) { // 리스트가 다 차면, 
				System.out.println("제품 리스트 다참");
				return null;
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
				// 직접 입고 -> '입고에 필요한 정보'만 받아서 '제품으로 하나' 만들어줌.
			
			Product product = new Product(name, modelName, price,
					amount, category);
			
			return product;
		}
		
		// 메소드4 : 고객 정보를 입력받아 객체로 전달?
		private Customer inputRegisterCustomer() {
			// 고객 정보(이름, 전화번호)를 입력
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.println("번호 : ");
			String phoneNumber = sc.next();
			
			return new Customer(name, phoneNumber);
			// 아래 두줄을 줄여 쓴것이 위이다!
//			Customer customer = new Customer(name, phoneNumber);
//			return customer; 
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
		
		// 메소드3 : 제품 판매 기능(제품명, 재고count)
		// 메소드4 : 새 제품 추가/입고(count++)
		// 메소드5 : 제품 정보 조회(제품명, 가격, 재고)
		// 메소드6 : 판매 매출 조회(가격 * 판매량)
		// 메소드7 : 고객 추가 및 관리(고객명, 전화번호, 주소, 적립된 포인트 등)

}
