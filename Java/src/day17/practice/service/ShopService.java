package day17.practice.service;

import day17.practice.vo.Customer;

//230622 영상복습 꼭봐라....ㅂㄷㅂㄷ
//230627 다보고 다 채웠다리

import day17.practice.vo.Product;
import day17.practice.vo.Sales;

public interface ShopService {// 인터페이스를 만들고 추상메소드를 하나씩 채울 예정

		// 제품 입고 - 제품 수량을 추가하는 기능(없는 제품이면 제품 추가)
		int store(Product[] list, int count, Product product);
		
		// 제품 조회 - 제품명이 주어지면 제품 정보를 출력하는 기능
		void printProduct(Product[] list, int count, String search);

		
		// 고객 등록 - 고객을 추가하는 기능
		int registerCustomer(Customer[] customerList, int customerCount, Customer customer);

		// 제품 판매 - 고객에게 제품을 판매하는 기능
		int sell(Product[] list, int count, Customer[] customerList, int customerCount, Sales[] salesHistory,
				int salesCount, String name, int amount, String phoneNumber);

		// 매출 조회 - 매출 정보를 출력하는 기능
		void printSales(Sales[] salesHistory, int salesCount);
}
