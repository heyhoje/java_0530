package day22.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class _133_StreamEx2 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student(1,1,1,"Hong", 100, 90, 80),
				new Student(1,1,2,"Ling", 10, 30, 50),
				new Student(2,1,1,"Park", 60, 30, 100),
				new Student(3,1,1,"Lee", 100, 90, 70),
				new Student(3,3,2,"Kim", 30, 100, 50));
		
		// ���� ������ 60�� �̻��� �л����� �̸��� ���
		Stream<Student> stream = list.stream();
		stream
			.filter(s-> s.getKor() >= 60) // filter : ��ü�߿� �Ϻ� �Ÿ���
			.map(s -> s.getName()) // map : �ٸ� Ÿ������ ����
			.forEach(name -> System.out.println(name)); // �ٲ� ������ ���
			// forEach : �ϳ��� ������ �۾��ϴ� ��
		
		// ���� ������ ����(mapToInt/sum)
		stream = list.stream(); // �ٽ� ��Ʈ������
		int sum = stream.mapToInt(std->std.getKor()).sum();
		System.out.println(sum);
		
		// ���� ������ ���(mapToInt/average/getAsDouble)
		stream = list.stream();
		double avg = stream
				.mapToInt(std->std.getKor())
				.average().getAsDouble();
		System.out.println(avg);
		
		// ���� ������ ����(reduce ���)
		stream = list.stream();
		sum = stream.map(std->std.getKor()).reduce(0,(a,b)-> a+b);//reduce�� sum��� �����
		System.out.println(sum);
	}

}

@Data
@AllArgsConstructor
class Student{
	int grade, classNum, num;
	String name;
	int kor, math, eng;
}