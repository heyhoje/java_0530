package day18.practice;

import java.util.Scanner;

public class _22_StringCharAtEx {

	public static void main(String[] args) {
		// 2. 영문 소문자로 된 문자열을 입력받아 알파벳이 각각 몇개 있는지 확인하는 코드를 작성하세요.
		/* input : hello world
		 * a : 0 => 0개는 출력 안함
		 * d
		 * e
		 * h
		 * l
		 * o
		 * r
		 * w
		 */
		
		// 이중반복문을 쓰지 않고 배열로 저장해서 진행
		Scanner sc = new Scanner(System.in);
		int alphabet[] = new int[26]; // 각 알파벡 개수를 저장하는 배열. 
									  // 0번지 : a의 개수, 1번지 : b의 개수
		
		//입력
		System.out.print("input : ");
		String str = sc.nextLine();
		
		// 반복 : 문자열 길이만큼
			// 문자열의 한글자씩 가져와서 알파벳을 확인하여 알파벳 개수를 증가
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i); // 와우 이걸 이렇게 쓰는거였어?
			// ch가 알파벳 소문자인 경우, 0에서 25사이의 값이 나옴
			int distance = ch - 'a'; // a -a = 0, b -a = 1,

			// 영문 소문자가 아닌 경우,
			if(distance < 0 || distance > 25) {
				continue; // 그냥 건너뜀.
			}
			// 맞는 경우, 
			alphabet[distance]++;
		}
		// 알파벳 개수 추가 
		for (int i = 0; i < alphabet.length; i++) {
			
			if(alphabet[i] == 0) {
				continue; // i번지값이 0이면 건너뛴다.
			}
			System.out.println((char)('a'+ i) + " : " + alphabet[i]); // a ~ z 까지 쭉 출력
		}
				sc.close();
		
	}

}
