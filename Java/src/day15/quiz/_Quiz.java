package day15.quiz;

public class _Quiz {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.println("Hello!");
		}
		
		for(int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}
		
		/* 3.
		 * 객체는 <멤버변수 , 생성자, 메소드> 으로 이루어져 있다.
		 * 객체의 속성을 <멤버 변수?>라 한다.
		 * 객체의 기능을 <메소드>라 한다.
		 * 멤버 변수를 초기화 하는 것을 <생성자?>라 한다.
		 * 메소드에서 멤버 변수와 매개변수의 이름이 같을 때 구별하기위해 <this>키워드를 사용한다.
		 * */
		
		/*4. 
		 * 모든 객체들이 공유하며 1개의 변수만 생성하기 위해서 <static>키워드를 멤버 변수 앞에 붙인다
		 * 같은 자료형을 모아놓은 것을 <배열>라 한다.
		 * 배열은 (0)번지부터 시작
		 * 배열의 길이는 배열명.<length>을 이용하여 알 수 있다.
		 */
		
		int arr[] = new int [10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
			System.out.print(i);
		}
		
		
		
	}
	class A {
		int num;
		public A(int num) {
			this.num = num;
		}
		// public A() {} 1. 기본생성자를 추가하거나 
	}
	//main 메소드
	public A a = new A(10); // 기본생성자 생성, but A클래스에 없음
					   // 2. 10을 추가함

}
