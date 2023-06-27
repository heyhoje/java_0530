package day20._122_collection;

import java.util.Objects;

// �� ��� Ŭ�������� ã�ٰ� equals(�г�, ��, ��ȣ)�� �����ϴ°� ���ƾ�....
// ��Ŭ�� > source > generate hashcode() and equals()

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
