package day14._082_switchEx;

public class _1_switchEx {

	public static void main(String[] args) {
		/*switch문에서 case에 변수를 선언하면 
		 * 다른 case에서 선언할 수 없다는걸 보여주는 예제
		 */
		
		// 헷갈리면 switch문 밖에서 변수 선언을 다 하면되지만
		// 배우면서 하고 싶다 하면 잘 이해해야함
		
		int menu = 2;
		
		switch(menu) {
		case 1:
			String title = "제목1";
			System.out.println(title);
			// break; // case문에 break가 선택이지 필수가 아님
					  // => break가 없는 경우 다음 case의 실행문으로 이동
		case 2:
			String title2 = "제목2"; // title이 case 1에 있어서 선언이 안됨 
			// case 2 에서 title을 쓰면 에러 발생
			// => title을 쓰기 위해서는 case 1을 반드시 지나야 하는데, 
			// 	  menu가 2여서 case2가 바로 실행된 경우는 case 1을 건너뛰고
			//    오기 때문에 title이 선언되지 않아서 에러 발생
			
			// System.out.println(title);
			System.out.println(title2);
			break;
		case 3:
			break;
		}
	}

}
