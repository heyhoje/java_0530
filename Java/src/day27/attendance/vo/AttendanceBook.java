package day27.attendance.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import lombok.Data;

//�⼮�� ������ ���ִ� Ŭ����
@Data
public class AttendanceBook implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2595927543542941134L;
	// ����Ʈ�� �⼮�ε��� ������ ���� (�⼮������ ����)
	private List<Attendance> list = new ArrayList<>();
	// �л������� ������ �־���� (�������̶� �л� ���/������ �־����)
	private List<Student> stdList = new ArrayList<>();
	

	public boolean insertStudent(Student std) {
		// �̹� ��ϵ� �л�
		if(stdList.contains(std)) {
			return false;
		}
		// ���л��� �߰����ְ�
		stdList.add(std);
		// �й������� ����
		Collections.sort(stdList,(o1,o2)->{
			return o1.getNum().compareTo(o2.getNum()); //compareTo �� �̿��ϸ� ������ ������
		});
		System.out.println(stdList); // test��
		return true;
		
		// �����ڴ� ���� �ʿ����. �⼮�� �ϳ��� ��� ������ �Ǽ�
	}

	// * Controller - private void attendanceCheck() �� �߰��� �޼ҵ�
	public boolean insertAttendance(Attendance attendance) {
		// �̹� ��ϵ� �⼮����̸� ��� ����,
		if(list.contains(attendance)) {
			return false;
		}
		// ������ ����Ʈ�� �߰�
		list.add(attendance);
		// * ��¥��, �й������� ����
		Collections.sort(list, (o1,o2)->{ // sort = compartor(o1, o2)�񱳸� �ؾ���. (����/0/���)
			// ��¥�� �������, �й������� ����
			if(o1.getDate().equals(o2.getDate())) {
				return o1.getStudent().getNum().compareTo(o2.getStudent().getNum());
			}
			// ��¥�� �ٸ���, ��¥������ ����
			return o1.getDate().compareTo(o2.getDate());
			// o1�� �տ����� 12345(��������) / o2�� �տ����� 54321(��������)
			
		});
		return true;
	}

	public void printAttendance() {
		// �⼮����� ������
		if(list.size() == 0) { 
			System.out.println("��ϵ� �⼮üũ�� �����ϴ�.");
			return;
		}
		// ù �⼮ üũ ������ ��¥�� ���ڿ��� ������(������ �Ǿ��ֱ� ����)
		String dateStr = "";// ��¥�� ���ڿ��� �ٲ��ִ°� << �������� ����
		// ��¥���� ���� �۾�
//		for(Attendance tmp : list) {
//			System.out.println(tmp);
		// ��¥ ������
		for(Attendance tmp : list) {
			// *��¥�� �ٲ�� �������� ��¥�� ��µǵ���.... ��ư� ������� ���� ����
			if(!dateStr.equals(tmp.getDateStr())) {
				System.out.println(tmp.getDateStr());
				dateStr = tmp.getDateStr();
			}
			System.out.println(tmp);
		}
	}
}
