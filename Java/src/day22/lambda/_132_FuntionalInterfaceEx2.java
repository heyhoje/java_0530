package day22.lambda;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

// Supplier, Function, Operator, Predicate
public class _132_FuntionalInterfaceEx2 {

	public static void main(String[] args) {
		// Supplier 인터페이스
		Supplier<String> supplier = ()-> "Hi";
		System.out.println(supplier.get());
		
		// Function 인터페이스
		// <매개변수, 리턴타입.자료형타입> 학생정보가 주어지면 -> 이름을 리턴하겠다
		Function<Student, String> function = std->std.getName();
		System.out.println(function.apply(new Student(1,1,1,"홍길동")));
		
		// Operator 인터페이스
		// <매개변수 = 리턴타입> 2학년으로 진급
		UnaryOperator<Student> operator = std-> {
			std.setGrade(2);
			return std;
		};
		System.out.println(operator.apply(new Student(1,1,1,"홍길동")));
		
		// Predicate 인터페이스
		// <리턴타입 true, false> 성이 홍인지 아닌지
		Predicate<Student> predicate = s-> s.getName().indexOf("홍길동") == 0;
		System.out.println(predicate.test(new Student(1,1,1,"홍길동")));
		
	}

}
