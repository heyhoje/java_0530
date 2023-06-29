package day22.lambda;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

// Supplier, Function, Operator, Predicate
public class _132_FuntionalInterfaceEx2 {

	public static void main(String[] args) {
		// Supplier �������̽�
		Supplier<String> supplier = ()-> "Hi";
		System.out.println(supplier.get());
		
		// Function �������̽�
		// <�Ű�����, ����Ÿ��.�ڷ���Ÿ��> �л������� �־����� -> �̸��� �����ϰڴ�
		Function<Student, String> function = std->std.getName();
		System.out.println(function.apply(new Student(1,1,1,"ȫ�浿")));
		
		// Operator �������̽�
		// <�Ű����� = ����Ÿ��> 2�г����� ����
		UnaryOperator<Student> operator = std-> {
			std.setGrade(2);
			return std;
		};
		System.out.println(operator.apply(new Student(1,1,1,"ȫ�浿")));
		
		// Predicate �������̽�
		// <����Ÿ�� true, false> ���� ȫ���� �ƴ���
		Predicate<Student> predicate = s-> s.getName().indexOf("ȫ�浿") == 0;
		System.out.println(predicate.test(new Student(1,1,1,"ȫ�浿")));
		
	}

}
