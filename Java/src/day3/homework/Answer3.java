package day3.homework;

import java.util.Scanner;

public class Answer3 {

	public static void main(String[] args) {
		//����(M:����,W:����)�� �Է¹޾� M�̸� ������, W�̸� ������ ����ϴ� �ڵ带 �ۼ��ϼ���. if�� �̿�
		
		//���ڷ�
		char gender;
		System.out.println("input gender : ");
		Scanner scan = new Scanner(System.in);
		gender = scan.next().charAt(0);//�����ϳ� �Է¹ޱ� / .charAt(0);
		String result = "";//��¹��� �ΰ� �ִ°� ������
				
		//���ǿ����� >> if ������
		if (gender == 'M') { // if(gender.equals(Man)) �� �Ȱ����ǰ�? ���� MAN, WOMAN, result ���� ���� ���ص��ǳ�?? 
			// a = b �� �ƴϰ�, ���ڿ��� '����'�� '=='
			//System.out.println("Are you a woman? " + "man");
			result = "man";
		}
		
		if (gender == 'W') {
			//System.out.println("Are you a woman? " + "woman");
			result = "woman";
		}
		
		System.out.println("Are you a woman? " + result); // ��¹��� �ڿ��� �ٸ��� ������ result �� �����غ�
		
		
		
		scan.close();
		
	}

}
