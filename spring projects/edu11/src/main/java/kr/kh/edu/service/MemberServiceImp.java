package kr.kh.edu.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.edu.dao.MemberDAO;
import kr.kh.edu.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	/** 회원가입 */
	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		// 아이디 체크
		// 전체 6~20자, 영문자로 시작, 영문 숫자만 가능
		String regexId = "^[a-zA-Z]\\w{5,19}$";
		if(member.getMe_id() == null || !Pattern.matches(regexId, member.getMe_id())) {
			return false;
		}
		// 비번 체크
		// 전체 6~20자, 영문 숫자만 가능
		String regexPw = "\\w{6,20}";
		if(member.getMe_pw() == null || !Pattern.matches(regexPw, member.getMe_pw())) {
			return false;
		}
		
		return memberDao.insertMember(member);
	}
		 
		// 서버에서 또 한번 체크아이디!!!!!/ 개발자 모드에서 checkId = true; 로 바꿔서 얌생이부릴수도 있어서
//		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
//		if(dbMember != null) {
//			return false;
//		}
//		
//		//비밀번호 암호화
//		//화면에서 입력받은 비밀번호를 암호화
//		String encodedPassword = passwordEncoder.encode(member.getMe_pw());
//		//암호화 된 비번을 회원 정보에 수정
//		member.setMe_pw(encodedPassword);
//		
//		return memberDao.insertMember(member);
//	}

	// 아이디 중복 체크
	@Override
	public boolean checkId(String id) {
		
		return memberDao.selectMember(id) == null;
	}
	
	// 로그인(+정규표현식 메소드)
	@Override
	public MemberVO login(MemberVO member) {
		if(checkIdRegex(member.getMe_id())|| !checkPwRegex(member.getMe_pw())) {
			return null;
		}
		// 아이디와 일치하는 회원 정보를 가져옴
		MemberVO user = memberDao.selectMember(member.getMe_id());
		
		// 아이디와 일치하는 회원 정보가 있고, 비번이 일치하면
		if(user != null && passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
			return user;
		}
		return null;		
	}
	private boolean checkIdRegex(String id){
	//전체 6~20자, 영문으로 시작, 영문 숫자만 가능
		String regexId = "^[a-zA-Z]\\w{5,19}$";
		if(id == null) {
			return false;
		}
		return Pattern.matches(regexId, id);
	}
	private boolean checkPwRegex(String pw){
		String regexPw = "\\w{6,20}";
		if(pw == null) {
			return false;
		}
		return Pattern.matches(regexPw, pw);
	}

	@Override
	public void updateMemberSeesion(MemberVO user) {
		if(user == null) {
			return;
		}
		memberDao.updateMemberSession(user);
	}
}

