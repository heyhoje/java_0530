package day7._046_BreakEx;

public class _1_HelloworldEx {

	public static void main(String[] args) {
		
		int i = 1;
		while(true) { // 무한루프 - break문 이용
			System.out.println("Hello World!");
			// break 위치가 여기라면, 1번 출력하고 break처리됨
			// 5번 출력하고 종료하려고함
			if(i == 5) {
				break; //  5번출력하면 break하고
			}
			i++; // 아니면 증가하세요
			
		}
	}

}
