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
		
		// 국어 성적이 60점 이상인 학생들의 이름을 출력
		Stream<Student> stream = list.stream();
		stream
			.filter(s-> s.getKor() >= 60) // filter : 전체중에 일부 거를때
			.map(s -> s.getName()) // map : 다른 타입으로 변경
			.forEach(name -> System.out.println(name)); // 바뀐 정보를 출력
			// forEach : 하나씩 꺼내서 작업하는 것
		
		// 국어 성적의 총합(mapToInt/sum)
		stream = list.stream(); // 다시 스트림생성
		int sum = stream.mapToInt(std->std.getKor()).sum();
		System.out.println(sum);
		
		// 국어 성적의 평균(mapToInt/average/getAsDouble)
		stream = list.stream();
		double avg = stream
				.mapToInt(std->std.getKor())
				.average().getAsDouble();
		System.out.println(avg);
		
		// 국어 성적의 총합(reduce 사용)
		stream = list.stream();
		sum = stream.map(std->std.getKor()).reduce(0,(a,b)-> a+b);//reduce로 sum기능 만들기
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