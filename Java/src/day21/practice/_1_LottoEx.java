package day21.practice;

import java.util.HashSet;
import java.util.Scanner;

// set도 equals를 기준으로 중복체크함. 오버라이딩 잘 해줘야함. 

public class _1_LottoEx {

	public static void main(String[] args) {
		/* Set을 이용한 로또 프로그램 */
		int bonus;
		HashSet<Integer> lotto = new HashSet<>();
		HashSet<Integer> user = new HashSet<>();
		int min = 1, max = 45;
		
		// 로또 번호를 랜덤으로 생성(1~45)
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random()*(max-min+1) +min));
		}
		// 보너스 생성
		do {
			bonus = (int)(Math.random()*(max-min+1) +min);
		} while(lotto.contains(bonus));
		
		System.out.println("----로또번호 확인----");
		System.out.println(lotto);
		System.out.println("bonus : " + bonus);
		
		// 사용자 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 6개를 입력하세요 : ");
		while(user.size() < 6) {
			user.add(sc.nextInt());
		}
		sc.close();
		
		// 등수 체크
		// 일치하는 개수 확인
		int count = 0;
		for(Integer tmp : user) {
			if(lotto.contains(tmp)) {
				count++;
			}
		}
		// 개수를 이용하여 등수 체크
		switch(count) {
		case 6: System.out.println("1등"); break;
		case 5:
			if(user.contains(bonus)) {
				System.out.println("2등");
			}else {
				System.out.println("3등");
			}
			break;
		case 4: System.out.println("4등"); break;
		case 3: System.out.println("5등"); break;
		default: System.out.println("꽝");
		}
	}

}
