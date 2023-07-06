package day27.attendance.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
// @AllArgsConstructor
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 107837677974301860L;
	// �������
	private String num;
	private String name;
	
	// �й�, �̸��� �̿��� ������
	public Student(String num, String name) {
		this.num = num;
		this.name = name;
	}

	// * ��������� ����
	public Student(Student tmp) {
		this(tmp.num, tmp.name);
	}

	// ���߿� �й��� �̿��� ���� ������, �й����θ� ��ü�� ������ �Ǻ�
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(num, other.num);
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

	// �����Ͱ� �������� ��� toString���� ����
	@Override
	public String toString() {
		return num + " " + name;
	}
	
	
	
}
