package day8.Practice;

import java.util.Scanner;

public class _4_MethodLCMEx {

	public static void main(String[] args) {
		// 정수 num1과 num2를 입력받아 두 정수의 <최소 공배수>를 구하는 코드를 작성하세요
		// 단, 메소드를 이용할 것
		/* A : ga, B : gb
		 * g : g     최대 공약수
		 * l : A+B/g 최소 공배수
		 * A+B/g == (ga+gb)/g == gab
		 */
		
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int lcm = lcm1(num1, num2);
		System.out.println(num1 + "과 " + num2 + "의 lcm(최소공배수1) : " + lcm);
		
		lcm = lcm2(num1, num2);
		System.out.println(num1 + "과 " + num2 + "의 lcm(최소공배수2) : " + lcm);
		
		sc.close();
		
	}
	
	/** 최대공약수 GCD 메소드 불러옴 */
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0; 
		// num1은 num2의 배수
		// num2는 num1의 약수
	}
	
	public static int gcd(int num1, int num2) {
		for (int i = num1; i >= 1; i--) {
			if(isMultiple(num1, i) && isMultiple(num2, i)) {
				return i;
			}
		}
		return 1;
	}
		
	/** 두 정수가 주어지면 두 정수의 <최소 공배수>를 알려주는 메소드 */
	public static int lcm1(int num1, int num2) {
		for(int i = num1; i <= num1 * num2; i += num1) {
			//      num1 = 2/  2 * 12 = 24/ i는 num1의 배수
			
			if(isMultiple(i, num2)) { // i % num2 == 0 -> num1과 num2 의 공배수
				// 공배수를 찾음. isMultiple은 배수를 찾는 매소드이고,
				// i가 num1의 배수들이기 때문에 i가 num2의 배수이면 num1과 num2의 공배수가 됨
				return i;
			}
		}
		return num1*num2; 
	}
	
	public static int lcm2(int num1, int num2) {
		return num1*num2 / gcd(num1, num2);
						 // num2가 num1의 약수이다 == num1은 num2의 배수이다!!
						 // 최대공배수 = num1이 i의 배수&&num2가 i의 배수 = 
	}
	
	
	}