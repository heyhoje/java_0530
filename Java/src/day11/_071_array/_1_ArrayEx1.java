 package day11._071_array;

import java.util.Scanner;

public class _1_ArrayEx1 {

	public static void main(String[] args) {
		/* �л����� ���� ������ �����ϱ� ���� �迭�� �����ϼ���
		 * �л����� �� 10��
		 */
		
		// �ڷ���[] �迭�� = new �ڷ���[����]
		double [] studentKoreaScore = new double[3];
		
		//*double std1, std2, std3;
		  Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			 System.out.print(i + "�л��� ���� ���� : ");
			 studentKoreaScore[i] = sc.nextDouble();
			 //�� �迭��[����] : �ϳ��� ����ó�� ����. 
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(studentKoreaScore[i]); //�ڵ����� �⺻������ �ʱ�ȭ��
		}
		
		// �л� 3���� ���� ���� ����� ���ϰ� ����ϴ� �ڵ带 �ۼ��ϼ���.
		 
		double sum = 0.0;
		double average;
		for (int i = 0; i < 3; i++) {
			sum += studentKoreaScore[i];
			// sum = [0]
			// sum = [0] + [1]
			// sum = [0] + [1] + [2]
		}
		average = sum / 3;
		System.out.println("average : " + average);
		
		sc.close();
	}

}
