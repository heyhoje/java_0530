package day22.practice.PhoneListEx.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneBook {

	// 전화번호 리스트를 관리
	private List<PhoneNumber> list = new ArrayList<>();

	///기능추가
	// 전화번호 추가
	public boolean insertPhone(String name, String number) {
		// 이름과 전화번호를 이용하여 전화번호 객체를 생성
		PhoneNumber pn = new PhoneNumber(name, number);
		// 전화번호가 비어 있으면 => 전화번호 패턴에 맞지 않으면 저장x
		if(pn.getNumber().length() == 0) {
			return false;
		}
		// 전화번호가 패턴에 맞으면 전화번호부에 번호를 추가
		list.add(pn); // 패턴에 맞으면 추가하고 리턴
		return true;
	}
	// 전화번호 수정 : 이름
	public boolean updateName(String name, String undateName) {
		// name과 일치하는 전화번호를 찾아야함
		// index와 contains 둘다 가능. but 수정해야하기때문에 index로 가자
		
		// 전화번호부에 수정할 이름에 해당하는 전화번호가 어디에 있는지 확인
		int index = list.indexOf(new PhoneNumber(name, ""));
			// index는 equals를 불러오는게 아니라 Objects로 호출
			// list는 phoneNumber / undateName은 String 으로 자료형이 다름
			// 같게 만들어야하는데 그래서 new PhoneNumber() 하는데 잘 이해는 안됨
		
		// 없으면 수정이 안됨 => 메소드를 종료
		if(index == -1) {
			return false;
		}
		// 찾은 전화번호의 이름을 수정
		// 전화번호부에서 이름과 일치하는 전화번호를 가져옴(리스트에서 인덱스에 있는 것을 가져오고)
		PhoneNumber pn = list.get(index); 
		// 가져온 전화번호의 이름을 수정 (업데이트 이름을 셋한다.)
		// 참조변수는 setter를 통해서 멤버들의 정보를 변경 가능하다.
		pn.setName(undateName); 
		// => list.get(index).setName(updateName); 으로 합쳐서 쓸수도 있음
		
//			// 기본자료형은 = 을 이용하면 '값'을 복사하기 때문에 한쪽의 값이 바뀌어도 다른쪽은 안바뀜
//		int num1 = 1;
//		int num2 = num1;
//		num2 = 10;
//			// 참조변수는 = 을 이용하면 '주소값'을 복사하기 떄문에 한쪽의 값이 바뀌면 다른쪽도 바뀜
//			// 예를 들면 pn1에 저장된 주소 0x1000
//		PhoneNumber pn1 = new PhoneNumber("a", "010-1111-2222");
//			// pn1에 저장된 주소 : 0x1000, pn2에 저장된 주소도 0x1000
//		PhoneNumber pn2 = pn1;
//			//0x1000번지에 있는 객체의 name을 Lim으로 수정
//		pn2.setName("Lim);
		return true; // 전화번호가 있다면 이름은 따로 체크를 안하기 때문에 true
	}
	
	// 전화번호 수정 : 번호
	public boolean updateNumber(String name, String number) {
		// name과 일치하는 전화번호부를 찾음
		int index = list.indexOf(new PhoneNumber(name, number));
		// 일치하는 전화번호부가 없으면 수정 실패
		if(index == -1) {
			return false;
		}
		// number가 전화번호 패턴이 맞는지 확인하기 위해서(라고라?????)
			// 전화번호 패턴이 맞으면, 전화번호 객체를 생성했을때, 전화번호가 있음
			// 패턴이 맞지 않으면, 빈 문자열이 있기 떄문에(생성해야함.....)
		// 있으면, name과 number를 이용하여 전화번호 객체를 생성
			// => public static boolean checkNumber 로 바꿔서 이제 생성안해도됨
			// 전화번호 객체를 생성하는 대신 checkNumber를 이용!!!! good!!

		// number가 전화번호 패턴이면 전화번호를 수정
		if(!PhoneNumber.checkNumber(number)) {
			return false;
		}
		list.get(index).setNumber(number);
		return true;
	}
	
	// 전화번호 수정 : 이름, 번호
	public boolean update(String name, String updateName, String number) {
		PhoneNumber pn = new PhoneNumber(name, number);
		
		// name을 이용하여 전화번호부 검색
		int index = list.indexOf(pn); // pn <= new PhoneNumber(name, number)
		// 없으면 수정실패 
		if(index == -1) {
			return false;
		}
		// number가 전화번호 패턴에 안맞으면 실패
		if(!PhoneNumber.checkNumber(number)) {
			return false;
		}
		// 찾았으면, 기존에 있는 전화번호를 삭제하고
		list.remove(index);
		// updateName과 number를 이용하여 전화번호 객체를 생성한 후 추가 (하는게 코드가 편함)
		pn.setName(updateName); // <<<<< 이건 왜 넣는거죠?????????????
		list.add(pn);
		return true;
	}
	// 전하번호 삭제
	public boolean delete(String name) {
		// name으로 PhoneNumber 객체를 생성 후 바로 삭제 요청
		return list.remove(new PhoneNumber(name, ""));
		// 알아서 삭제됐으면 true, 실패했으면 false 알려주기 떄문;;;;;
	}
		
//위의 방식처럼 // name과 일치하는 전화번호 있는지 확인
//			int index = list.indexOf(new PhoneNumber(name, ""));
//			// 없으면 실패
//			if(index == -1) {
//				return false
//			}
//			// 있으면 삭제
	
	// 전화번호 출력
	public void print(Predicate<PhoneNumber> p) {
		for(PhoneNumber pn : list) {
			if(p.test(pn)) {
				System.out.println(pn);
			}
		}
	}
}
