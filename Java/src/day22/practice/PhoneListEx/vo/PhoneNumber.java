package day22.practice.PhoneListEx.vo;

import java.util.Objects;
import java.util.regex.Pattern;

import lombok.Data;

// 한 사람의 전화번호 정보
@Data
public class PhoneNumber {
	private String name;
	private String number; // 010-1234-5678 // 정규표시????
	// 01012345678 => 0이 사라질 수 있음/ 8진수가됨
	
	public PhoneNumber(String name, String number) {
		this.name = name;
		
		if(checkNumber(number)) { // checkNumber 메소드 이용해서, 정규표현식에 맞는경우에만 전화번호 입력
			this.number = number;
		}else {
			this.number = ""; //조건과 맞지 않는 경우, 빈문자열
		}
		// this.number = checkNumber(number? number : ""; // 이렇게 한줄로 표현될 수도 있음! 
	}
	// 메소드0 : 전화번호가 010-xxxx-xxxx 패턴이 맞는지 확인해주는 메소드 (일반집전화x) - 정규표현식
	// 외부에서도 객체 생성없이 쓸 수 있게, static과 public을 붙여줌
	public static boolean checkNumber(String num) {
		String regex = "^010(-\\d{4}){2}$"; // regex101 사이트에서 정규표현식 연습
		return Pattern.matches(regex, num); // 문자열과 비교해서 정규표현식이 맞는지 확인
	}
	
	public void setNumber(String number) {
		this.number = checkNumber(number) ? number : this.number; 
		// 원래는 이 코드가 자동으로 생성되지만,
		// 
		
	}
	
	// 이름으로 검색
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneNumber other = (PhoneNumber) obj;
		return Objects.equals(name, other.name);
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(name);
		 // hastSet, HashMap 을 사용할때만 필요. 근데 우리는 list 
	
	
}
