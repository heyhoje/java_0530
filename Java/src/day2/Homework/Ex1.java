package day2.Homework;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
				//1. �ֿܼ��� ���� 2���� ����(���������)�� �Է¹޾� ����ϴ� �ڵ带 �ۼ��ϼ���
				//ex) ������ ��������ڸ� �Է��ϼ���. (���� : 1+2)
				Scanner scan = new Scanner(System.in);

				System.out.println("�� ������ ��������ڸ� �Է��ϼ���");
				int num1 = scan.nextInt();
				int num2 = scan.nextInt();
				System.out.println("" + num1 + '+' + num2);
				
				//2. �� ������ �Է¹޾� �� ������ ��� ���� ����� ����ϴ� �ڵ带 �ۼ��ϼ���.
				//(�� �ι�° ���ڴ� 0�� �ƴϾ�� �Ѵ�)
				//ex) �� ������ �Է��ϼ���.
				System.out.println("�� ������ ��� ���� ����� ����ϼ���.");
				int num3 = scan.nextInt();
				int num4 = scan.nextInt();

				int sum = num3 + num4;
				int sub = num3 = num4;
				int mul = num3 * num4;
				int div = num3 / num4;
				int mod = num3 % num4;
				System.out.println("" + num3 + '+' + num4 + '=' + sum);
				System.out.println("" + num3 + '-' + num4 + '=' + sub);
				System.out.println("" + num3 + '*' + num4 + '=' + mul);
				System.out.println("" + num3 + '/' + num4 + '=' + div);
				System.out.println("" + num3 + '%' + num4 + '=' + mod);
				
			}
		}
