package day5.homework;

import java.util.Scanner;

public class _2_UpDownEx {

	public static void main(String[] args) {
//		2. UpDown게임
//		1~100사이의 랜덤한 정수를 생성하고, 이 정수를 맞추는 게임을 구현하세요. *RandomEx 활용
//		랜덤한 수 : 45
//		input : 50 > Down! >> input : 40 > UP! >> input : 45 > Good! //[종료] 맞출때까지
		
		int min = 1, max = 10; // max = 9 로 변경했는데, 그러면 100까지는 안나옴. min <= r *(max - min + 1) + min < max + 1
		int random = (int)(Math.random()*100); // 100 이상의 수도 나옴....  *10이 완벽한 답은 아님
		//random > 1 && random <= 100; // 이 조건을 넣고 싶은데.......
		//System.out.println((Math.random()*(max - min + 1) + min));
		
//		System.out.println(random);
//		System.out.println("랜덤한 수 : " + random);
//		System.out.println("----------");
		int num;
		Scanner scan = new Scanner(System.in);
		
		num = 0; // 0으로 초기화 = while 조건문에서 해당 변수 초기화 하라고 해서 함
		while(num != random) {
		System.out.println("1~100 사이 정수를 맞추시오.");
		System.out.println("숫자 입력 : ");
		num = scan.nextInt();
		
		// 내가 부른 숫자 num, 맞춰야할 숫자 random
		// 범위/구간 이니까 switch문은 아님ㄴㄴㄴㄴ
		//i = random; // i를 안만들어도 될거같은데..... // 삭제
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
