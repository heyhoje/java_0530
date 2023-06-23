package day18.practice;

import java.util.Scanner;

public class _3_StringSplitEx {

	public static void main(String[] args) {
		// 3. 문장을 입력받아 단어의 개수를 출력하는 코드를 작성하세요
		// input : Hi. My name is hong.
		// word : 5
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 문장 입력
		System.out.println("문장을 입력하세요 : ");
		String str = sc.nextLine(); // 공백을 포함하려면 nextLint()!
		int count;
		
		// 2. 공백을 기준으로 단어들 배열에 저장
		String words[] = str.split(" "); // 공백기준 단어 세기
		for(String word : words) {
			System.out.println(word);
		} 
		
		// 3. 개수 출력
		System.out.println("Word : " + words.length); // ** 개수는 배열의 길이!
		
		sc.close();
		
	}

}

// if(indexOf = -1){
//		count++
//	}
