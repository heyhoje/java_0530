package day20._121_generic;

// ���׸� ���� �ʿ�

public class GenericEx {

	public static void main(String[] args) {
		Student<Integer> std = new Student<Integer>();
		std.kor = 10; // 10.0�� �־��ָ� ������ �߻�
		Student<Double> std2 = new Student<Double>();
		std2.kor = 10.0;
		
		/*Student<Scanner> std3 = new Student<>();
		 * std3.kor = 10;
		 */
		
		print(std2);
		GenericEx.<Double>print(std2);
		GenericEx.print(std2); // std2�� Double�� �Ǿ� �־ print�� T�� Double�̶�� ������ �� �־
	}
	
	// �л� ������ ����ϴ� �޼ҵ�
	public static <T extends Number> void print(Student<T> std) {
		System.out.println(std.grade);
		System.out.println(std.classNum);
		System.out.println(std.num);
		System.out.println(std.name);
		System.out.println(std.kor);
	}

}
