package day22._131_lambda;

import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

//consumer.accept
public class _2_FunctionalInterfaceEx {

	public static void main(String[] args) {
		Consumer<String> consumer = s-> System.out.println(s);
		consumer.accept("ȫ�浿");
		
		Consumer<Student> consumer2 = s -> System.out.println(s.getName());
		Student std = new Student(1, 1, 2, "ȫ�浿");
		consumer2.accept(std);
		
		System.out.println("----�л����� ��ü ���------");
		// 1. ���� ��� 2. ���ٽ����� 
		printStudent(std);
		printStudent(std, s->System.out.println(s));
		
		System.out.println("----�л� �̸��� ���------");
		printStudentName(std);
		printStudent(std, s->System.out.println(s.getName()));
		
		System.out.println("----�Ű�����Ȱ�� ���------");
		// �Ű�����Ȱ�� ���. �Ű������� ���ٽ� �Ѱܼ�
		printStudent(std, s-> {
			System.out.println("grade : " + s.getGrade());
			System.out.println("class : " + s.getClassNum());
			System.out.println("number : " + s.getNum());
		});
	}
	
	// (�л� ��ü) ������ ����ϴ� ���
	public static void printStudent(Student std) {
		System.out.println(std);
	}
	
	// �л� �̸� ���
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