package day15.practice.shop.vo;

import lombok.Data;

@Data
public class Product {
	// 멤버 변수 : 제품 판매와 관련된 제품 정보(실제 제품의 기능 구현x)
	// 제품명, 모델명, 가격, 수량(판매 수량, 전체 재고량), 분류
	private String name;
	private String modelName;
	private int price;
	private int amount;
	private String category;

	// 생성자
	public Product(String name, String modelName, int price, int amount, String category) {
		// super(); // 부모클래스가 있을때 사용 <- object
		this.name = name;
		this.modelName = modelName;
		this.price = price;
		this.amount = amount;
		this.category = category;
	}	
	
	// 메소드
	// 메소드1 : 제품 입고(수량 변경)
	/** 기능 : 제품 입고 기능 => 현재 수량에 주어진 수량을 누정 */
	public void store(int amount) {
		// 창고에 제품을 추가해야하는데 음수가 오면 안됨
		if(amount < 0) {
			return;
		}
		//this.amount += amount;
		accumulate(amount);
	}
	
	// 메소드2 :
	/** 제품 출고 기능 => 현재 수량에서 주어진 수량을 감소*/
	public void release(int amount) {
		if(amount < 0) {
			return;
		}
		//this.amount -= amount;
		accumulate(-amount);
	}
	
	private void accumulate(int amount) {
		this.amount += amount;
	}
	
	public void print() {
		System.out.println("제품명 : " + name);
		System.out.println("모델명 : " + modelName);
		System.out.println("분류 : " + category);
		System.out.println("재고 : " + amount);
		System.out.println("가격 : " + price);
	}
	/** 기능 : 제품명으로 제품 조회
	 * 
	 */
	
}
