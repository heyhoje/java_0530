package day18.practice;

import java.util.Scanner;

public class _3_StringSplitEx {

	public static void main(String[] args) {
		// 3. ������ �Է¹޾� �ܾ��� ������ ����ϴ� �ڵ带 �ۼ��ϼ���
		// input : Hi. My name is hong.
		// word : 5
		
		Scanner sc = new Scanner(System.in);
		
		// 1. ���� �Է�
		System.out.println("������ �Է��ϼ��� : ");
		String str = sc.nextLine(); // ������ �����Ϸ��� nextLint()!
		int count;
		
		// 2. ������ �������� �ܾ�� �迭�� ����
		String words[] = str.split(" "); // ������� �ܾ� ����
		for(String word : words) {
			System.out.println(word);
		} 
		
		// 3. ���� ���
		System.out.println("Word : " + words.length); // ** ������ �迭�� ����!
		
		sc.close();
		
	}

}

// if(indexOf = -1){
//		count++
//	}
