package day7_practice;

public class _22_PrintEx {

	public static void main(String[] args) {
		// �ܼ� ����� ���� 
		// Println() : ���ϴ� ���� ����� �� ���ͱ��� �Է�
		System.out.println("abc");
		System.out.println('a');
		System.out.println(1);
		
		// Print() : ���ϴ� ���� ���, �� �ٿ� �Է���. (\n : ����)
		System.out.print("abc");
		System.out.print('a');
		System.out.print(1);
		
		System.out.println();
				
		// printf() : ���ڿ� ���·� ���� ���ϴ� ���� ���. ���Ĺ��ڸ� �̿�
		// �̷��� �ִ�~ ������ ���
		System.out.printf("String : %s\n", "abc");
		System.out.printf("Integer : %d\n", 1);
		System.out.printf("Char : %c\n", 'a');
		System.out.printf("double : %.2f\n", 3.12345678798675);
	}

}
