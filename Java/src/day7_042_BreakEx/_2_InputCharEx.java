package day7_042_BreakEx;

import java.util.Scanner;

public class _2_InputCharEx {

	public static void main(String[] args) {
		// q�� �Է��ϸ� �ݺ����� �����ϴ� ����
		
		char ch;
		Scanner sc = new Scanner(System.in);
		
		//for���� ���ǽ��� �����ϸ� ���ѷ���, �׻� true�� ����
		for(; ;) {
			System.out.println("input char (exit : q) : ");
			ch = sc.next().charAt(0); // ch �Է�
			if(ch == 'q') {
				break;
			}
		}
		System.out.println("����");
		
		sc.close();
	}

}
