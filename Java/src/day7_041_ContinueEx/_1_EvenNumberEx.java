package day7_041_ContinueEx;

public class _1_EvenNumberEx {

	public static void main(String[] args) {
		// continue문을 이용한 10 이하 짝수 출력 예제
		
		int i;
		for(i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
//		System.out.println("---------");
//		i = 0;
//		for(i = 1; i <=10; i++) {
//			continue; // 바로 증감식으로 이동, 아래 i출력문으로 이동하지 않는다.
//			System.out.println(i);
//		}
		
		System.out.println("----2-----");
		i = 0;
		for(i = 1; i <=10; i++) {
			if(i % 2 != 0) {
			continue; 
			}
			System.out.println(i);
			
		}
		
//		System.out.println("---------");
//		i = 1;
//		while(i <= 10) {
//			if(i % 2 != 0) {
//				continue; // i가 증가하지 않고 1인 상태로 계속 왔다갔다만 한다.
//			}
//			System.out.println(i);
//			++i;
//		}
		System.out.println("----3-----");
		i = 1;
		while(i <= 10) {
			if(i % 2 != 0) {
				i++;
				continue; // i가 증가하지 않고 1인 상태로 계속 왔다갔다만 한다.
			}
			System.out.println(i);
			++i;
		}
		
		System.out.println("----4-----");
		i = 0;
		while( ++i <= 10) { // 증감식이 조건문에 포함되있어서 무한루프에 빠지지 않고 정상동작함
			if(i % 2 != 0) {
				
				continue; // i가 증가하지 않고 1인 상태로 계속 왔다갔다만 한다.
			}
			System.out.println(i);
			++i;
		}
	}

}
