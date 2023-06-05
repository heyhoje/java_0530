package day5_practice;

public class _1_MultiplicationTableEx {

	public static void main(String[] args) {
		// 1. 구구단 2단을 출력하는 코드를 작성하세요.
		/*반복횟수 : i는 1부터 9까지 1씩 증가
		 * 규칙성 : 2 * i = 2*i를 출력 
		 */
		
		int max = 9;
		int i = 1;
		while (i <= max) {
			System.out.println(2 + " * " + i + " = " + 2*i); //와씨 괄호하나 했다고 나온다고????// 아니 괄호문제도 아니었다고? 아까는 2*1로 무한루프 걸려놓곤!!!!!
			++i;
		}
	}

}
