package day5.homework;

import java.util.Scanner;

public class _Answer2 {

	public static void main(String[] args) {
//		2. UpDown게임
//		1~100사이의 랜덤한 정수를 생성하고, 이 정수를 맞추는 게임을 구현하세요. *RandomEx 활용
		
		//랜덤한 수를 생성 (및 출력)
		
		int min = 1, max = 100;
		int random;
		random = (int)(Math.random()*(max - min +1) + min);
		int num = min -1;// 1~100이 아닌 정수로 초기화 하면됨. 최소값 -1을 해서 랜덤으로 나올 수 없는 수 설정.
		Scanner scan = new Scanner(System.in);

		
		// ****순서 꼬였당 https://github.com/st8324/java_0530 코드 참고해서 수정해두기 ****// 
		System.out.println(random);
		
		// 반복문 : 맞출때까지, 입력한 정수가 정답이 아니면 반복
			// 정수를 입력
			// 정수와 정답을 비교하여 판별
		//System.out.println(random);
		//System.out.println("랜덤한 수 : " + random);
		//System.out.println("----------");
		
		num = 0; // 0으로 초기화 = while 조건문에서 해당 변수 초기화 하라고 해서 함
		while(num != random) {
		System.out.println("1~100 사이 정수를 맞추시오.");
		System.out.println("숫자 입력 : ");
		num = scan.nextInt();
		
		// 내가 부른 숫자 num, 맞춰야할 숫자 random
			if(random == num) {
				System.out.println("GOOOOOD!!");
			}else if(random < num) {
				System.out.println("DOWN!");
			}else {
				System.out.println("UP!");
			}
		}
		scan.close();
	}

}
