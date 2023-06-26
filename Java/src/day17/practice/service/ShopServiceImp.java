package day17.practice.service;

//230622 영상복습 꼭봐라....ㅂㄷㅂㄷ

import day17.practice.vo.Customer;
import day17.practice.vo.Product;

public class ShopServiceImp implements ShopService { // 서비스를 구현한 '구현클래스'

	

	public void printProduct(Product[] list, int count, String search) {
		if(list == null || search == null) {
			System.out.println("제품 정보가 없습니다.");
			return;
		}
		
		int index = indexOf(list, count, new Product(search));
		
		if(index == -1) {
			System.out.println("제품 정보가 없습니다.");
			return;
		}
		list[index].print();
	}
	
	public int registerCustomer(Customer[] list, int count, Customer customer){
		if(list == null 
			|| count < 0 
			|| customer == null 
			|| customer.getPhoneNumber == null
			|| list.length <= count) {
			return -1;
		}
		
		for(int i = 0; i < count; i++) {
			if(list[i].getPhoneNumber().equals(customer.getPhoneNumber())) {
				return -1;
			}
		}
		list[count] = new Customer(customer); 
		return count+1;
	}
	
	public int sell(Product[] list, int count, Customer[] customerList, 
			int slaesCount, String name, int amount, String phoneNumber) {
		// 각 리스트가 존재하는지 확인
		if(list == null|| customerList == null || salesHistory == null) {
			return -1;
		}
		
		// 각 리스트의 최대 크기가 각 개수보다 크거나 같은지를 체크
		if(list.length < count 
			|| customerList.length < customerCount 
			|| salesHistory.lengh <= salesCount) {
			return -1;
		}
		
		// 제품 정보 검색
		int productIndex = indexOf(list, Count, new Product(name));
		// 고객 정보 검색
		int customerIndex = indexOf(customerList, customerCount, phoneNumber);
		
		if(productIndex == -1 || customerIndex == -1) {
			return -1; // 하나라도 없으면 판매 기록을 할 수 없음
		}
		
		// 판매 정보를 생성 
		Product sellProduct = new Product(list[productIndex]);
		sellProduct.setAmount(amount); // 판매 제품정보
		Sales sales = new Sales(customerList[customerIndex], sellProduct);
		
		// 판매리스트에 판매 정보를 추가
		salesHistory[salesCount] = sales;
		return salesCount+1;
	}
	
	private int indexOf(Customer[] customerList, int customerCount, String phoneNumber) {
		if(customerList == null || phoneNumber == null) {
			return -1;
		}
		for(int i = 0; i < customerCount; i++) {
			if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
				return i;
			}
		}
		return -1;
	}

//	System.out.println("-----새로 오버라이딩-----");
	
	@Override
	public int store(Product[] list, int count, Product product) {
		// 제품 등록하리고 알려주는데, 제품이 있는지 없는지 우선 체크해야함
		// 입고할 제품이 없으면, 입고하지않고 '기존 제품 수(변동없음)'를 알려줌
		if(product == null) { // 매개변수, 참조변수로 넘겨주는건 null 처리를 해야함
			return count;
		}
		// 제품리스트가 없으면
		if(list == null) {
			return 0;
		}
		// 제품 리스트의 크기가 count보다 작으면,
		if(list.length < count) {
			return list.length;
		}
				
		// count : int 는 null을 처리할 수 없음
		// 제품 수가 잘못되면(음수이면),
		if(count < 0) {
			return 0;
		}
		// ---- 프로그램에 대한 예외처리 끝 ---- 귀찮더라도 꼭 해주는 습관 들이기
		
		int index = indexOf(list, count, product);
		// 기존 제품 입고
		if(index != -1) {
			list[index].store(product.getAmount());
			return count;
		}
		
		// 입고 전 예외처리 확인 ㅡ 배열이 꽉 차면(더 추가x)
		if(count == list.length) {
			return count;
		}
		// 새 제품 입고
		list[count] = new Product(product);
		return count+1; // 새 제품 출고해주고 카운트 증가
	}
		
	private int indexOf(Product[] list, int count, Product product) {
		// 제품 정보가 없거나 제품명이 없으면 못 찾음
		if(product == null || product.getName() == null) {
			return -1;
		}
		// 제품 리스트가 없으면
		if(list == null) {
			return -1;
		}
		// 검색할 제품 수가 잘못 입력되면
		if(count > list.length || count < 0) {
			count = list.length; // 11개 검색하라해도 10개까지만 검색하면됨.
		}
			
		for(int i = 0; i < count; i++) {
			// 제품 리스트에서 꺼낸 제품 정보를 tmp에 저장
			Product tmp = list[i];
			// 제품 리스트에 있는 제품이 없거나, 이름이 없거나, 찾을 제품명이 없으면
			if(tmp == null || tmp.getName() == null|| product.getName() == null) {
				return -1; // 못찾겠다. 라고 알려주고
			}
			
			// 제품명끼리 비교하여 같으면 i번지를 반환
			if(tmp.getName().equals(product.getName())) {
				return i;
			} 
		}
		return -1;
	}
		
		