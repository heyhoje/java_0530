package kr.kh.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.home.dao.MemberDAO;
import kr.kh.home.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{
	
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(MemberVO member) {
		if(member == null|| 
			member.getMe_id() == null||
			member.getMe_pw() == null||
			member.getMe_email() == null) {
			return false;
		}
		// 추가) 유효성 검사
		if(!checkRegexMember(member)) {
			return false; // 유효성검사에 맞지 않으면 false
		}
		// 아이디 중복 체크
		// 아이디로 회원 정보 가져오기(다오야 멤버정보 가져와라)
		MemberVO dbmember = memberDao.selecetMember(member.getMe_id());
		if(dbmember != null) {
			return false; // 아이디 중복
		}
		
		// 회원가입 진행
		String encPW = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPW); // 암호화한거 다시 집어넣어줘
		memberDao.insertMember(member); // 다오야 회원정보 저장해라
		return true;
		
		// return memberDao.insertMember(member); // 도 가능
	}

	private boolean checkRegexMember(MemberVO member) {
		// 필요하면 유효성 검사 코드를 구현
		// 진도나갈때는 유효성 검사까지 했었음!! (영상 참고)
		return true;
	}

//	@Override
//	public MemberVO login(MemberVO member) {
//		if(member == null||member.getMe_id() == null||member.getMe_pw() == null) { // 매개변수 체크
//			return null;
//		} 
//		// 회원가입 정보 확인??
//		MemberVO user = memberDao.selectMember(member.getMe_id());
//		if(user == null) {
//			return null;
//		}
//		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_id())) {
//			return user;
//		}
//		return null;
//	}
}

