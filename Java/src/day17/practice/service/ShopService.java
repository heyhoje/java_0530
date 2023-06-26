package day17.practice.service;

//230622 영상복습 꼭봐라....ㅂㄷㅂㄷ

import day17.practice.vo.Product;

public interface ShopService {// 인터페이스를 만들고 추상메소드를 하나씩 채울 예정

		// 제품 수량을 추가하는 기능(없는 제품이면 제품 추가)
		int store(Product[] list, int count, Product product);
		
		//

}
