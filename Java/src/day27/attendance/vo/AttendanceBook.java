package day27.attendance.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import lombok.Data;

//출석이 여러개 모여있는 클래스
@Data
public class AttendanceBook implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2595927543542941134L;
	// 리스트는 출석부들을 가지고 있음 (출석했을때 생성)
	private List<Attendance> list = new ArrayList<>();
	// 학생정보도 가지고 있어야함 (개강전이라도 학생 명단/정보는 있어야함)
	private List<Student> stdList = new ArrayList<>();
	

	public boolean insertStudent(Student std) {
		// 이미 등록된 학생
		if(stdList.contains(std)) {
			return false;
		}
		// 새학생을 추가해주고
		stdList.add(std);
		// 학번순으로 정렬
		Collections.sort(stdList,(o1,o2)->{
			return o1.getNum().compareTo(o2.getNum()); //compareTo 를 이용하면 정렬이 쉬워짐
		});
		System.out.println(stdList); // test용
		return true;
		
		// 생성자는 따로 필요없음. 출석부 하나만 들고 있으면 되서
	}

	// * Controller - private void attendanceCheck() 에 추가된 메소드
	public boolean insertAttendance(Attendance attendance) {
		// 이미 등록된 출석기록이면 등록 실패,
		if(list.contains(attendance)) {
			return false;
		}
		// 맞으면 리스트에 추가
		list.add(attendance);
		// * 날짜순, 학번순으로 정렬
		Collections.sort(list, (o1,o2)->{ // sort = compartor(o1, o2)비교를 해야함. (음수/0/양수)
			// 날짜가 같으면면, 학번순으로 정렬
			if(o1.getDate().equals(o2.getDate())) {
				return o1.getStudent().getNum().compareTo(o2.getStudent().getNum());
			}
			// 날짜가 다르면, 날짜순으로 정렬
			return o1.getDate().compareTo(o2.getDate());
			// o1이 앞에오면 12345(오름차순) / o2가 앞에오면 54321(내림차순)
			
		});
		return true;
	}

	public void printAttendance() {
		// 출석기록이 없으면
		if(list.size() == 0) { 
			System.out.println("등록된 출석체크가 없습니다.");
			return;
		}
		// 첫 출석 체크 정보의 날짜를 문자열로 가져옴(정렬이 되어있기 때문)
		String dateStr = "";// 날짜를 문자열로 바꿔주는거 << 도서관리 참고
		// 날짜빼고 먼저 작업
//		for(Attendance tmp : list) {
//			System.out.println(tmp);
		// 날짜 데려옴
		for(Attendance tmp : list) {
			// *날짜가 바뀌는 순간에만 날짜가 출력되도록.... 어렵고 어려워서 이해 못함
			if(!dateStr.equals(tmp.getDateStr())) {
				System.out.println(tmp.getDateStr());
				dateStr = tmp.getDateStr();
			}
			System.out.println(tmp);
		}
	}
}
