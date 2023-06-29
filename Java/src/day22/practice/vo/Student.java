package day22.practice.vo;


import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student{
	int grade, classNum, num;
	String name;
	
	// 이름을 제외하고 equals 생성
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}
	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}
	
//	public Student(int grade, int classNum, int num, String name) {
//		super();
//		this.grade = grade;
//		this.classNum = classNum;
//		this.num = num;
//		this.name = name;
//	}
	
	
}