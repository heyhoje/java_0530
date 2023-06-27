package day20._122_collection;

import java.util.Objects;

// 너 어느 클래스인지 찾다가 equals(학년, 반, 번호)만 설정하는거 놓쳤어....
// 우클릭 > source > generate hashcode() and equals()

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	private int grade, classNum, num;
	private String name;
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
	public void update(int grade, int classNum, int number, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = number;
		this.name = name;
	}
	
	
}
