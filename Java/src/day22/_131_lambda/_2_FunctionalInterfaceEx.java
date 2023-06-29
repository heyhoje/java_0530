package day22._131_lambda;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

//consumer.accept
public class _2_FunctionalInterfaceEx {

	public static void main(String[] args) {
		Consumer<String> consumer = s-> System.out.println(s);
		consumer.accept("홍길동");
		
		Consumer<Student> consumer2 = s -> System.out.println(s.getName());
		Student std = new Student(1, 1, 2, "홍길동");
		consumer2.accept(std);
		
		System.out.println("----학생정보 전체 출력------");
		// 1. 원래 방식 2. 람다식으로 
		printStudent(std);
		printStudent(std, s->System.out.println(s));
		
		System.out.println("----학생 이름만 출력------");
		printStudentName(std);
		printStudent(std, s->System.out.println(s.getName()));
		
		System.out.println("----매개변수활용 방식------");
		// 매개변수활용 방식. 매개변수로 람다식 넘겨서
		printStudent(std, s-> {
			System.out.println("grade : " + s.getGrade());
			System.out.println("class : " + s.getClassNum());
			System.out.println("number : " + s.getNum());
		});
	}
	
	// (학생 전체) 정보를 출력하는 기능
	public static void printStudent(Student std) {
		System.out.println(std);
	}
	
	// 학생 이름 출력
	public static void printStudentName(Student std) {
		System.out.println(std.getName());
		}
	
	public static void printStudent(Student std, Consumer<Student> consumer) {
		consumer.accept(std);
		}
	}

@Data
@AllArgsConstructor
class Student{
	int grade, classNum, num;
	String name;
	
}